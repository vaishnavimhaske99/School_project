# School Project

## Overview

This is a Spring Boot application for managing school-related entities, including `Student`, `Standard`, `Teacher`, and `Subject`. The application uses a MySQL database to store data and follows a standard Spring Boot project structure with JPA for ORM.

## Project Structure

- **Entities**:
  - **`Student`**: Represents a student with attributes like `id`, `name`, `email`, and a many-to-one relationship with `Standard`.
  - **`Standard`**: Represents a standard (grade/class) with attributes like `id` and `name`. It has one-to-many relationships with `Student` and `Subject`.
  - **`Teacher`**: Represents a teacher with attributes like `id` and `name`. It has a one-to-many relationship with `Subject`.
  - **`Subject`**: Represents a subject with attributes like `id` and `name`. It has many-to-one relationships with both `Standard` and `Teacher`.

## Dependencies

- **Spring Boot Starter Data JPA**: Provides support for JPA-based data access.
- **Spring Boot Starter Web**: Includes web development tools.
- **Spring Boot DevTools**: Provides development-time tools.
- **MySQL Connector/J**: MySQL database connectivity.
- **Lombok**: Reduces boilerplate code.
- **Spring Boot Starter Test**: Includes testing tools.

## Configuration

### Application Properties

The application is configured to connect to a MySQL database and use JPA for data management. Configuration is provided in `src/main/resources/application.properties`:

```properties
spring.application.name=SchoolProject-2

spring.datasource.url=jdbc:mysql://localhost:3306/Schooleapp2
spring.datasource.username=root
spring.datasource.password=Vaishu@1999
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
