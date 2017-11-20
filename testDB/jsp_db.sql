CREATE TABLE tbl_user (
    id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL DEFAULT '',
    password VARCHAR(50) NOT NULL DEFAULT '',
    email VARCHAR(50) DEFAULT '',
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE tbl_address (
    id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    city VARCHAR(20) DEFAULT NULL,
    country VARCHAR(20) DEFAULT NULL,
    user_id INT(11) UNSIGNED NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;



insert into tbl_user(id,name,password,email)
values
(1,"lvhongbin",12345687,"hblvsjtu@163.com"),
(2,"lvhongchao",12345687,"hclvsjtu@163.com");

insert into tbl_address(city,country,user_id)
values
("shanghai","china",1),
("guangzhou","china",2);

select * from jsp_db.tbl_user;
select * from jsp_db.tbl_address;