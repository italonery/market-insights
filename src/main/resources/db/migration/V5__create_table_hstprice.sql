CREATE TABLE hstprice(
  id INT PRIMARY KEY AUTO_INCREMENT,
  product_id INT NOT NULL,
  marketplace_id INT NOT NULL,
  price DOUBLE NOT NULL,
  date_ref DATE NOT NULL,

CONSTRAINT fk_hstprice_product FOREIGN KEY (product_id)
  REFERENCES product(id),

CONSTRAINT fk_hstprice_marketplace FOREIGN KEY (marketplace_id)
  REFERENCES marketplace(id),

CONSTRAINT chk_price CHECK (price > 0)
);