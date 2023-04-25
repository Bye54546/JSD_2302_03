CREATE DATABASE weibo CHARSET=UTF8;
USE weibo;
CREATE TABLE user
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    nickname VARCHAR(50)
) CHARSET = UTF8;


CREATE TABLE weibo
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(255),
    urls    TEXT,
    created TIMESTAMP,
    user_id INT
) CHARSET = UTF8;


CREATE TABLE comment
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    content  VARCHAR(255),
    created  TIMESTAMP,
    user_id  INT,
    weibo_id INT
) CHARSET = UTF8;
