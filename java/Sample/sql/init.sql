create table box (id int primary key auto_increment, name varchar(255) not null);

create table fruit (id int primary key auto_increment, name varchar(255), box_id int);
alter table fruit add foreign key (box_id) references box(id);

insert into box (name) values ('Box 5');

insert into fruit (name, box_id) values ('pineapple', 2);