CREATE TABLE category(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(200) NULL,
  created_on TIMESTAMP NULL,
  created_by VARCHAR(50) NULL,
  modified_on TIMESTAMP,
  modified_by VARCHAR(50)
);