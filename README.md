# Healthcare Microservices Project

## Overview
This project is a **microservices-based healthcare system** that manages user information, appointments, billing, prescriptions, and doctor information. Each microservice is built using **Spring Boot** and communicates via REST APIs.

## Technologies Used
- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL
- **API Communication:** REST (using RestTemplate)
- **ORM:** Hibernate
- **Build Tool:** Maven

## Microservices
The project consists of the following microservices:

| Microservice         | Port  | Description |
|---------------------|------|-------------|
| **User Service** | 8080 | Manages patient information |
| **Billing Service** | 8081 | Manages billing and payments |
| **Appointment Service** | 8082 | Handles doctor-patient appointments |
| **Doctor Service** | 8083 | Manages doctor information |
| **Prescription Service** | 8084 | Handles prescriptions and medicine details |

## Project Structure
```
healthcare-microservices/
|-- user-service/
|-- billing-service/
|-- appointment-service/
|-- doctor-service/
|-- prescription-service/
```
Each microservice has:
- **Controller** - Handles HTTP requests
- **Service** - Business logic
- **Repository** - Database operations
- **Model** - Entity representation

## Database Configuration
Each microservice requires a PostgreSQL database. Update the `application.properties` file accordingly:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/{database_name}
spring.datasource.username={your_username}
spring.datasource.password={your_password}
```
Replace `{database_name}`, `{your_username}`, and `{your_password}` with actual values.

## How to Run
### Prerequisites
- Install **Java 17+**
- Install **PostgreSQL** and create databases for each service
- Install **Maven**

### Steps to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-repo/healthcare-microservices.git
   cd healthcare-microservices
   ```

2. **Start Each Microservice**
   Navigate to each microservice and run:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
Each microservice exposes REST APIs:

### User Service
- `POST /users` - Create a new user
- `GET /users` - Retrieve all users
- `GET /users/{id}` - Retrieve user by ID
- `PUT /users/{id}` - Update user information
- `DELETE /users/{id}` - Delete user

### Billing Service
- `POST /billings` - Create a bill
- `GET /billings` - Retrieve all bills
- `GET /billings/{id}` - Retrieve a bill by ID
- `PUT /billings/{id}` - Update a bill
- `DELETE /billings/{id}` - Delete a bill

### Appointment Service
- `POST /appointments` - Schedule an appointment
- `GET /appointments` - Retrieve all appointments

### Doctor Service
- `POST /doctors` - Add a doctor
- `GET /doctors` - Retrieve all doctors

### Prescription Service
- `POST /prescriptions` - Add a prescription
- `GET /prescriptions` - Retrieve all prescriptions

## Future Enhancements
- Add **API Gateway** for centralized routing
- Implement **Eureka Server** for service discovery
- Secure APIs with **JWT authentication**

---

_Developed by: Dipeesha Vartak , Dhruvi Doshi , Saanvi Misar , Nitya Nivdunge_

