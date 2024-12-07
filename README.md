# Student Management System🧑‍💻

A simple and efficient **Student Management System** built using the **DAO (Data Access Object)** pattern. The system allows the management of student records, including adding, deleting, updating, and viewing student details.

## Features
- **Add Student**: Allows the addition of student details to the database.
- **Update Student**: Allows editing of existing student records.
- **Delete Student**: Allows deletion of student records from the database.
- **View Student**: Fetches and displays a list of students in the system.
- **Search Student**: Search for a student by ID or name.
  
## Technologies Used
- **Programming Language**: Java (for the backend)
- **Database**: MySQL (or any relational database)
- **DAO Pattern**: Data Access Object design pattern to manage student data abstraction.
- **JDBC**: Java Database Connectivity for interacting with the database.
  
## System Architecture

### 1. **DAO (Data Access Object) Layer**
The DAO layer abstracts the interaction with the database and provides methods for CRUD operations. This layer helps in maintaining the separation of concerns and makes the system easier to maintain and test.

- `StudentDAO`: Interface providing methods for adding, updating, deleting, and fetching student records.
- `StudentDAOImpl`: Concrete implementation of `StudentDAO` interface that uses JDBC for database communication.

### 2. **Model Layer**
The model represents the student data.
- `Student`: A class representing a student with properties such as `id`, `first_name`, `last_name`, `age`, and `email`.

### 3. **Service Layer**
The service layer provides business logic and acts as an intermediary between the controller (UI layer) and DAO layer.
- `StudentService`: A class that provides methods to manage student data (e.g., `addStudent()`, `updateStudent()`).

### 4. **Controller (Optional for web applications)**
- `StudentController`: Handles user requests and invokes appropriate service methods for adding, updating, and deleting student records.

## Database Schema

The database schema used for the Student Management System is as follows:

```sql
CREATE DATABASE student;
use student;
CREATE TABLE studentmanagement(
id INT ,
first_name VARCHAR(30) ,
last_name VARCHAR(30) ,
 email VARCHAR(30) ,
age INT
);
