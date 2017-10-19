-- Create commercial database
DROP DATABASE CDB;
CREATE DATABASE CDB;
USE CDB;


-- Create Table for Commercials
DROP TABLE IF EXISTS Commercial;

CREATE TABLE Commercial
(
	commercialID INT PRIMARY KEY AUTO_INCREMENT,
    company VARCHAR(40),
    credit DOUBLE,
    startDate DATETIME
);

INSERT INTO Commercial(company, credit, startDate) VALUES
('Starbucks', 10.00, '2017-08-10'),
('HM', 25.00, '2017-09-25'),
('Hemköp', 5.75, '2017-10-01'),
('Time', 5.25, '2017-09-29');

SELECT * FROM Commercial;

DROP USER IF EXISTS 'app'@'localhost';
CREATE USER 'app'@'localhost' IDENTIFIED BY 'apppassword';
GRANT ALL ON CDB.* TO 'app'@'localhost';
