E-Voting System

1. Overview
The E-Voting System is designed to facilitate online elections efficiently. Users can create elections, cast votes, and monitor election results in a secure and organized manner. This application is built using **Spring Boot**, **Hibernate**, and **MySQL**, ensuring smooth and efficient data management.

2. Features
- Create, update, delete, and view elections.
- Add and manage election choices.
- Cast and count votes securely.
- Monitor election results in real-time.
- User authentication for secure voting.

3. Tech Stack
- **Backend:** Spring Boot, Hibernate
- **Database:** MySQL
- **Tools:** Maven, Postman (for API testing)

4. Installation & Setup
### Prerequisites
- Java 17+
- MySQL Database
- Maven
- IDE - Eclipse

5. Steps to Setup
   

1. Configure MySQL Database
   - Create a new database in MySQL:
     
     CREATE DATABASE evoting_system;
     
   - Update application.yml file with your MySQL credentials:
     
     spring.datasource.url=jdbc:mysql://localhost:3306/evoting_system
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
    

2. Build and Run the Application
   
   mvn clean install
   mvn spring-boot:run
   

3. Access the Application
   - API endpoints will be available at http://localhost:8080

6. API Endpoints
Election APIs
- POST /api/elections - Create an election
- GET /api/elections - Get all elections
- PUT /api/elections/{id} - Update an election
- DELETE /api/elections/{id} - Delete an election

7. Choice APIs
- POST /api/choices - Add election choices
- GET /api/choices - Get all choices
- PUT /api/choices/{id} - Update election choices
- DELETE /api/choices/{id} - Delete election choices

8. Vote APIs
- POST /api/votes - Cast a vote
- GET /api/votes - Get all votes

9. Future Enhancements
- Add authentication and user roles.
- Implement real-time election monitoring.
- Develop a user-friendly frontend UI.
- Export election results in CSV/PDF format.


![image](https://github.com/user-attachments/assets/11ce6749-a2cb-4160-8d13-d8366b0d9379)


