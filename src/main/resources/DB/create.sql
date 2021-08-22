SET MODE Postgresql;

CREATE DATABASE news_java;

\c news_java

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 employee VARCHAR
);

CREATE TABLE IF NOT EXISTS news (
id int PRIMARY KEY auto_increment,
name VARCHAR,
users VARCHAR,
headlines VARCHAR,
author VARCHAR
);

CREATE TABLE IF NOT EXISTS users(
id int PRIMARY KEY auto_increment,
name VARCHAR,
roles VARCHAR,
departments VARCHAR
);

CREATE TABLE IF NOT EXISTS department_users(
id serial PRIMARY KEY,
usersId INTEGER,
departmentId INTEGER
);

CREATE DATABASE news_test WITH TEMPLATE news_java;