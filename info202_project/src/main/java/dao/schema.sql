
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
customer_id int(10) not null,
username varchar(50) not null,
firstname varchar(50) not null,
surname varchar(50) not null,
password varchar(50) not null,
email_address varchar(100) not null,
shipping_adddress varchar(100) not null,
constraint Customer_PK primary key (customer_id)
);


