INSERT INTO CUSTOMER_DETAILS(first_name, last_name, phone) VALUES
('Luka', 'Rukavina', '0995149101');

INSERT INTO CUSTOMER(username, customer_details_id) VALUES
('lrukavina', 1);

INSERT INTO DELIVERY(customer_id, submission_date) VALUES
(1, '2021-08-11');

INSERT INTO PIZZA(id, name) VALUES
(1, 'Calzone'),
(2, 'Marinara');

INSERT INTO PIZZA_ORDER(quantity, size, pizza_id, delivery_id) VALUES
('2', 'LARGE', 1, 1),
('1', 'MEDIUM', 2, 1);

INSERT INTO INGREDIENT(id, name, pizza_id) VALUES
(1,'TOMATO_SAUCE', 1),
(2,'MOZZARELLA', 1),
(3,'OREGANO', 1),
(4,'HAM', 1),
(5,'MUSHROOMS', 1),
(6,'ARTICHOKES', 1),
(7,'ANCHOVIES', 1),
(8, 'TOMATO_SAUCE', 2),
(9,'GARLIC', 2),
(10,'BASIL', 2);


