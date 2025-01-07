# Spring Boot CRUD Operations: Topics and Courses

## Description
This project demonstrates a learning implementation of Spring Boot for managing two related resources: Topic and Course.
Each Topic contains a list of Course objects.
Each Course is associated with only one Topic.
CRUD operations are implemented for both resources.
An embedded database is used to simplify setup and focus on core functionality.

## Features
RESTful endpoints for CRUD operations on Topic and Course.
One-to-Many relationship mapping between Topic and Course.
Endpoints include:
Fetch all topics and specific topics.
Fetch all courses under a topic or specific courses by ID.
Create, update, and delete resources.

## Technologies Used
Spring Boot: Core framework for application setup.
JPA/Hibernate: For ORM and database operations.
Embedded H2 Database: For quick and easy database setup.
Maven: For dependency management and build process.
