INSERT INTO roles (idroles, name) VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_ACTUATOR'),
(3, 'ROLE_USER');

INSERT INTO users (idusers, email, password, name) VALUES 
(1, 'admin@gmail.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
(3, 'user@gmail.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'User');


insert into users_roles(idusers, idroles) values
(1,1),
(1,2),
(1,3),
(3,2);
