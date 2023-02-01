# AUTO SERVICE APPLICATION
**Description** 📄

Auto Service Application created to save cars, maintenances and orders to the database.
The program is written in Java with Spring Boot and uses PostgreSQL.
For API testing, you can use Swagger, which is also available in the application.

**Project structure** 📄

The project based on N-Tier architecture:
- DAO layer - CRUD operations with database entities
- DTO layer - representing models on UI layer
- Service layer - business logic of the application
- Controllers - accept requests from the clients and send responses

**Technologies** 📡
- JDK 17
- Spring Boot
- PostgreSQL 15.1
- Maven 4.0.0
- Docker


**Instruction to run the project** 📄
1. Clone your repository to IDE
2. Run the command: mvn clean package.
3. After that enter the command: docker-compose up.
4. Now you can test the program in your browser: http://localhost:6868/swagger-ui.html
