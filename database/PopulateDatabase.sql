INSERT INTO items VALUES (1, 'Taco', 5.99, 'None', 160, TRUE, 'Meat,Vegetable,Food');
INSERT INTO items VALUES (2, 'Quesadilla', 7.99, 'None', 200, FALSE, 'Meat,Vegetable,Food');
INSERT INTO items VALUES (3, 'Guacamole', 2.99, 'None', 60, TRUE, 'Vegetable,Food');
INSERT INTO items VALUES (4, 'Soda', 1.99, 'None', 300, TRUE, 'Sweet,Drink');

INSERT INTO tables VALUES(1, TRUE);
INSERT INTO tables VALUES(2, TRUE);
INSERT INTO tables VALUES(3, TRUE);
INSERT INTO tables VALUES(4, FALSE);
INSERT INTO tables VALUES(5, TRUE);

INSERT INTO orders(order_number, customer_id, table_number, items, price, order_time, status) VALUES 
    (1, 999, 1, [1, 3, 4], 10.97, '12:30', 'Pending'),
    (2, 999, 3, [1, 2], 13.98, '12:30', 'Completed'),
    (3, 999, 4, [2], 7.99, '12:30', 'Pending'),
    (4, 999, 5, [4], 1.99, '12:30', 'Completed'),
    (5, 999, 2, [1, 4], 7.98, '12:30', 'Pending');
    
INSERT INTO complaints (customer_id, table_number, status) VALUES
    (999, 5, 'Great Service'),
    (999, 4, 'Delayed Service');
    
INSERT INTO bills (customer_id, table_number, items, price, status) VALUES
    (999, 1, [1, 3, 4], 10.97, 'Paid'),
    (999, 3, [1, 2], 13.98, 'Unpaid'),
    (999, 4, [2], 7.99,'Paid'),
    (999, 5, [4], 1.99, 'Unpaid),
    (999, 2, [1, 4], 7.98, 'Paid');

    
