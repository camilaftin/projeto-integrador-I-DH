CREATE DATABASE luxcars;

USE luxcars;

CREATE TABLE users (

id_user BIGINT (20) AUTO_INCREMENT NOT NULL PRIMARY KEY,
email VARCHAR (200) NOT NULL,
password VARCHAR (60) NOT NULL, 
first_name VARCHAR (100) NOT NULL,
surname VARCHAR (100) NOT NULL,
roles VARCHAR(20) NOT NULL

);

CREATE TABLE categories (

id_category BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
descritpion VARCHAR (200) NOT NULL,
url_image VARCHAR (255) NOT NULL,
model VARCHAR (100) NOT NULL,
rating SMALLINT NOT NULL CHECK (
    rating > 0
    AND rating <= 5
  )

);

CREATE TABLE car (

id_car BIGINT (20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name_car VARCHAR (100) NOT NULL,
category_id BIGINT,
FOREIGN KEY (category_id) REFERENCES categories(id_category)

);
