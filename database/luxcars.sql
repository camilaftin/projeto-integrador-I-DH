#criacao do database
CREATE DATABASE luxcars;

USE luxcars;

#criacao das tabelas
CREATE TABLE users (

ID BIGINT (20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
email VARCHAR (200) NOT NULL UNIQUE,
password VARCHAR (60) NOT NULL, 
first_name VARCHAR (100) NOT NULL,
surname VARCHAR (100) NOT NULL,
roles SMALLINT NOT NULL CHECK (roles IN (1,2)),
CHECK (length(password) >= 8 AND password REGEXP '[0-9]' AND password REGEXP '[A-Z]')

);

CREATE TABLE categories (

ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
descritpion VARCHAR (200) NOT NULL,
url_image VARCHAR (255) NOT NULL,
qualification VARCHAR (100) NOT NULL UNIQUE

);

CREATE TABLE car (

ID BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name_car VARCHAR (100) NOT NULL,
category_id BIGINT NOT NULL,
FOREIGN KEY (category_id) REFERENCES categories(ID)

);
