# User Management Application

This is a User Management Application built with Java and Spring Boot. It provides RESTful APIs to manage user data, including adding, retrieving, and filtering users.

## Features

- Add all users
- Get all users
- Get users by role
- Get users by age order
- Get users by filter

## Technologies Used

- Java
- Spring Boot
- Maven

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/Jaydeosahu97/Orchestration-API.git
    ```
2. Navigate to the project directory:
    ```sh
    cd Orchestration-API
    ```
3. Build the project:
    ```sh
    mvn clean install
    ```

### Running the Application

1. Run the application:
    ```sh
    mvn spring-boot:run
    ```
2. The application will start on `http://localhost:8080`.

### API Endpoints

- **Add All Users**
    - **URL:** `/api/users/add-all`
    - **Method:** `GET`
    - **Response:** `String` (confirmation message)

- **Get All Users**
    - **URL:** `/api/users`
    - **Method:** `GET`
    - **Response:** `List<User>`

- **Get Users by Role**
    - **URL:** `/api/users/role/{role}`
    - **Method:** `GET`
    - **Response:** `List<User>`

- **Get Users by Age Order**
    - **URL:** `/api/users/age`
    - **Method:** `GET`
    - **Query Param:** `order` (ASC or DESC)
    - **Response:** `List<User>`

- **Get Users by Filter**
    - **URL:** `/api/users/filter/{name}/{value}`
    - **Method:** `GET`
    - **Response:** `User`
    - **Supported Filters:** `id , ssn`(pass it in name path variable)

## Running Tests

1. Run the tests:
    ```sh
    mvn test
    ```

## License

This project is licensed under the MIT License.