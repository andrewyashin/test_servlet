INSERT INTO customers (name, surname, age, email, password) VALUES ('Alex', 'One', 20, 'alex@mail.com', 'q12345');
INSERT INTO customers (name, surname, age, email, password) VALUES (Bob, 'Two', 18, 'alex@mail.com', 'q12345');
INSERT INTO customers (name, surname, age, email, password) VALUES ('Mike', 'Three', 5, 'mike@mail.com', 'q1234');
INSERT INTO customers (name, surname, age, email, password) VALUES ('John', 'Four', 2, 'john@mail.com', 'q12q');

INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('ADMIN');

INSERT INTO customer_role (customer_id, role_id) VALUES (1, 1);
INSERT INTO customer_role (customer_id, role_id) VALUES (1, 2);
INSERT INTO customer_role (customer_id, role_id) VALUES (2, 1);
INSERT INTO customer_role (customer_id, role_id) VALUES (3, 1);
INSERT INTO customer_role (customer_id, role_id) VALUES (4, 1);

INSERT INTO houses (address, owner_id) VALUES ('Kyiv, Khreschatyk str., 23, 112', 2);
INSERT INTO houses (address) VALUES ('Kyiv, Khreschatyk str., 23, 111');