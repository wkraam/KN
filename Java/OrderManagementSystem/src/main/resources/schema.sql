CREATE TABLE IF NOT EXISTS customer (
    id int PRIMARY KEY,
    registrationCode int,
    fullName VARCHAR(255),
    email VARCHAR(255),
    telephone int
);

Create table if not exists product (
    id int primary key,
    productName varchar(255),
    skuCode int,
    unitPrice float
);