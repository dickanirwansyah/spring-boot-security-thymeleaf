# contoh spring security dengan thymeleaf

`1. berikut adalah table database dari example project spring security`

a. Table users<br/>
b. Table roles<br/>
c. Table users_roles<br/>
d. Table persistent_logins<br/>

`2. import data ke tiap tabel, berikut adalah sql datanya`

a. Table roles
```INSERT INTO roles (idroles, name) VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_ACTUATOR'),
(3, 'ROLE_USER');
```
<br/>
b. Table users

```
INSERT INTO users (idusers, email, password, name) VALUES 
(1, 'admin@gmail.com', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
(3, 'user@gmail.com', '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'User');
```

`*note*`
<br/>
password dari admin@gmail.com -> admin<br/>
password dari user@gmail.com -> user

<br/>

c. Table users_roles
```
insert into users_roles(idusers, idroles) values
(1,1),
(1,2),
(1,3),
(3,2);
```

`3. Jalankan aplikasi localhost:10000/` 
<br/>
<br/>
<img src="https://cdn3.imggmi.com/uploads/2019/8/31/9ff2608308e132b5accf7260848ab670-full.png"/>
