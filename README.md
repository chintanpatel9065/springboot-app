# Employee Management System

A comprehensive Spring Boot application for managing employees, departments, and designations within an organization.

## Overview

This Employee Management System is a web-based application built with Spring Boot that allows organizations to manage their employee data, department structure, and job designations. The application provides a user-friendly interface for performing CRUD (Create, Read, Update, Delete) operations on employees, departments, and designations.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf** - Server-side Java template engine
- **Bootstrap—**Frontend framework for responsive design
- **PostgresSQL** - Relational database
- **Hibernate** - ORM (Object-Relational Mapping) tool
- **Maven** - Dependency management and build tool

## Features

### Employee Management
- Add new employees with detailed information
- View a list of all employees
- Update existing employee information
- Delete employees from the system
- Validation for employee data

### Department Management
- Create new departments
- View all departments
- Update department information
- Delete departments

### Designation Management
- Create new job designations
- View all designations
- Update designation information
- Delete designations

## Data Model

### Employee
- Personal information (first name, middle name, last name, address, gender)
- Contact details (email, mobile)
- Birthdate
- Programming skills
- Languages known
- User credentials (username, password)
- Department and designation associations

### Department
- Department ID
- Department name

### Designation
- Designation ID
- Designation type

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven
- PostgresSQL

### Database Setup
1. Install PostgresSQL if not already installed
2. Create a database (default configuration uses 'postgres')
3. Update the database configuration in `application.properties` if needed:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Running the Application
1. Clone the repository
2. Navigate to the project directory
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Access the application in your browser at `http://localhost:8080`

## Usage

1. **Home Page**: Navigate between Employee, Department, and Designation management
2. **Employee Management**:
   - View all employees at `/employees/listEmployee`
   - Add a new employee at `/employees/showEmployeeForm`
   - Edit an employee at `/employees/manageEmployee/{employeeId}`
   - Delete an employee at `/employees/deleteEmployee/{employeeId}`
3. **Department Management**:
   - View all departments at `/departments/listDepartment`
   - Similar operations for adding, editing, and deleting departments
4. **Designation Management**:
   - View all designations at `/designations/listDesignation`
   - Similar operations for adding, editing, and deleting designations

## Project Structure

```
src/main/java/org/chintanpatel/springbootapp/
├── SpringBootAppApplication.java
├── department/
│   ├── Department.java
│   ├── DepartmentController.java
│   ├── DepartmentRepository.java
│   └── DepartmentService.java
├── designation/
│   ├── Designation.java
│   ├── DesignationController.java
│   ├── DesignationRepository.java
│   └── DesignationService.java
├── employee/
│   ├── Employee.java
│   ├── EmployeeController.java
│   ├── EmployeeRepository.java
│   └── EmployeeService.java
└── home/
    └── BackController.java
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License—see the LICENSE file for details.