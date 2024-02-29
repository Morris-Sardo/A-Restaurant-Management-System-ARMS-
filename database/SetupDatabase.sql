CREATE TABLE orders
(order_number int PRIMARY KEY,
customer_id int NOT NULL,
table_number int NOT NULL,
items nchar(100) NOT NULL,
price float(24) NOT NULL,
order_time nchar(24) NOT NULL,
status nchar(20) NOT NULL);

CREATE TABLE items
(item_number int PRIMARY KEY,
item_name nchar(50) NOT NULL,
price float(24) NOT NULL,
allergies nchar(100) NOT NULL,
calories float(24) NOT NULL,
available boolean NOT NULL,
tags nchar(100) NOT NULL,
stock int NOT NULL);

CREATE TABLE complaints
(customer_id int,
table_number int NOT NULL,
status nchar(20) NOT NULL);

CREATE TABLE bills
(customer_id int,
table_number int NOT NULL,
items nchar(200) NOT NULL,
price  float(24) NOT NULL,
status nchar(20) NOT NULL);

CREATE TABLE tables
(table_number int PRIMARY KEY,
available boolean NOT NULL);


