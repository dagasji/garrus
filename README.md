# Garrus

Angular 6 frontend + java backend scaffold ready to run with additional goodies like login, junit, JWT for rest security and more. 

## Stack and details

### Backend
- Spring Boot for running and packing.
- Spring Data for data access + Hibernate 5.
- Spring security with JWT (Json web tokens) for the rest services.
- Junit with Spring boot. 
- MapStruct (a cool mapping tool without using reflection) for mappin data entities and DTOs at rest layer.
- Different maven profiles preconfigured.
- User tables for login. 
- Vehicles and drivers simple model for reference and example.

### Frontend
- Angular 6 with Node 5.10.
- Angular Materials for components. 
- Dashboard layout by Creative Tim.(https://www.creative-tim.com/)
- Toastr: good looking and simple notifications.(https://github.com/scttcper/ngx-toastr)
- Loading spinner (https://mika-el.github.io/angular-loading-page/#/)
- Login/logout with secured app route.
- CRUD functionality for vehicles and drivers.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

- Java 8+ installed.
- Maven installed.
- Node 5.10+ 
- MySQL server. 


### Installing

A step by step series of examples that tell you how to get a development env running.

1. Clone the repo.
2. Create a new database at your MySQL server. The default database is garrus_develop. For changing database connection modify file /garrus-backend/src/main/resources/application.properties. You also need to modify connection parameters at pom.xml for reseting database data.
3. Go into garrus-backend.

```
cd garrus-backend
```

4. Run the following command. This will download dependecies, compile code, create the initial tables and populate some test data.

```
mvn clean install -Denvironment=reset
```

5. Start the backend. By default it runs in port 8080.

```
mvn spring-boot:run
```

6. Test the rest service

```
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/public/user/login --data '{"username":"konum","password":"1234"}'
```

7. Go into the front-end and run

```
ng serve
```


Front end should be running at http://localhost:4200. For login use konum/1234

## Running the tests

Create a database called garrus_test. Junit Test will reset this database and ensure junit doesn't wipe the develop database. Testing data is in file /wrex-backend/src/test/resources/db_test_data.sql.

Only junit attached for now. Running a mvn clean install -Denvironment=test will:

- Clear database and reset tables.
- Run Junit test against testing database.


## Structure

Pending...

## Deployment

Pending...

## Authors

* **Guillermo Gefaell** - *Initial work* - [PurpleBooth](https://github.com/konum)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Jerome Loisel for his JWT sprint boot java code. (https://github.com/jloisel)
* Garrus image by Daniel Bogni https://www.deviantart.com/danielbogni/art/Garrus-Vakarian-295180533

