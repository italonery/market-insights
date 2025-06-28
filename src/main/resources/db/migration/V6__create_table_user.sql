CREATE TABLE users(
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(20) UNIQUE NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  active BIT NOT NULL,
  created_on TIMESTAMP NULL,
  created_by VARCHAR(50) NULL,
  modified_on TIMESTAMP NULL,
  modified_by VARCHAR(50) NULL,

CONSTRAINT chk_username_length CHECK (LENGTH(username) >= 5)
);