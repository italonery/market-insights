CREATE TABLE marketplace(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  abbreviation VARCHAR(6) NULL,
  created_on TIMESTAMP NULL,
  created_by VARCHAR(50) NULL,
  modified_on TIMESTAMP,
  modified_by VARCHAR(50),

CONSTRAINT chk_abbreviation_length CHECK (LENGTH(abbreviation) >= 2)
);