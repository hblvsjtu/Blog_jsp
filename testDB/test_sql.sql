CREATE TABLE tbl_user (
    user_name VARCHAR(20),
    age INT,
    signup_date DATE
);

insert into tbl_user values("lvhongbin","24","2017-11-16");

select * from tbl_user;

select * from tbl_user where user_name="lvhongbin" and age=24;

update tbl_user set age=30 where user_name="lvhongbin";

delete from tbl_user where user_age=24;

alter table tbl_user add email varchar(50);

alter table tbl_user drop email;

alter table tbl_user change age user_age int;

alter table tbl_user change user_name username VARCHAR(20);

drop table tbl_user;

CREATE TABLE tbl_user (
    username VARCHAR(20),
    userpassword int,
    useremail VARCHAR(50) check (useremail like '%@%')
    );
    
INSERT INTO tbl_user(username, userpassword, useremail) VALUES('lvhongbin',12345687, 'hblvsjtu@163.com');



SELECT * From tbl_user WHERE username='lvhongbin' AND userpassword=12345687;

INSERT INTO tbl_user(username, userpassword, useremail) VALUES("lvhongchao",12345687,"hclvsjtu@163.com")
