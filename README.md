
# Advanced Software Engineering Project: Job Platform API

This repository contains the source code and documentation for the Advanced Software Engineering course project, a Job Platform API. The API is developed using Spring Boot and utilizes Spring Data JPA for handling and creating the database. MySQL is used as the relational database.

## Team Members
1. [Khaled Jeetan](https://github.com/khaledJeetan)
2. Mohammed Masood
3. Hadi Nassar

## Prerequisites
Before running the API, ensure that you have the following software installed on your machine:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MySQL

## Setting Up the Database

To set up the database, follow these steps:

1. Install MySQL on your machine if it is not already installed.
2. Create a new database with the name `job_platform`.
3. Set the database configuration in the `application.properties` file located in the project's root directory. You can provide the necessary configuration by updating the following properties:

`spring.datasource.url=jdbc:mysql://localhost:3306/job_platform`

`spring.datasource.username=root`

`spring.datasource.password=<password>`


Replace `<password>` with the password for your MySQL root user.

## Building and Running the API

To build and run the API, perform the following steps:

1. Clone this repository to your local machine or download the source code.
2. Open a command line interface and navigate to the project's root directory.
3. Build the project using Maven by running the following command:

`mvn clean install`


4. After the build is successful, start the API by running the following command:

`mvn spring-boot:run`


This will start the API on the default port `8080`.

## API Documentation
Once the API is up and running, you can access the documentation and interact with the endpoints using Swagger UI.

Open your web browser and go to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html). This will display the API documentation with the available endpoints and their descriptions.

## Contributing
We welcome contributions to this project. If you would like to contribute, please follow these guidelines:

- Fork the repository and create your branch from `main`.
- Make your changes and test thoroughly.
- Ensure your code adheres to the existing code style and follows best practices.
- Submit a pull request explaining the changes you have made.

## Issues
If you encounter any issues or have any suggestions, please [open an issue](https://github.com/khaledJeetan/job-board-platform-api/issues) on this repository. We appreciate your feedback!
