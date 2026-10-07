# College Management System

A full-stack College Management System developed using **Java, Spring Boot, Spring Data JPA, PostgreSQL, HTML, CSS, and JavaScript**.

The application provides REST APIs for managing students and lecturers, along with a simple web-based frontend for interacting with the backend.

## 🚀 Features

### Student Management

* Add a student
* View all students
* Update student details
* Update student age
* Update student email
* Update student name
* Delete a student
* Find a student by ID

### Lecturer Management

* Add a lecturer
* View lecturers
* Manage lecturer details
* Delete lecturer

### Backend Features

* RESTful APIs
* Layered architecture
* Controller → Service → Repository architecture
* Spring Data JPA
* PostgreSQL database integration
* DTOs for data transfer
* Input validation
* Global exception handling
* Custom `ResourceNotFoundException`
* `ResponseEntity` for API responses
* Partial updates using `PATCH`
* Maven-based project

### Frontend Features

* HTML-based user interface
* JavaScript API integration using `fetch()`
* Student management pages
* Lecturer management pages
* Add, update, view, and management interfaces

## 🛠️ Technologies Used

### Backend

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java               | Programming language            |
| Spring Boot        | Backend framework               |
| Spring Data JPA    | Database persistence            |
| Hibernate          | ORM                             |
| REST API           | Backend communication           |
| PostgreSQL         | Database                        |
| Maven              | Dependency management and build |
| Jakarta Validation | Input validation                |

### Frontend

| Technology | Purpose                            |
| ---------- | ---------------------------------- |
| HTML5      | Page structure                     |
| CSS3       | Styling                            |
| JavaScript | Frontend logic and API integration |

## 🏗️ Project Architecture

```text
Frontend
   │
   │ HTTP Requests
   ▼
REST Controllers
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
PostgreSQL Database
```

The backend follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

## 📂 Project Structure

```text
CollegeManagementSystem
│
├── backend
│   └── CollegeManagementSystem
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── com.CollegeMenegement
│       │   │   │       ├── Controller
│       │   │   │       ├── DTO
│       │   │   │       ├── Entity
│       │   │   │       ├── ExceptionHandeling
│       │   │   │       ├── Repository
│       │   │   │       └── Service
│       │   │   │
│       │   │   └── resources
│       │   │       └── application.properties
│       │   │
│       │   └── test
│       │
│       ├── pom.xml
│       └── mvnw
│
├── frontend
│   ├── HTML
│   │   ├── index.html
│   │   ├── home.html
│   │   ├── student.html
│   │   ├── lecturer.html
│   │   └── ...
│   │
│   └── JS
│       ├── api.js
│       └── lecturerApi.js
│
└── README.md
```

## 🗄️ Database

The application uses **PostgreSQL**.

Example database configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/CollegeManagementSystem
spring.datasource.username=postgres
```

> Database passwords and other sensitive credentials are kept in a local configuration file and are not committed to GitHub.

## 🔗 API Overview

### Student APIs

| Method | Endpoint        | Description      |
| ------ | --------------- | ---------------- |
| GET    | `/fetchStudent` | Fetch students   |
| POST   | `/addStudent`   | Add a student    |
| PATCH  | `/update/{id}`  | Update student   |
| DELETE | `/delete/{id}`  | Delete a student |

### Lecturer APIs

The application also provides REST APIs for creating, retrieving, updating, and deleting lecturer information.

> API endpoint names may vary depending on the controller implementation.

## ▶️ How to Run the Project

### Prerequisites

Make sure the following are installed:

* Java 17 or later
* Maven
* PostgreSQL
* A Java IDE such as Spring Tool Suite or IntelliJ IDEA
* A modern web browser

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/CollegeManagementSystem.git
```

### 2. Configure PostgreSQL

Create a PostgreSQL database:

```sql
CREATE DATABASE CollegeManagementSystem;
```

Configure your local database credentials using:

```text
application-local.properties
```

Do not commit passwords or other sensitive credentials to GitHub.

### 3. Run the Backend

Navigate to:

```text
backend/CollegeManagementSystem
```

Run:

```bash
mvn spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

### 4. Run the Frontend

Open the frontend HTML files using a browser or a local development server such as VS Code Live Server.

The JavaScript frontend communicates with the Spring Boot REST APIs running on port `8080`.

## 🧪 API Testing

The REST APIs can be tested using tools such as:

* Postman
* Browser
* Frontend JavaScript `fetch()` requests

## 🔐 Security

Sensitive configuration such as local database passwords is excluded from version control using `.gitignore`.

For production applications, environment variables or a dedicated secrets-management solution should be used.

## 📌 Future Improvements

* Authentication and authorization using Spring Security and JWT
* Role-based access control
* Improved UI/UX
* Search and pagination
* API documentation using Swagger/OpenAPI
* Deployment to a cloud platform
* Docker containerization
* Automated testing
* Production database configuration

## 👨‍💻 Author

**Pratyansu Prateek**

B.Tech – Computer Science and Engineering

Interested in **Java Backend Development, Spring Boot, REST APIs, and Database Development**.

---

⭐ If you find this project useful, feel free to explore the source code and provide feedback.
