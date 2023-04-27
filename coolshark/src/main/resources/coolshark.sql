create database cs charset=utf8;
use cs;
create table user(
    id int primary key auto_increment,
    username varchar(20) not null,
    password varchar(20) not null,
    nickname varchar(20) not null,
    created_at timestamp)charset utf8;
insert into user values (null,'admin','123456','管理员',null);
create table category
(
    id   int primary key auto_increment,
    name varchar(50)
);
insert into category
values (null, '精彩活动'),
       (null, '品牌男装'),
       (null, '数码科技'),
       (null, '母婴产品');
CREATE TABLE banner(id INT PRIMARY KEY AUTO_INCREMENT,url VARCHAR(100));
INSERT INTO banner VALUES(NULL ,'/imgs/b1.jpg'),(NULL ,'/imgs/b2.jpg'),(NULL ,'/imgs/b3.jpg'),(NULL ,'/imgs/b4.jpg');
delete from category where id>5 and id<10;
delete  from