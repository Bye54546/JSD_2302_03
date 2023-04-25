create table students(
    id int(10) primary key auto_increment,
    name varchar (50),
    age int,
    gender varchar (10),
    class_id int
)charset=utf8;
create table class(
    id int primary key auto_increment,
    class_name varchar (50),
    teacher_name varchar (50),
    grade_level varchar (10)
)charset=utf8;
insert into class
values (null, '五班', '传奇哥', '三年级'),
       (null, 'er班', '周杰伦', '三年级');
