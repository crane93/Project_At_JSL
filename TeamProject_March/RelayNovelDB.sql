use java;

create table User(
id varchar(10) primary key,
pw varchar(10),
nickname varchar(20),
grade varchar(5),
count_mynovel int(8),
conut_like int(8),
answer_for_pw varchar(20)
);
drop table User;
desc User;

create table novel_info(
line_number int(8)not null,
novel_name varchar(20),
novel_contents varchar(1000),
id varchar(10),
novel_number int(8)not null,
get_like_number int(8),
get_views_number int(8),
primary key(line_number, novel_number)
);
desc novel_info;
drop table novel_info;