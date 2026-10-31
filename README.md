# Student Management System

A REST API for managing student records, built with Spring Boot, Spring Data JPA (Hibernate) and MySQL.

## Tech Stack
- Java 17
- Spring Boot 4.1.2 (Spring Web MVC, Spring Data JPA)
- Hibernate ORM (via JPA)
- MySQL 8+
- Maven

## Features
- Create, read, update and delete student records (CRUD)
- Database table created automatically from the JPA entity (ddl-auto=update)
- Unique email constraint on students

## Project Structure

    src/main/java/com/masud/studentmanagement/
    ├── controller/   REST endpoints (StudentController)
    ├── service/      Business logic (StudentService)
    ├── repository/   Spring Data JPA repository (StudentRepository)
    └── entity/       JPA entity mapped to the students table (Student)

## Setup

1. Make sure MySQL is running on localhost:3306.
2. Open src/main/resources/application.properties and set your MySQL password:

        spring.datasource.password=YOUR_PASSWORD

3. Run the application:

        mvn spring-boot:run

   The database student_db and the students table are created automatically on first run.

## API Endpoints

Base URL: http://localhost:8080/api/students

| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get one student by id |
| POST | /api/students | Add a new student |
| PUT | /api/students/{id} | Update a student |
| DELETE | /api/students/{id} | Delete a student |

Sample request body:

    {
      "name": "Masud",
      "email": "masud@test.com",
      "course": "B.Tech CSD"
    }

Example:

    curl -X POST http://localhost:8080/api/students \
      -H "Content-Type: application/json" \
      -d '{"name":"Masud","email":"masud@test.com","course":"B.Tech CSD"}'

## Future Improvements
- Global exception handling with proper HTTP 404 responses
- DTOs and request validation (@Valid)
- Pagination and search
- Unit and integration tests
