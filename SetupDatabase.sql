CREATE TABLE orders
(order_number int,
customer_id int NOT NULL,
table_number int NOT NULL,
items nchar(100) NOT NULL,
price smallmoney NOT NULL,
order_time datetime2 NOT NULL,
status nchar(20) NOT NULL);

CREATE TABLE items
(item_number int,
item_name nchar(50) NOT NULL,
price smallmoney NOT NULL,
allergies nchar(100) NOT NULL,
calories float(24) NOT NULL,
available boolean NOT NULL,
tags nchar(100) NOT NULL);

CREATE TABLE complaints
(customer_id int,
table_number int NOT NULL,
status nchar(20) NOT NULL);

CREATE TABLE bills
(customer_id int,
table_number int NOT NULL,
items nchar(200) NOT NULL,
price smallmoney NOT NULL,
status nchar(20) NOT NULL);

CREATE TABLE tables
(table_number int,
available boolean NOT NULL);


