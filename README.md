# Job Application REST API

This is a **Spring Boot** application for managing job posts, implementing **Spring Security** for authentication and **Spring Data JPA** for database interactions.

## Features
- **Spring Security** with BCrypt password hashing.
- **RESTful API** with CRUD operations.
- **CORS enabled** for frontend integration.
- **Job search functionality** by keyword.
- **Stateless authentication** using JWT (or Basic Auth).

---

## Technologies Used
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **BCrypt Password Encoding**
- **REST API**
- **PostgreSQL Database**

---

## API Endpoints

| Method  | Endpoint                  | Description |
|---------|---------------------------|-------------|
| GET     | `/jobPosts`                | Get all job posts |
| GET     | `/jobPosts/{postId}`        | Get a specific job post by ID |
| POST    | `/jobPosts`                 | Add a new job post |
| PUT     | `/jobPosts`                 | Update an existing job post |
| DELETE  | `/jobPosts/{postId}`        | Delete a job post |
| GET     | `/jobPosts/keyword/{keyword}` | Search job posts by keyword |
| GET     | `/load`                     | Load default job posts |

---

## Security Configuration
- **Authentication** is handled using `MyUserDetailsService`.
- Passwords are **hashed using BCrypt** before storage.
- **CSRF protection** is disabled for API access.
- Stateless authentication is enforced.

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(customizer -> customizer.disable())
        .authorizeHttpRequests(request -> request.anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    
    return http.build();
}
