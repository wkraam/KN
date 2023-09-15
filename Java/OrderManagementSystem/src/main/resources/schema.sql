CREATE TABLE IF NOT EXISTS customer (
    id int PRIMARY KEY,
    registrationCode int,
    fullname VARCHAR(255),
    email VARCHAR(255),
    telephone int
);

Create table if not exists product (
    id int primary key,
    name varchar(255),
    skuCode int,
    unitPrice float
);

Create table if not exists orders (
    id int primary key,
    product int,
    quantity float
);