insert into users(username, firstname, lastname, password, role)
VALUES ('admin','admin', 'admin', '$2a$10$4R2NCOV.sMJ9DDMOPY8FPO4boay4/VWI9Syd8YA/YY9Fjz0V7eg/u', 'ROLE_ADMIN')
on conflict do nothing;