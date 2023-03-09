# ANZ Wholesale Engineering Sample Project (Backend Development)

### Reference Documentation
The sample application is to build the backend REST APIs
needed to support a web application to that allows a user to view accounts and
subsequently view transactions on any of the accounts they hold.

Required functionality and Endpoints:
- View account list
  - GET /api/v1/acctmgmt/user/{user_id}/accounts
- View account transactions
  - GET /api/v1/acctmgmt/user/{user_id}/account/{account_id}/transactions

Technologies and Tools used:

- SpringBoot 2.7
- Spring Data JPA
- H2 database

### Running the app locally

To run the app locally run the boot run gradle task

````
./gradlew bootRun
````

### Running the tests

````
./gradlew test
````
