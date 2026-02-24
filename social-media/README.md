# Social Media Project - Authentication Concepts

This document explains the authentication mechanisms used in this project. We use **BCrypt** for secure password hashing and **JWT (JSON Web Tokens)** for stateless authentication.

## 1. BCrypt - Password Hashing

In our backend, we use the `at.favre.lib:bcrypt` library to securely store user passwords in the database. Passwords are never stored in plain text.

### How BCrypt works in our project

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

## 2. JWT (JSON Web Tokens) - Stateless Authentication

We use the `io.jsonwebtoken` (JJWT) library to handle user sessions statelessly. After a successful login, the server issues a JWT instead of keeping a user session in memory.

### How JWT works in our project

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
