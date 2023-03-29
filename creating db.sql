create database solva_db;
drop table solva_db.all_transactions;
use solva_db;
show databases;
create table Users
(
	id int primary key NOT NULL auto_increment, 
    user_name varchar(50),
    user_surname varchar(50),
    cash decimal(15, 2),
    transaction_limit decimal(15, 2),
    pin_code varchar(50)
);

CREATE TABLE All_transactions
(
	id int primary key NOT NULL auto_increment,
    user_id int,
    transaction_amount decimal(15, 2), 
    s_t_date datetime,
    payment decimal(15, 2), 
    payment_date datetime,
    limit_exceeded boolean,
    total_t_amount decimal(15, 2),
    exchange_rate decimal(15, 2)
); 

insert into solva_db.users (user_name, user_surname, cash, transaction_limit, pin_code)
values ('Jack', 'Grealish', 80000, 500, '5555');