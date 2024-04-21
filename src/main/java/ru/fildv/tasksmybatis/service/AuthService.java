package ru.fildv.tasksmybatis.service;

import ru.fildv.tasksmybatis.http.dto.auth.JwtRequest;
import ru.fildv.tasksmybatis.http.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest jwtRequest);

    JwtResponse refresh(String refreshToken);
}
