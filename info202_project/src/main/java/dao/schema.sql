
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
create table Sale(
sale_id int(10) auto_increment(1000),
date timestamp not null,
status varchar(500) not null,
customer_id int(10) not null,
constraint Sale_PK primary key (sale_id),
constraint Sale_Customer_FK foreign key (customer_id) references Customer(customer_id)
);
create table SaleItem(
quantityPurchased decimal(6,2) not null,
salePrice decimal(6,2) not null,
sale_id int(10) not null,
productID varchar(50) not null,
constraint SaleItem_PK primary key (sale_id, productID),
constraint SaleItem_Sale_FK foreign key (sale_id) references Sale(sale_id),
constraint SaleItem_Product_FK foreign key (ProductID) references Product(ProductID)
);
