create database serverless_iot_rfid;
use serverless_iot_rfid;
create table User(
   Id int auto_increment primary key,
   RFID varchar(55) not null unique,
   username varchar(50) not null,
   userpass varchar(50) not null,
   usertype  varchar(50) not null,
   createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
select*from User;
drop table User;

insert into User(RFID,username,userpass,usertype) values ('241283728','khalid','123','student');