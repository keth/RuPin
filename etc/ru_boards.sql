
select * from ru_boards

insert into ru_boards (boardname, category, username) values ('boardname', 'tech', 'andri')

drop table ru_boards

CREATE TABLE ru_boards 
(
  boardname varchar(128),
  category varchar(128),
  username varchar(128),
  primary key (boardname, username)
)
