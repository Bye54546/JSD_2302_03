CREATE DATABASE cs CHARSET=UTF8;
USE cs;
CREATE TABLE user
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    nickname VARCHAR(50),
    created  TIMESTAMP
) CHARSET = UTF8);

INSERT INTO user VALUES(NULL,'admin','123456','管理员',NULL);

CREATE TABLE category
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

INSERT INTO category
VALUES (NULL, '精彩活动'),
       (NULL, '品牌男装'),
       (NULL, '数码科技'),
       (NULL, '母婴产品');


CREATE TABLE banner
(
    id  INT PRIMARY KEY AUTO_INCREMENT,
    url VARCHAR(100)
);

INSERT INTO banner
VALUES (NULL, '/imgs/b1.jpg'),
       (NULL, '/imgs/b2.jpg'),
       (NULL, '/imgs/b3.jpg'),
       (NULL, '/imgs/b4.jpg');

CREATE TABLE product
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),price DOUBLE(10,2),
    old_price DOUBLE(10,2),sale_count INT,
    num INT,category_id INT,url VARCHAR(100),
    view_count INT,created TIMESTAMP
);
# 禁止自动更改时间
alter table product change created created TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP;
# 启用自动更改时间
alter table product change created created TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP On update CURRENT_TIMESTAMP;
