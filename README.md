# KN
## QuizApp
### SQL to set up the databases
create table questions(
id serial primary key,
difficulty int not null ,
question varchar not null,
answer int not null,
topic int not null
);

CREATE TABLE answers (
id serial NOT NULL primary key ,
answer varchar NOT NULL,
correct bool NOT NULL
);

create table answerstoquestions(
id serial not null primary key ,
questionid int2 not null,
answerid int2 not null
);

create table topics(
id int primary key not null,
topicBody varchar
);

ALTER TABLE questions ADD CONSTRAINT topics_fk FOREIGN KEY (topic) REFERENCES topics(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE answerstoquestions ADD CONSTRAINT answers_fk FOREIGN KEY (answerid) REFERENCES answers(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE answerstoquestions ADD CONSTRAINT questions_fk FOREIGN KEY (questionid) REFERENCES questions(id) ON DELETE CASCADE ON UPDATE CASCADE;



### SQL to populate the databases

insert into questions(id, difficulty, question, answer, topic)  VALUES (1, 1, 'hdd', 1, 2);

insert into questions(difficulty, question, answer, topic)  VALUES (2, 'sdd', 2, 3);


insert into topics(topicBody) values ('topic6');

insert into topics(id, topicBody) values (-1, 'testing');



insert into answers(answer, correct) VALUES ('this is a hard disk drive', true);

insert into answers(answer, correct) VALUES ('this is a hard disk drive', false);

insert into answers(answer, correct) VALUES ('this is a hybrid drive', true);

insert into answers(answer, correct) VALUES ('this is a hybrid drive', false);

insert into answers(answer, correct) VALUES ('this is unknown', true);

insert into answers(answer, correct) VALUES ('this is unknown', false);



insert into answerstoquestions(questionid, answerid) VALUES (1,1);

insert into answerstoquestions(questionid, answerid) VALUES (1,4);

insert into answerstoquestions(questionid, answerid) VALUES (1,6);

insert into answerstoquestions(questionid, answerid) VALUES (1,8);

insert into answerstoquestions(questionid, answerid) VALUES (2,1);

insert into answerstoquestions(questionid, answerid) VALUES (2,3);

insert into answerstoquestions(questionid, answerid) VALUES (2,5);

insert into answerstoquestions(questionid, answerid) VALUES (2,8);

insert into answerstoquestions(questionid, answerid) VALUES (3,2);

insert into answerstoquestions(questionid, answerid) VALUES (3,3);

insert into answerstoquestions(questionid, answerid) VALUES (3,6);

insert into answerstoquestions(questionid, answerid) VALUES (3,8);

insert into answerstoquestions(questionid, answerid) VALUES (4,2);

insert into answerstoquestions(questionid, answerid) VALUES (4,7);

insert into answerstoquestions(questionid, answerid) VALUES (5,7);

insert into answerstoquestions(questionid, answerid) VALUES (6,7);

## Order Management System
CRUD operations for **OrderManagementSystem** project. RequestBody formating is in JSON.

### Get Customers
Operation: GET

URI: http://localhost:8080/api/getOrders


### Get Products
Operation: GET

URI: http://localhost:8080/api/getProducts


### Get Orders
Operation: GET

URI: http://localhost:8080/api/getOrders


### Add Customer
Operation: Post

URI: http://localhost:8080/api/addCustomer

Body: 
`
{  
  "registrationCode": *long*,
  "fullName": *String*,      
  "email": *String*,      
  "telephone": *long*   
}
`

### Add Product
Operation: Post

URI: http://localhost:8080/api/addProduct

Body:
`
{
    "productName": *String*,
    "skuCode": *long*,
    "unitPrice": *float*
}
`
### Order
Operation: Post

URI: http://localhost:8080/api/order

Body:
`
{
    "productid": *long*,
    "quantity": *float*,
    "customerid": *long*
}
`
### Search Orders By Date
Operation: Post

URI: http://localhost:8080/api/getOrdersByDate

Body:
`
{
    "date": *String, formating: yyyy-MM-dd*
}
`
### Search Orders By Customer
Operation: Post

URI: http://localhost:8080/api/getOrdersByCustomer

Body:
`
{
        "registrationCode": *long*,
        "fullName": *String*,
        "email": *String*,
        "telephone": *long*
}
`

### Search Orders By Product
Operation: Post

URI: http://localhost:8080/api/getOrdersByProduct

Body:
`
{
    "productName": *String*,
    "skuCode": *long*,
    "unitPrice": *float*
}
`
