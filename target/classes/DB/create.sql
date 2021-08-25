SET MODE PostgreSQL;

CREATE DATABASE news_java;
\c news_java
CREATE TABLE IF NOT EXISTS departments (id serial PRIMARY KEY, name VARCHAR, description VARCHAR, employee VARCHAR);

CREATE TABLE IF NOT EXISTS news (id serial PRIMARY KEY, name VARCHAR, users VARCHAR, headlines VARCHAR, author VARCHAR);

CREATE TABLE IF NOT EXISTS users(id serial PRIMARY KEY, name VARCHAR, roles VARCHAR, departments VARCHAR);

CREATE TABLE IF NOT EXISTS department_users(id serial PRIMARY KEY, usersId INTEGER, departmentId INTEGER);

CREATE DATABASE news_test WITH TEMPLATE news_java;