```markdown
# Todo API

Todo API is a backend application developed in Spring Boot that allows you to manage a list of tasks. It provides RESTful endpoints for creating, reading, updating, and deleting tasks, with error handling for bad requests.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (or another relational database)
- Lombok
- Spring Doc

## Installation and Setup

### Prerequisites

- JDK 17 or higher
- Maven
- MySQL (or another database)
- Postman,Thunder Client (optional, for testing the API)

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/SethLawson07/todoapi.git
   cd todoapi
   ```

2. Set up the MySQL database (or another database). Create a schema for the application and configure the connection settings in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tododb
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. The API will be available at `http://localhost:8080/api/todo`.

## Project Structure

- `models`: Contains the data model classes, such as `Todo`.
- `repository`: Contains the `ITodoRepository` interface for database operations.
- `services`: Contains business logic in `TodoService`.
- `controllers`: Exposes API endpoints in `TodoController`.
- `validators`: Contains validation classes, such as `TodoValidator`.
- `utils`: Contains utility classes, such as `StringUtils`.
- `exception`: Contains custom exception classes, such as `TodoBadRequestException`, which extends `RuntimeException` to handle invalid requests.

## API Endpoints

### Create a Task

- **Method**: `POST`
- **URL**: `/api/todo`
- **Example Body**:
  ```json
  {
    "title": "Buy groceries",
    "description": "Buy vegetables and bread",
    "status": false
  }
  ```

### Get All Tasks

- **Method**: `GET`
- **URL**: `/api/todo`

### Get a Task by ID

- **Method**: `GET`
- **URL**: `/api/todo/{id}`

### Update a Task

- **Method**: `PUT`
- **URL**: `/api/todo/{id}`
- **Example Body**:
  ```json
  {
    "title": "Clean the house",
    "description": "Do the cleaning",
    "status": true
  }
  ```

### Delete a Task

- **Method**: `DELETE`
- **URL**: `/api/todo/{id}`

## Error Handling

- `400 Bad Request`: Managed by the `TodoBadRequestException` for handling validation errors (e.g., missing title or description).
- `404 Not Found`: If the requested item does not exist.
- `500 Internal Server Error`: General server errors.