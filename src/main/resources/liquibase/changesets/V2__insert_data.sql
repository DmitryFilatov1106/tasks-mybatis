INSERT INTO users (name, username, password)
VALUES ('Ivan Ivanov', 'ii@mail.ru', '$2a$10$Xl0yhvzLIaJCDdKBS0Lld.ksK7c2Zytg/ZKFdtIYYQUv8rUfvCR4W'),
       ('Petr Petrov', 'pp@mail.ru', '$2a$10$fFLij9aYgaNCFPTL9WcA/uoCRukxnwf.vOQ8nrEEOskrCNmGsxY7m');

INSERT INTO tasks (title, description, status, expiration_date)
VALUES ('BUY CHEESE', NULL, 'TODO', '2023-01-29 12:00:00'),
       ('DO HOMEWORK', 'MATH, PHYSICS, LITERATURE', 'IN_PROGRESS', '2023-01-31 00:00:00'),
       ('CLEAN ROOMS', NULL, 'DONE', NULL),
       ('CALL MIKE', 'ASK ABOUT MEETING', 'TODO', '2023-02-01 00:00:00');

INSERT INTO users_tasks (task_id, user_id)
VALUES (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

INSERT INTO users_roles (user_id, role)
VALUES (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');