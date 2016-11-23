## Create Database and Database User (MySQL)
create database `brand`;
grant all privileges on `brand`.* to 'brand'@'localhost' identified by 'brand' with grant option;
grant all privileges on `brand`.* to 'brand'@'%' identified by 'brand' with grant option;