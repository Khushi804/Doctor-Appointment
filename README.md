# Doctor-Appointment

## Tech Stack
- Java 17, Spring Boot 3.x, MySQL 8.0, Swagger

## Setup
1. Create MySQL database `doctordb`
2. Configure `application.properties`
3. create .env write db.username and db.password
4. Run `mvn clean install`  // for reloading all the dependencies
5. Run: `mvn spring-boot:run`

## In MySQL workbench write query as
create database doctordb;
use doctordb;
// execute this query before running spring boot application

# API are as follows
// Doctor module
 - Get : /doctors/all-doctors
 - Post : /doctors/create-doctor
 - Get by Id : /doctors/{id}
 - Put by Id : /doctors/{id}
 - Delete by ID :  /doctors/{id}

// Patient Module
  - Post : /patients/create-patient
  - Get :  /patients/all-patients
  - Get by Id : /patients/{id}
  - Put by Id: /patients/{id}
  - Delete by Id: /patients/{id}

// Appointment Module 

 - Post : /appointments/create-appointment
 - Get :  /appointments/all-appointments
 - Get by Id : /appointments/{id}
 - Delete by Id :  /appointments/{id}

## Use Postman for Api testing

## Swagger
`/swagger-ui.html`
