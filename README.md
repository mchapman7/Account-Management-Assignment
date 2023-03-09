# Wholesale Engineering Project (Backend Development)

### Reference Documentation
This account management service application is to build the backend REST APIs
needed to support a web application to that allows a user to view accounts and
subsequently view transactions on any of the accounts they hold.

Required functionality and Endpoints:
- View account list
  - GET /api/v1/acctmgmt/users/{user_id}/accounts
- View account transactions
  - GET /api/v1/acctmgmt/users/{user_id}/accounts/{account_id}/transactions

API docs
http://localhost:8080/swagger-ui/index.html#/

Technologies and Tools used:

- Java 11
- SpringBoot 2.7
- Spring Data JPA
- H2 database
- Mockito
- Gradle

### Running the app locally

To run the app locally run the boot run gradle task

````
./gradlew bootRun
````

### Running the tests

````
./gradlew test
````
