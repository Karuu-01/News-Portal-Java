## App-Name
Models.News-Portal-Java
## Project Description
- This App Creates a REST API for querying and retrieving scoped news and information. 
- There should be news/articles/posts that are available to all employees without navigating into any department, and others that are housed/classified within departments.
- (The “Further Exploration” section below explains the need for this set up).

## Author's Information
This project was developed by Brian Karu.

Click on [Karuu](https://github.com/Karuu-01) to find the link to my Github Site.

## BDD
## User Requirements
1. As a user, I should be able to create the following objects:-
- Departments

- Models.News:

  General Models.News (Information affecting the whole company)

  Models.Department news (Objects within Object)

- Models.Users:

  One to many relationships between department and users. 
- 
2. As a user, I want to see individual users, their details, i.e. position in the company, their roles, which department(s) they are associated with etc
3. As a user, I want to see specific information such as the Departments name, description, number of employees in the department.
4. As a user, I want to see all users from a specific Models.Department, the news relating to that department or a link to a page with said news (for tidiness).
5. As a user, I want to be able to Post some news relating to a department.

## Demo
Here is a working live demo :

## Database Set Up Instructions
SET MODE PostgreSQL;

CREATE DATABASE news_java;
\c news_java
CREATE TABLE IF NOT EXISTS departments (id serial PRIMARY KEY, name VARCHAR, description VARCHAR, employee VARCHAR);

CREATE TABLE IF NOT EXISTS news (id serial PRIMARY KEY, name VARCHAR, users VARCHAR, headlines VARCHAR, author VARCHAR);

CREATE TABLE IF NOT EXISTS users(id serial PRIMARY KEY, name VARCHAR, roles VARCHAR, departments VARCHAR);

CREATE TABLE IF NOT EXISTS department_users(id serial PRIMARY KEY, usersId INTEGER, departmentId INTEGER);

CREATE DATABASE news_test WITH TEMPLATE news_java;

## To set up this project:

- Clone the repository by executing the following command in your terminal in the directory of your choice - git clone https://github.com/Karuu-01/Models.News-Portal-Java
- Navigate into the Forest-Service directory - cd news-portal-java
- Build project
- Build
- Run gradle build to build the project.

## Known Bugs
There are no known bugs at the moment

## Technologies Used:
- Java.
- Spark.
- Gradle.
- Maven.
- Bootstrap.
- JUnit.
- Postgresql
- Handlebars Templates
- JDBC Driver
- Simple sl4j

## Contact Information
- Email : brian.karu.work@gmail.com
- Phone : +254 706844439


## License
[MIT](License) © Brian Karu
