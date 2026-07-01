Blog API

A RESTful backend API for a blogging platform, built with Java and Spring Boot. Supports creating and managing blog posts, liking posts, and commenting — with secure user authentication via JWT.


This is a backend-only project — no frontend is included. It's designed to be consumed by any client (web, mobile, or tools like Postman/Insomnia).



Features


🔐 User authentication — JWT-based login and registration
📝 Posts — create, read, update, and delete blog posts
❤️ Likes — like/unlike posts
💬 Comments — add and view comments on posts
🔒 Protected endpoints requiring a valid JWT for actions like posting, liking, and commenting


Tech Stack


Language: Java
Framework: Spring Boot (Spring Web, Spring Security)
Database: MySQL
Build Tool: Maven
Auth: JWT (JSON Web Tokens)


Getting Started

Prerequisites


Java JDK 17+ (adjust to match your actual version)
Maven
MySQL running locally or accessible remotely


Setup


Clone the repo


bash   git clone https://github.com/Elton2023/blog-api.git
   cd blog-api


Configure the database
Create a MySQL database, then update src/main/resources/application.properties (or application.yml) with your credentials:


properties   spring.datasource.url=jdbc:mysql://localhost:3306/blog_api_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password


Build the project


bash   mvn clean install


Run the application


bash   mvn spring-boot:run

The API will be available at http://localhost:8080 (or your configured port).

API Endpoints


Update this table with your actual routes — this is a placeholder based on the features described.



MethodEndpointDescriptionAuth RequiredPOST/api/auth/registerRegister a new userNoPOST/api/auth/loginLog in and receive a JWTNoGET/api/postsGet all postsNoPOST/api/postsCreate a new postYesPUT/api/posts/{id}Update a postYesDELETE/api/posts/{id}Delete a postYesPOST/api/posts/{id}/likeLike a postYesPOST/api/posts/{id}/commentsAdd a comment to a postYesGET/api/posts/{id}/commentsGet comments for a postNo

Authentication

Most write actions (creating posts, liking, commenting) require a valid JWT. After logging in via /api/auth/login, include the token in the Authorization header of subsequent requests:

Authorization: Bearer <your_token_here>

What I Learned Building This

This project was built to practice designing and securing a real backend API — including relational data modeling (users, posts, comments, likes), implementing stateless authentication with JWT, and structuring a Spring Boot application following REST conventions.

Future Improvements


 Add pagination for posts and comments
 Add unit/integration tests
 Add OpenAPI/Swagger documentation
 Deploy live (e.g. Render, Railway) with a public demo link
