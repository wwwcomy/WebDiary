CREATE TABLE users (
userid varchar(32) NOT NULL,
name varchar(64),
password varchar(128),
salt varchar(128),
email varchar(64),
phone varchar(64),
status int4,
lastLogin timestamp(6),
created_date timestamp(6),
deleted varchar(32),
modified_date timestamp(6),
enabled bool,
password_expired_date timestamp(6),
PRIMARY KEY ("userid")
);

CREATE TABLE diary (
id varchar(32) NOT NULL,
userid varchar(32) NOT NULL,
created_date timestamp(6),
last_update_date timestamp(6),
title varchar(128),
weather varchar(128),
content varchar(4000),
PRIMARY KEY ("id")
);

insert into users (userid,password,name,deleted,status) values ('1','1','1@1.com',0,0);
insert into diary (id,userid,created_date,last_update_date,title,weather,content) values('1','1','2016-12-20','2016-12-20','title1','Sunny','Test Content');

