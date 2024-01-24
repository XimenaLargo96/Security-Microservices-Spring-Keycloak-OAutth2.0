## Billing system 💸

### About the project
This is a billing system for the users of an application that implements the microservices architecture, which lists the invoices that a user has by searching for the user id, thus making a connection between the microservices bills and users and exposing an API for the query. For this project we used the Java language and the Spring boot framework for the development of the models, services, controllers and repositories, the connection with the databases was done using Spring JPA and for the connection between microservices we used Feign. Security was handled through Spring Security and OAuth 2.0 with Keycloak.

### Requirements

- [Java 17](https://www.oracle.com/co/java/technologies/downloads/#java17)

- [Maven](https://maven.apache.org/download.cgi)

- [Docker](https://www.docker.com/products/docker-desktop/)

- [Keycloak](https://www.keycloak.org)

## How to execute? 🚀

1. Clone this repository
```
https://github.com/XimenaLargo96/Security-Microservices-Spring-Keycloak-OAutth2.0.git
```

2. Let's run keycloak with docker
```
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.1 start-dev
```
3.import the realm file into the project "realm-export.json"

4.Create a new user and add him/her to the PROVIDERS group to create a new bill.

5. Make sure that your source code is compiled correctly.
```
mvn clean install
```
6. Each microservice must be executed.
```
java -jar ms-discovery.jar
```
```
java -jar ms-gateway.jar
```
```
java -jar ms-users.jar
```
```
java -jar ms-bills.jar
```
7. To create a new invoice use the following endpoint ¡¡¡Remember that the user must belong to the PROVIDERS group in order to access this endpoint.!!!
```
http://localhost:8083/bills
```
8.Send the request with the following JSON
```
{
    "customerBill": "userId",
    "productBill": "Bill",
    "totalPrice": 2.5
}
```
8. To list the invoices the user has, access the following endpoint
```
http://localhost:8090/api/v2/users/find/userId
```
