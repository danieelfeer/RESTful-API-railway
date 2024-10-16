<h1>
  <img src="https://logodownload.org/wp-content/uploads/2017/05/santander-logo-1.png" alt="santander-logo" width="120" style="vertical-align: middle; margin-right: 10px;" />
  Santander API RESTful - project
</h1>

RESTful API from Santander built in Java 17 with Spring Boot 3.

## Table of Contents

- [🛠️ Key Technologies](#-key-technologies)
- [📄 API Documentation](#-api-documentation)
- [📊 UML Class Diagram](#-uml-class-diagram)
- [📑 Interface References](#-interface-references)

## 🛠️ Key Technologies

This project leverages several cutting-edge technologies:

- **Java 17** ☕: The latest LTS version of Java is used to take advantage of the newest innovations offered by this robust and widely-used language.

- **Spring Boot 3** 🚀: The latest version of Spring Boot maximizes developer productivity through its powerful autoconfiguration capabilities.

- **Spring Data JPA** 🗄️: This tool simplifies the data access layer, making integration with SQL databases more seamless.

- **OpenAPI (Swagger)** 📄: Effective and easy-to-understand API documentation is created using OpenAPI (Swagger), perfectly aligned with the high productivity that Spring Boot offers.

- **Railway** ☁️: This platform simplifies the deployment and monitoring of cloud solutions, while also providing various database-as-a-service options and CI/CD pipelines.

## 📄 API Documentation

The API documentation was created using Swagger and is available at the following link:

<a href="https://santander-restful-api-railway-prd.up.railway.app/swagger-ui/index.html" target="_blank">Swagger Documentation 🔗</a>

## 📊 UML Class Diagram

```mermaid
classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Number balance
    -Number limit
  }

  class Feature {
    -String icon
    -String description
  }

  class Card {
    -String number
    -Number limit
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News

```

## 📑 Interface References

<div style="display: flex; justify-content: space-around;">
  <img src="https://github.com/user-attachments/assets/91d97002-f6ce-4c46-8823-f069a537b7e7" alt="santander-mobile" width="250" />
  <img src="https://github.com/user-attachments/assets/2ec6844e-c4ee-4170-83f5-d6e1115682be" alt="santander-web" width="750" />
</div>
