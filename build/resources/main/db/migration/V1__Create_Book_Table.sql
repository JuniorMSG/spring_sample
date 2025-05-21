   -- V1__Initial_Setup.sql
   CREATE TABLE books (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          author VARCHAR(255) NOT NULL,
                          description TEXT,
                          isbn VARCHAR(17) NOT NULL UNIQUE,
                          publication_year INT
   );