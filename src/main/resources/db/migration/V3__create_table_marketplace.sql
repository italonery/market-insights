CREATE TABLE marketplace(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  abbreviation VARCHAR(6) NULL,

CONSTRAINT chk_abbreviation_lenght CHECK (LENGTH(abbreviation) >= 2)
);