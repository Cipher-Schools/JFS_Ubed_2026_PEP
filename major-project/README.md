# Social Media Project

A full-stack social media application allowing users to create accounts, publish posts, leave comments, and like content. The application is built with a Spring Boot backend and a React (Vite) frontend, featuring a sleek, professional "Pitch Black" minimalistic UI.

## Major Project Features

- **User Authentication**: Secure Login and Registration functionality using BCrypt and JWT.
- **Content Interaction**:
  - Logged-in users can create posts, add comments, and like/dislike posts.
  - Unauthenticated users can view public feeds, posts, comments, and likes.
- **Robust Backend**: Data integrity ensured via `@Transactional` methods, proper exception handling (e.g., `UnauthorizedException`, `IllegalArgumentException` for duplicate likes), and prevention of circular JSON serialization.
- **Pitch Black UI**: A modern, premium dark theme frontend using deep blacks and neutral grays, applied across auth pages, feeds, comments, and project layouts.

---

## Client Details (React + Vite)

The frontend is located in the `client/` directory and focuses on a high-performance, premium user experience.

- **Architecture**: React + Vite for fast HMR and modern build tooling.
- **Routing**: Client-side routing for seamless page transitions (Login, Register, Feed, Post Details).
- **Styling**: Pure CSS implementing a global "Pitch Black" design system (main background: `#000000`, surface/cards: `#111111`, text: `#ffffff`/`#a0a0a0`).
- **Components Refactored**: Header, Footer, Post, Feed, Comments, Login, and Register all follow the uniform Pitch Black aesthetic.
- **API Integration**: RESTful communication with the Spring Boot backend, with JWT tokens stored securely to authorize creation/interaction requests.

To run the client:

```bash
cd client
npm install
npm run dev
```

---

## Backend Details (Spring Boot)

The backend is located in the `social-media-be/` directory. We use **BCrypt** for secure password hashing and **JWT (JSON Web Tokens)** for stateless authentication.

### Core Architecture & Validations

- **Data Integrity**: Sensitive data securely hidden using `@JsonIgnoreProperties` and `@JsonIgnore`.
- **Transactions**: Methods performing multiple database operations use `@Transactional` to guarantee atomicity.
- **Database**: PostgreSQL handles the persistent and relational data structure.

### 1. BCrypt - Password Hashing

In our backend, we use the `at.favre.lib:bcrypt` library to securely store user passwords in the database. Passwords are never stored in plain text.

#### How BCrypt works in our project

- **Registration**: When a new user signs up, the `AuthService` extracts the raw password and passes it to the `BCrypt` hashing function with a work factor (log rounds) of `12`.

  ```java
  String hashPass = BCrypt.withDefaults().hashToString(12, req.getPassword().toCharArray());
  newUser.setPassword(hashPass);
  ```

  The resulting hashed string is what gets saved to the database.

- **Login Verification**: When the user logs in, we don't decrypt the password (as hashing is a one-way function). Instead, we take the provided raw password and let BCrypt safely verify if it matches the stored hash.

  ```java
  BCrypt.Result result = BCrypt.verifyer().verify(req.getPassword().toCharArray(), user.getPassword());
  if (!result.verified) {
      throw new RuntimeException("Invalid email or password");
  }
  ```

---

### 2. JWT (JSON Web Tokens) - Stateless Authentication

We use the `io.jsonwebtoken` (JJWT) library to handle user sessions statelessly. After a successful login, the server issues a JWT instead of keeping a user session in memory.

#### How JWT works in our project

- **Token Generation**: Managed by the `JwtUtil` component. Upon successful registration or login, we generate a token setting the user's `email` as the subject. The token uses an HMAC SHA-256 (HS256) signature (seeded by our application's `jwt.secret`) to guarantee its integrity, and includes an `issuedAt` and `expiration` timestamp to ensure it's only valid for a limited time.

  ```java
  public String generateToken(String email){
      return Jwts.builder()
              .subject(email)
              .issuedAt(new Date())
              .expiration(new Date(System.currentTimeMillis() + expiration))
              .signWith(getSecretKey(), SignatureAlgorithm.HS256)
              .compact();
  }
  ```

- **Token Verification**: When the client needs to access a protected route, it sends back the token. Our `verifyToken` method cryptographically verifies the token using the secret key. If valid and not expired, it extracts the user's email to identify who is making the request.

  ```java
  public String verifyToken(String token){
      return Jwts.parser()
              .verifyWith((SecretKey) getSecretKey())
              .build()
              .parseSignedClaims(token)
              .getPayload()
              .getSubject();
  }
  ```

---

## API Documentation

You can explore and test the API endpoints using the provided Postman collection:

[Postman Collection Workspace](https://dark-eclipse-727260.postman.co/workspace/lpu~46ad23b4-3ff7-45e2-880d-6146382f44a4/collection/32782602-d0ce07c0-1503-436a-9fc7-6cdcb730bcbd?action=share&source=copy-link&creator=32782602)
