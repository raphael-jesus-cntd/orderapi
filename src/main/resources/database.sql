CREATE DATABASE IF NOT EXISTS orders_db;

USE orders_db;

CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    control_number VARCHAR(255) NOT NULL,
    registration_date DATETIME NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

INSERT INTO customers (name) VALUES 
('Customer 1'),
('Customer 2'),
('Customer 3'),
('Customer 4'),
('Customer 5'),
('Customer 6'),
('Customer 7'),
('Customer 8'),
('Customer 9'),
('Customer 10');
