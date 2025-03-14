# Backend Restaurant App

## Overview
This is the backend for the Restaurant App, built using Spring Boot.

## Technologies Used
- **Java Version**: 21
- **Build Tool**: Maven
- **Database**: PostgreSQL

## Setup Instructions

1. **Clone the repository**  
   ```sh
   git clone <repository-url>
   cd backend-restaurant-app
   ```

2. **Update Database Credentials**  
   Before running the application, update the PostgreSQL credentials in `application.properties` file.
   
3. **Run the Application**  
   Ensure the application runs on port `8080` since the frontend is configured to connect to this port.
   ```sh
   mvn spring-boot:run
   ```

4. **Verify the API**  
   Once the server is running, you can check if the backend is working by accessing:
   ```
   http://localhost:8080/
   ```

## Notes
- The PostgreSQL database must be running before starting the backend.
- Make sure the frontend (running on port `4200`) is correctly configured to communicate with this backend.

## Author
- **Your Name** (Replace with your actual name)
