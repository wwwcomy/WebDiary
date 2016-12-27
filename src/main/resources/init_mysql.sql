CREATE TABLE users (
  userid int(11) NOT NULL auto_increment,
  name varchar(255) default NULL,
  password varchar(128),
  salt varchar(128),
  email varchar(255) default NULL,
  phone varchar(255) default NULL,
  last_login datetime default NULL,
  created_date datetime default NULL,
  status int(11) NOT NULL,
  deleted int(11) NOT NULL,
  password varchar(255) default NULL,
  modified_date datetime default NULL,
  lastLogin datetime default NULL,
  PRIMARY KEY  (userid)
);

CREATE TABLE diary (
  id int(11) NOT NULL auto_increment,
  content longtext,
  created_date datetime default NULL,
  last_update_date datetime default NULL,
  title varchar(255) default NULL,
  weather varchar(255) default NULL,
  userId int(11) default NULL,
  PRIMARY KEY  (id),
)

insert into users (userid,password,email,name,deleted,status) values ('1','1','1@1.com','1@1.com',0,0);
insert into diary (id,userid,created_date,last_update_date,title,weather,content) values('1','1','2016-12-20','2016-12-20','title1','Sunny','Test Content');
insert into diary (id,userid,created_date,last_update_date,title,weather,content) values('2','1','2016-12-20','2016-12-20','title2','Sunny','Test Content2');

