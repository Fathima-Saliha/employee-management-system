# Employee Management System

A **Spring Boot** based RESTful CRUD API for managing employee records. This project demonstrates layered architecture with custom exception handling,
data persistenceusing **Hibernate & MySQL**, and structured API responses using reusable wrappers.

---

## 🛠️ Technologies Used

- **Core Java**
- **Spring Boot**
- **Spring Framework**
- **Hibernate (JPA)**
- **MySQL**
- **Maven**
- **Postman** (for API testing)
- **Eclipse / Spring Tool Suite (STS)**

---

## 📂 Features

- Add a new employee
- Get employee by ID
- Get all employees
- Update employee details
- Delete employee
- Get employees by name
- Get employee with highest salary
- Custom exception handling (`@ControllerAdvice`)
- Structured JSON responses using:
  - `ResponseStructure<T>` for success
  - `ErrorStructure` for errors

---

## 📮 API Endpoints (Examples)

| Method | Endpoint                        | Description                    |
|--------|----------------------------------|--------------------------------|
| POST   | `/api/employee/save`            | Add new employee               |
| GET    | `/api/employee/fetch/{id}`      | Get employee by ID             |
| GET    | `/api/employee/all`             | Get all employees              |
| PUT    | `/api/employee/update/{id}`     | Update employee                |
| DELETE | `/api/employee/delete/{id}`     | Delete employee                |
| GET    | `/api/employee/byname/{name}`   | Get employees by name          |
| GET    | `/api/employee/max-sal`         | Get employee with max salary   |

---
