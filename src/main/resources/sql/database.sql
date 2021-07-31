CREATE TABLE IF NOT EXISTS customers (
 id serial
  CONSTRAINT customers_pk
   PRIMARY KEY,
 name varchar(12),
 surname varchar(22),
 age int,
 email varchar(22) UNIQUE NOT NULL,
 password varchar(255) NOT NULL
);

CREATE TABLE roles (
 id serial
  CONSTRAINT roles_pk
   PRIMARY KEY,
 name varchar(12)
UNIQUE NOT NULL
);

CREATE TABLE customer_role (
 customer_id int,
 role_id int
);

CREATE TABLE houses (
 id serial
  CONSTRAINT houses_pk
   PRIMARY KEY,
 address varchar(255)
UNIQUE NOT NULL,
owner_id int
);