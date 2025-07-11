CREATE TABLE product(
  id INT PRIMARY KEY AUTO_INCREMENT,
  sku VARCHAR(50) UNIQUE NOT NULL,
  name VARCHAR(100) NOT NULL,
  brand_id INT NOT NULL,
  category_id INT NOT NULL,
  feature1 VARCHAR(200) NULL,
  feature2 VARCHAR(200) NULL,
  feature3 VARCHAR(200) NULL,
  created_on TIMESTAMP NULL,
  created_by VARCHAR(50) NULL,
  modified_on TIMESTAMP NULL,
  modified_by VARCHAR(50) NULL,


CONSTRAINT fk_product_brand FOREIGN KEY (brand_id)
  REFERENCES brand(id)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,

CONSTRAINT fk_product_category FOREIGN KEY (category_id)
  REFERENCES category(id)
  ON DELETE RESTRICT
  ON UPDATE CASCADE
);