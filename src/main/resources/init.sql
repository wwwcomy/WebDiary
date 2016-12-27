CREATE TABLE users (
userid serial NOT NULL,
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
PRIMARY KEY ("userid")
);

CREATE TABLE diary (
id serial NOT NULL,
userid int4 NOT NULL,
created_date timestamp(6),
last_update_date timestamp(6),
title varchar(128),
weather varchar(128),
content varchar(4000),
PRIMARY KEY ("id")
);

insert into users (userid,password,email,name,deleted,status) values ('1','1','1@1.com','1@1.com',0,0);
insert into diary (id,userid,created_date,last_update_date,title,weather,content) values('1','1','2016-12-20','2016-12-20','title1','Sunny','Test Content');
insert into diary (id,userid,created_date,last_update_date,title,weather,content) values('2','1','2016-12-20','2016-12-20','title2','Sunny','Test Content2');

