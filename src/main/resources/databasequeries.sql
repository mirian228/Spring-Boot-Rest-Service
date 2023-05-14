CREATE DATABASE restserviceproject;
USE restserviceproject;
CREATE TABLE Country (
	id INT PRIMARY KEY AUTO_INCREMENT,
    capital VARCHAR(255),
    country_name VARCHAR(255)
);

INSERT INTO COUNTRY(capital, country_name) VALUES("Delhi", "India");
INSERT INTO COUNTRY(capital, country_name) VALUES("Washington", "USA");
INSERT INTO COUNTRY(capital, country_name) VALUES("London", "England"); 