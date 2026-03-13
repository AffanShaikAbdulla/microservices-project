\# 🏨 Microservices Project - User, Hotel, Rating Services



!\[Java](https://img.shields.io/badge/Java-17-orange)

!\[Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-green)

!\[Microservices](https://img.shields.io/badge/Microservices-Project-blue)

!\[Eureka](https://img.shields.io/badge/Eureka-Discovery-red)

!\[Feign](https://img.shields.io/badge/Feign-Client-yellow)

!\[MySQL](https://img.shields.io/badge/MySQL-Database-blue)



\## 📋 Project Overview



This is a complete microservices-based application for managing users, hotels, and their ratings. Built to demonstrate hands-on experience with \*\*Spring Boot microservices architecture\*\*.



\## 🏗️ Architecture

┌─────────────────┐

│ Eureka Server │

│ Port: 8761 │

└────────┬────────┘

│

All services register here

│

┌───────────────────────┼───────────────────────┐

│ │ │

▼ ▼ ▼

┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐

│ API Gateway │ │ User Service │ │ Hotel Service │

│ Port: 8084 │───▶│ Port: 8090 │ │ Port: 8082 │

└─────────────────┘ └────────┬────────┘ └─────────────────┘

│ │ ▲

│ ┌────────▼────────┐ │

└──────────────│ Rating Service │──────────────┘

│ Port: 8083 │

└─────────────────┘ 



\## ✨ Features



| Feature | Implementation |

|---------|---------------|

| ✅ \*\*Service Discovery\*\* | Eureka Server for service registration |

| ✅ \*\*API Gateway\*\* | Spring Cloud Gateway for routing |

| ✅ \*\*Inter-service Communication\*\* | Feign Client + RestTemplate |

| ✅ \*\*Database per Service\*\* | MySQL databases |

| ✅ \*\*Load Balancing\*\* | Spring Cloud LoadBalancer |

| ✅ \*\*Declarative REST Clients\*\* | OpenFeign |



\## 🛠️ Technology Stack



\- \*\*Java 17\*\*

\- \*\*Spring Boot 3.2.5\*\*

\- \*\*Spring Cloud 2023.0.1\*\*

\- \*\*Eureka Server\*\* - Service Discovery

\- \*\*Spring Cloud Gateway\*\* - API Gateway

\- \*\*OpenFeign\*\* - Declarative REST Client

\- \*\*Spring Data JPA\*\* - Database Operations

\- \*\*MySQL\*\* - Database

\- \*\*Maven\*\* - Build Tool



\## 📦 Project Structure 

microservices-project/

│

├── service-registry/ # Eureka Server (Port: 8761)

├── api-gateway/ # Spring Cloud Gateway (Port: 8084)

├── user-service/ # User Microservice (Port: 8090)

├── hotel-service/ # Hotel Microservice (Port: 8082)

├── rating-service/ # Rating Microservice (Port: 8083)

└── screenshots/ # Project screenshots  



\## 🚀 How to Run



\### Prerequisites

\- Java 17

\- MySQL Server

\- Maven



\### Database Setup



Create three databases in MySQL:

```sql

CREATE DATABASE microservices;  -- for User Service

CREATE DATABASE testdb;          -- for Hotel Service

CREATE DATABASE ratingdb;        -- for Rating Service



Step-by-Step Execution

1\. Start Service Registry



bash

cd service-registry

mvn spring-boot:run

Verify: http://localhost:8761 

2\. Start All Microservices (in separate terminals)



\# Terminal 2 - User Service

cd user-service

mvn spring-boot:run



\# Terminal 3 - Hotel Service

cd hotel-service

mvn spring-boot:run



\# Terminal 4 - Rating Service

cd rating-service

mvn spring-boot:run 



3\. Start API Gateway

cd api-gateway

mvn spring-boot:run



API Endpoints

Via API Gateway (http://localhost:8084) 





Service	Endpoint	Method	Description

User Service	/users	GET	Get all users

/users/{userId}	GET	Get user by ID

/users	POST	Create user

Hotel Service	/hotels	GET	Get all hotels

/hotels/{hotelId}	GET	Get hotel by ID

/hotels	POST	Create hotel

Rating Service	/ratings/user/{userId}	GET	Get ratings by user

/ratings/hotel/{hotelId}	GET	Get ratings by hotel

/ratings	POST	Create rating

Key API: Get User with Ratings and Hotels 



GET http://localhost:8084/users/{userId} 



This endpoint:



Fetches user details from User Service



Calls Rating Service to get user's ratings



For each rating, calls Hotel Service to get hotel details



Combines everything into a single response   



&#x20;Screenshots

1\. Eureka Dashboard

https://screenshots/eureka-dashboard.png

All services registered in Eureka



2\. API Gateway Running

https://screenshots/api-gateway.png

API Gateway started successfully



3\. User Service API

https://screenshots/user-service.png

Get user with ratings and hotels



4\. Hotel Service API

https://screenshots/hotel-service.png

Hotel endpoints working



5\. Rating Service API

https://screenshots/rating-service.png

Rating endpoints working



6\. Combined Response

https://screenshots/combined-response.png

User details with ratings and hotel information



Key Learnings

Through this project, I learned:



✅ Service Discovery - How services find each other dynamically



✅ API Gateway Pattern - Centralized routing and cross-cutting concerns



✅ Feign Clients - Declarative REST client communication



✅ Database per Service - Maintaining data independence



✅ Load Balancing - Client-side load balancing with Ribbon/LoadBalancer



✅ Microservices Communication - Synchronous vs asynchronous patterns

Testing with Postman

Import the Postman collection from /postman/microservices-api-collection.json



Sample requests: 

// Create User

POST http://localhost:8084/users

{

&#x20;   "name": "John Doe",

&#x20;   "email": "john@example.com"

}



// Create Hotel

POST http://localhost:8084/hotels

{

&#x20;   "name": "Taj Hotel",

&#x20;   "location": "Mumbai"

}



// Create Rating

POST http://localhost:8084/ratings

{

&#x20;   "userId": "user-id",

&#x20;   "hotelId": "hotel-id",

&#x20;   "rating": 5,

&#x20;   "feedback": "Excellent"

} 

📧 Contact

Shaik Abdulla - Java Backend Developer



Email: skabdulla0298@gmail.com



LinkedIn: linkedin.com/in/shaikaffanabdulla 





cleanup
cleanup
