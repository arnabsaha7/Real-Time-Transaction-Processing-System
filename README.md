# Real-Time Transaction Processing System

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.6.0-green?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot) [![JDK 21](https://img.shields.io/badge/Java%20-JDK%2021-orange?style=for-the-badge&logo=openjdk)](https://openjdk.java.net/projects/jdk/21) [![Prometheus](https://img.shields.io/badge/Prometheus-monitoring-orange?style=for-the-badge&logo=prometheus)](https://prometheus.io/) [![Grafana](https://img.shields.io/badge/Grafana-analytics-blue?style=for-the-badge&logo=grafana)](https://grafana.com/) [![Docker](https://img.shields.io/badge/Docker-containerization-blueviolet?style=for-the-badge&logo=docker)](https://www.docker.com/)

---

## Project Overview

The **Real-Time Transaction Processing System** is a banking application designed to handle financial transactions with high performance, scalability, and built-in fraud detection. The system is developed using **Spring Boot** with a microservice architecture, providing secure endpoints for user authentication, transaction processing, and monitoring.

This project leverages **JWT** for secure authentication, **Prometheus** and **Grafana** for monitoring, and is fully **Dockerized** for containerization.

---

## Features

- 🛡️ **User Authentication** using **JWT** (JSON Web Tokens)
- 🔄 **Real-Time Transaction Processing** with transaction status updates
- 🚨 **Fraud Detection** built into the transaction workflow
- 📊 **Monitoring** using **Prometheus** and **Grafana**
- 🐳 **Dockerized Deployment** for easy containerization

---

## Technologies Used

- **Backend:** Spring Boot, Spring Security, Spring Data JPA
- **Database:** H2 (In-memory for development), MySQL (optional for production)
- **Authentication:** JSON Web Tokens (JWT)
- **Monitoring:** Prometheus, Grafana
- **Containerization:** Docker
- **Testing:** Postman

---

## Getting Started

### Prerequisites

Before you begin, ensure you have the following tools installed:
- **Java 21+**
- **Maven 3+**
- **Docker** (for containerization)

### Clone the Repository

To get started with the project, clone the repository to your local machine:
```bash
git clone https://github.com/arnabsaha7/real-time-transaction-processing.git
cd real-time-transaction-processing
```

### Build the Application

Use Maven to build the project and generate the JAR file:
```bash
mvn clean package
```

### Run the Application Locally

Once built, you can run the Spring Boot application using Maven:
```bash
mvn spring-boot:run
```

Alternatively, you can build and run the application using Docker. See the **Dockerization** section below.

---

## Endpoints

### Authentication Endpoints

| Method | Endpoint           | Description                |
|--------|--------------------|----------------------------|
| POST   | `/auth/register`    | Register a new user        |
| POST   | `/auth/login`       | Login and get JWT token    |

### Transaction Endpoints

| Method | Endpoint               | Description                   |
|--------|------------------------|-------------------------------|
| POST   | `/transactions/process` | Process a financial transaction |

---

## Screenshots

### Postman Request and Response

| **Transaction Request** | **Invalid Request** | **Fraud-Transaction Request** |
|----------------|----------------|----------------|
| ![Request 1](img/tran_req.png) | ![Request 2](img/inv-req.png) | ![Request 3](img/frad-req.png) |

| **Transaction Response** | **Invalid Response** | **Fraud-Transaction Response** |
|-----------------|-----------------|-----------------|
| ![Response 1](img/tran-resp.png) | ![Response 2](img/inv-resp.png) | ![Response 3](img/frad-resp.png) |

---

## Dockerization

This project is fully **Dockerized** for easy containerization and deployment. Follow the instructions below to build and run the application inside a Docker container.

### Dockerfile

The project comes with a pre-configured `Dockerfile` to containerize the Spring Boot application.

### Build the Docker Image

```bash
docker build -t transaction-processing-app .
```

### Run the Docker Container

```bash
docker run -p 8080:8080 transaction-processing-app
```

The application will now be accessible at [http://localhost:8080](http://localhost:8080).

---

## How to Run

1. **Build and Run Locally:**  
   ```bash
   mvn spring-boot:run
   ```
2. **Access the Application:**  
   - [http://localhost:8080](http://localhost:8080)

3. **Access the H2 Database Console:**  
   - [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

4. **Build and Run with Docker:**  
   ```bash
   docker build -t transaction-processing-app .
   docker run -p 8080:8080 transaction-processing-app
   ```


## LICENSE

This project is licensed under the MIT License. See the [LICENSE](#license) file for details.

