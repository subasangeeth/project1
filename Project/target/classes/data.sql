
CREATE TABLE IF NOT EXISTS Students(rollno varchar(20) primary key,username varchar(20),password varchar(20),role varchar(20) default 'student');
CREATE TABLE IF NOT EXISTS otherUsers(email varchar(50) primary key,username varchar(20),password varchar(20),role varchar(20) default 'guest');