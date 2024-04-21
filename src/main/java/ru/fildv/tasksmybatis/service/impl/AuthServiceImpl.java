package ru.fildv.tasksmybatis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.fildv.tasksmybatis.database.entity.user.User;
import ru.fildv.tasksmybatis.http.dto.auth.JwtRequest;
import ru.fildv.tasksmybatis.http.dto.auth.JwtResponse;
import ru.fildv.tasksmybatis.http.security.JwtTokenProvider;
import ru.fildv.tasksmybatis.service.AuthService;
import ru.fildv.tasksmybatis.service.UserService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponse login(final JwtRequest loginRequest) {
        var token = new UsernamePasswordAuthenticationToken(
                loginRequest.username(), loginRequest.password());
        authenticationManager.authenticate(token);
        User user = userService.getByUsername(loginRequest.username());
        return JwtResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .accessToken(jwtTokenProvider
                        .createAccessToken(user.getId(),
                                user.getUsername(),
                                user.getRoles()))
                .refreshToken(jwtTokenProvider
                        .createRefreshToken(user.getId(), user.getUsername()))
                .build();
    }

    @Override
    public JwtResponse refresh(final String refreshToken) {
        return jwtTokenProvider.refreshUserToken(refreshToken);
    }
}
