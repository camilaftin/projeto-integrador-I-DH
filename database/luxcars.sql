CREATE DATABASE luxcars;

USE luxcars;

CREATE TABLE IF NOT EXISTS roles (
ID BIGINT (20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
name_role VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (

ID BIGINT (20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
email VARCHAR (200) NOT NULL UNIQUE,
password VARCHAR (60) NOT NULL, 
first_name VARCHAR (100) NOT NULL,
surname VARCHAR (100) NOT NULL,
roles_id BIGINT NOT NULL,
FOREIGN KEY (roles_id) REFERENCES roles(ID)

);

CREATE TABLE IF NOT EXISTS categories (

ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
descritpion VARCHAR (200) NOT NULL,
url_image VARCHAR (255) NOT NULL,
qualification VARCHAR (100) NOT NULL UNIQUE

);

CREATE TABLE IF NOT EXISTS cities (

ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name_city VARCHAR (100) NOT NULL,
country VARCHAR(100) NOT NULL

);



CREATE TABLE IF NOT EXISTS cars (
ID BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name_car VARCHAR (100) NOT NULL,
descritpion VARCHAR (2000) NOT NULL,
price DECIMAL (10,2) NOT NULL,
year_car INT (4) NOT NULL,
highlight BOOLEAN DEFAULT false NOT NULL,
category_id BIGINT NOT NULL,
city_id BIGINT NOT NULL,
FOREIGN KEY (category_id) REFERENCES categories(ID),
FOREIGN KEY(city_id) REFERENCES cities(ID)

);

CREATE TABLE IF NOT EXISTS bookings (
ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
start_date DATE,
start_time TIME,
end_date DATE,
car_id BIGINT NOT NULL,
user_id BIGINT NOT NULL,
FOREIGN KEY(car_id) REFERENCES cars(ID),
FOREIGN KEY(user_id) REFERENCES users(ID)

);


CREATE TABLE IF NOT EXISTS caracteristics (
  ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name_caracteristcs VARCHAR(255) NOT NULL,
  icon VARCHAR(255) NOT NULL,
  unit_of_measurement VARCHAR(25) NULL
);


CREATE TABLE IF NOT EXISTS car_caracteristics (
  ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  car_id BIGINT NOT NULL,
  caracteristics_id BIGINT NOT NULL,
  value_caracteristic VARCHAR(50) NULL,
  FOREIGN KEY (car_id) REFERENCES cars(id),
  FOREIGN KEY (caracteristics_id) REFERENCES caracteristics(id)
);


CREATE TABLE IF NOT EXISTS images (

ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
title VARCHAR (100) NOT NULL,
url VARCHAR (255) NOT NULL,

);

CREATE TABLE IF NOT EXISTS cars_images(
ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
car_id BIGINT NOT NULL,
image_id BIGINT NOT NULL,
FOREIGN KEY (car_id) REFERENCES cars(ID),
FOREIGN KEY (image_id) REFERENCES images(ID)
);


CREATE TABLE IF NOT EXISTS contact_us_message (
  ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR (200) NOT NULL,
  title VARCHAR (300) NOT NULL,
  body VARCHAR (6000) NOT NULL
);

/*insercao nas tabelas de usuarios
  Senha do role admin = Fulano12!
  Senha do role user = Beltrano12!
*/

INSERT INTO roles (name_role) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name_role) VALUES ('ROLE_USER');

INSERT INTO users(email, password, first_name, surname, roles_id) values ('administrador@mail.com', '$2a$12$IOK8StaznX4/43zA3vPtHOV40wW5APGLpvZh31GiexOYH5B57jTZO', 'Camila', 'Ferreira', (SELECT ID FROM roles WHERE name_role = 'ROLE_ADMIN'));
INSERT INTO users(email, password, first_name, surname, roles_id) values ('usercomum@mail.com', '$2a$12$CAlvUt4F4IR4d/rv.hMPWeZC16cGGmGxGB4m37GogRBysdpqj3DfO', 'Beltrano', 'de tal', (SELECT ID FROM roles WHERE name_role = 'ROLE_USER'));

/*insercao nas tabelas de catergories*/
INSERT INTO categories(descritpion, url_image, qualification) values ('ferrari gt', '', 'conversivel');

/*insercao nas tabelas de cidade*/
INSERT INTO cities(name_city, country) values ('Napoli', 'Italia');

INSERT INTO cars (name_car, descritpion, price, year_car, highlight, category_id, city_id) values ('GT 400', 'descricao qualquer', 1250.58, 2020, true, 1,1);

INSERT INTO bookings (start_date, start_time, end_date, car_id, user_id) VALUES ('2023-03-23', '14:30:00', '2023-03-25', 1, 1);

INSERT INTO caracteristics(name_caracteristcs, icon) values ('potência de 340 cv e torque de 44,1 m', '');

INSERT INTO car_caracteristics(car_id, caracteristics_id) values (1,1);

INSERT INTO images(title, url, car_id) values ('imagem da ferrari gt 400', '',1);
