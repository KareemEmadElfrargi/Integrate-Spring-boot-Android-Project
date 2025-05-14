# Spring Boot + Android Student Management App
This project demonstrates how to integrate a **Spring Boot RESTful API** with an **Android app** using Retrofit. The system allows you to perform basic **CRUD operations** (Create, Read, Update, Delete) on a list of students .

---

## Features

### Backend (Spring Boot)
- RESTful API for managing students
- Upload and store image with `MultipartFile`
- Endpoints to get, add, update, and delete students
- Error handling with proper HTTP status codes
  
### Android App (Kotlin)
- Connects to Spring Boot backend via Retrofit
- Fetches all students and displays them in a `RecyclerView`
- Logs responses and shows error messages using `Toast`
- Handles JSON conversion with Gson

---


## Sample API

| Method | Endpoint               | Description                  |
|--------|------------------------|------------------------------|
| GET    | `/api/students`        | Get all students             |
| GET    | `/api/student/{id}`    | Get a specific student       |
| POST   | `/api/student`         | Add a student + image        |
| PUT    | `/api/student/{id}`    | Update a student + image     |
| DELETE | `/api/student/{id}`    | Delete a student             |




## Summary Video 


https://github.com/user-attachments/assets/ef15f6ca-7ffc-455e-bba4-0b87e052d639

## Author
Kareem Emad










