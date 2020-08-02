create table Product(
productID varchar(50) not null,
name varchar(50) not null,
description varchar(100) not null,
category varchar(100) not null,
listPrice decimal(6,2) not null,
quantityInStock decimal(6,2) not null,
constraint Product_PK primary key (productID)
);


