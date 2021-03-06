DROP TABLE IF EXISTS Product;
  
CREATE TABLE Product (
  id IDENTITY AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  subTitle VARCHAR(250) NOT NULL,
  price DOUBLE NOT NULL,
  description VARCHAR(250) NOT NULL,
  rating INT NOT NULL,
  image VARCHAR(250) NOT NULL
);