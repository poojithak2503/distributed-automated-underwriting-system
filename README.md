# Distributed Automated Underwriting System

## Overview

The Distributed Automated Underwriting System is a Java 11 microservices-based application that automates mortgage loan underwriting by evaluating borrower information, calculating risk scores, validating credit eligibility, and generating loan approval decisions. The system is designed around an event-driven architecture with asynchronous processing to simulate enterprise mortgage underwriting workflows.

The application demonstrates modern backend development using Spring Boot, microservices principles, asynchronous processing similar to AWS Lambda, PostgreSQL transaction management concepts, Docker deployment, and RESTful web services.

---

## Features

- Mortgage application processing
- Automated borrower risk assessment
- Credit score validation
- Debt-to-income ratio calculation
- Loan approval decision engine
- Manual review workflow
- Asynchronous credit verification
- PostgreSQL pessimistic locking simulation
- Docker deployment simulation
- RESTful APIs
- Underwriting report generation
- Risk analytics

---

## Technology Stack

| Technology | Version |
|------------|----------|
| Java | 11 |
| Spring Boot | 2.x |
| Spring MVC | Latest |
| Spring Cloud | Latest |
| PostgreSQL | Latest |
| AWS Lambda | Simulated |
| Docker | Latest |
| Maven | 3.x |

---

## Project Structure

```
distributed-automated-underwriting-system
│
├── controller
│     UnderwritingController.java
│
├── model
│     Borrower.java
│
├── repository
│     BorrowerRepository.java
│
├── service
│     UnderwritingService.java
│     RiskAssessmentService.java
│     CreditCheckLambdaService.java
│     LoanDecisionService.java
│     PostgreSqlLockService.java
│     DockerDeploymentService.java
│
└── UnderwritingApplication.java
```

---

## System Architecture

```
                     Mortgage Application

                               │

                               ▼

                 UnderwritingController

                               │

                               ▼

                  UnderwritingService

                               │

               Calculate Risk Score

                               │

                               ▼

            RiskAssessmentService (Async)

                               │

                               ▼

         CreditCheckLambdaService (AWS Lambda)

                               │

                               ▼

              LoanDecisionService

                               │

                               ▼

         PostgreSqlLockService (Lock Record)

                               │

                               ▼

             BorrowerRepository

                               │

                               ▼

                  Final Decision
```

---

## Underwriting Workflow

1. Borrower submits a mortgage application.
2. Controller receives the request.
3. UnderwritingService validates borrower details.
4. Risk score is calculated.
5. Debt-to-income ratio is calculated.
6. RiskAssessmentService performs asynchronous validation.
7. CreditCheckLambdaService verifies external credit information.
8. LoanDecisionService determines the mortgage decision.
9. PostgreSqlLockService locks the application during processing.
10. Repository stores the final underwriting decision.

---

## Risk Calculation

Risk score is determined using multiple borrower attributes.

### Credit Score

```
800+        Very Low Risk
700-799     Low Risk
650-699     Medium Risk
Below 650   High Risk
```

---

### Annual Income

```
Above 80000      Preferred
50000-79999      Standard
Below 50000      Higher Risk
```

---

### Debt To Income Ratio

```
Below 35%      Healthy
35% - 40%      Acceptable
Above 40%      High Risk
```

---

## Loan Decision Rules

### Approved

```
Risk Score <= 25

Credit Score >= 760

Annual Income >= 90000
```

---

### Manual Review

```
Risk Score <= 55

Credit Score >= 680
```

---

### Rejected

```
Risk Score > 55
```

---

## REST APIs

### Submit Mortgage Application

```
POST /api/underwriting/submit
```

Example Request

```json
{
    "applicationId":1001,
    "borrowerName":"John Smith",
    "ssn":"123-45-6789",
    "annualIncome":95000,
    "creditScore":770,
    "requestedLoanAmount":350000,
    "loanTermMonths":360,
    "employmentStatus":"EMPLOYED",
    "loanPurpose":"HOME_PURCHASE"
}
```

---

### Get All Applications

```
GET /api/underwriting/applications
```

---

### Get Application

```
GET /api/underwriting/{applicationId}
```

---

### Generate Underwriting Report

```
GET /api/underwriting/report
```

---

### Approved Applications

```
GET /api/underwriting/approved
```

---

### Rejected Applications

```
GET /api/underwriting/rejected
```

---

### Average Risk Score

```
GET /api/underwriting/average-risk
```

---

### Clear Applications

```
DELETE /api/underwriting/clear
```

---

## Underwriting Decision Flow

```
Borrower Application

        │

        ▼

Credit Verification

        │

        ▼

Income Verification

        │

        ▼

Debt Ratio Validation

        │

        ▼

Risk Score Calculation

        │

        ▼

Loan Decision

        │

        ▼

Store Application

        │

        ▼

Response Returned
```

---

## Business Components

### UnderwritingController

Handles REST APIs for mortgage underwriting.

---

### UnderwritingService

Calculates borrower risk score and underwriting decision.

---

### RiskAssessmentService

Performs asynchronous validation similar to AWS Lambda execution.

---

### CreditCheckLambdaService

Simulates external credit bureau verification and fraud validation.

---

### LoanDecisionService

Determines whether the mortgage should be approved, rejected, or routed for manual review.

---

### PostgreSqlLockService

Simulates pessimistic locking to prevent concurrent modifications while an application is under review.

---

### BorrowerRepository

Stores and retrieves mortgage applications.

---

### DockerDeploymentService

Simulates container build, deployment, and health checks.

---

## Sample Underwriting Result

```
Borrower Name      : John Smith

Credit Score       : 770

Annual Income      : $95,000

Loan Amount        : $350,000

Debt Ratio         : 0.28

Risk Score         : 22

Decision           : APPROVED

Recommendation     : Premium Interest Rate
```

---

## Enterprise Concepts Demonstrated

- Spring Boot Microservices
- REST API Development
- Service Layer Architecture
- Business Rule Engine
- Asynchronous Processing
- AWS Lambda Integration Concept
- PostgreSQL Pessimistic Locking
- Docker Deployment
- Java Collections
- Object-Oriented Programming
- Mortgage Underwriting Workflow
- Enterprise Banking Design

---

## Future Enhancements

- Spring Data JPA
- PostgreSQL Database Integration
- Spring Cloud Config Server
- Eureka Service Discovery
- API Gateway
- AWS SQS Integration
- AWS Lambda Deployment
- Docker Compose
- Kubernetes Deployment
- Redis Cache
- JWT Authentication
- Spring Security
- OpenAPI / Swagger
- Kafka Event Streaming
- Email Notifications
- SMS Notifications
- JUnit and Mockito Testing
- SonarQube Integration
- Jenkins CI/CD Pipeline

---

## Learning Outcomes

This project demonstrates practical implementation of

- Java 11 Enterprise Development
- Spring Boot Microservices
- Mortgage Underwriting Business Logic
- RESTful Web Services
- Risk Assessment Engine
- Asynchronous Processing
- AWS Lambda Concepts
- PostgreSQL Transaction Management
- Pessimistic Locking
- Docker Deployment
- Enterprise Application Design

---

## Author

**Poojitha Kanuri**

Java Full Stack Developer

Email: poojithakanuri03@gmail.com

LinkedIn: https://linkedin.com/in/poojithakanuri

GitHub: https://github.com/poojithak2503
