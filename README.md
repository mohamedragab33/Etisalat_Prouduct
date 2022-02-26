# PRODUCT TASK   
## Spring Boot, MySQL, JPA Rest API

Building a Restful CRUD API for a PRODUCT application using Spring Boot, Mysql and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.3.9

3. MySQL - 5.7.12  

4. JPA

5. Spring Boot  

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/mohamedragab33/Prouduct_Etisalat.git
```

**2. Import Mysql database**

```bash
from schema folder Dump20220226.sql
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/db.properties`

+ change `mysql.user` and `mysql.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs By import  

```bash
Product Collection for Etisalat.postman_collection.json from 
```
Product rest api collection

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/products             >>For getting all products<<
    
    POST /api/product             >>For creating new product<<
    
    GET /api/product?id=          >>For getting product by id <<
    
    PUT /api/product              >>For edit a product<<
    
    DELETE /api/product?id=       >>For delete a product by id <<

You can test them using postman or any other rest client.

## By: Mohamed Ragab
