-- USE STOCKBUSTER;
--  -- INSERT INTO sales_history(product,nr_of_products, timestamp_sale) VALUES('line[0]','2','12.3534');
--  SELECT * FROM SALES_HISTORY;
--  select * from INVENTORY;
--  SELECT product, ROUND(AVG(nr_of_products)) avg_products_daily FROM sales_history group by product;

DROP DATABASE playlist;
CREATE DATABASE playlist;
USE playlist;

CREATE TABLE albums (
  id INT NOT NULL AUTO_INCREMENT,
  release_year INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  artist VARCHAR(255) NOT NULL,
  genre VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE artists (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE genres (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE album_genres (
  id INT NOT NULL AUTO_INCREMENT,
  album_id INT NOT NULL,
  genre_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (album_id) REFERENCES albums(id),
  FOREIGN KEY (genre_id) REFERENCES genres(id)
);
