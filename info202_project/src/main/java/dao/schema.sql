
create table Product(
productID varchar(50) not null,
name varchar(50) not null,
description varchar(100) not null,
category varchar(100) not null,
listPrice decimal(6,2) not null,
quantityInStock decimal(6,2) not null,
constraint Product_PK primary key (productID)
);
create table Customer(
customer_id int(10) auto_increment(1000),
username varchar(50) not null unique,
firstname varchar(50) not null,
surname varchar(50) not null,
password varchar(100) not null,
email_address varchar(100) not null,
shipping_adddress varchar(500) not null,
constraint Customer_PK primary key (customer_id)
);


