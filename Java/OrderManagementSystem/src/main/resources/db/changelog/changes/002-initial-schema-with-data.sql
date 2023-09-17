CREATE TABLE IF NOT EXISTS customer (
    id int PRIMARY KEY,
    registrationCode int,
    fullName VARCHAR(255),
    email VARCHAR(255),
    telephone int
);

insert into customer(id, registrationCode,fullName, email, telephone) values (0, 0000001, 'Juhan Vankris', 'j.vankris@gmail.com', 555626241);
insert into customer(id, registrationCode,fullName, email, telephone) values (1, 0000002, 'Mari Maasik', 'mmaasik@gmail.com', 555623151);
insert into customer(id, registrationCode,fullName, email, telephone) values (2, 0000003, 'Margus Vool', 'voolmargus@gmail.com', 545466241);
insert into customer(id, registrationCode,fullName, email, telephone) values (3, 0000004, 'Peeter Jupp', 'jupipeeter@gmail.com', 562519237);
insert into customer(id, registrationCode,fullName, email, telephone) values (4, 0000005, 'Anu Vankris', 'a.vankris@gmail.com', 595163125);

Create table if not exists product (
    id int primary key,
    productName varchar(255),
    skuCode int,
    unitPrice float
);

insert into product(id, productName, skuCode, unitPrice) values (0, 'Cake', 75979843, 3.70);
insert into product(id, productName, skuCode, unitPrice) values (1, 'Milk', 65116522, 0.85);
insert into product(id, productName, skuCode, unitPrice) values (2, 'Drinking Glass', 20221151, 5.99);
insert into product(id, productName, skuCode, unitPrice) values (3, 'Decorative Glass', 20221153, 10.40);
insert into product(id, productName, skuCode, unitPrice) values (4, 'Regular Glass', 20221152, 4.20);
insert into product(id, productName, skuCode, unitPrice) values (5, 'Water', 85119843, 6.70);