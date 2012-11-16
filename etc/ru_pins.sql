select * from ru_pins
select * from ru_boards
insert into ru_pins (pinname, link, username) values ('bla', 'link', 'andri1')

drop table ru_pins

CREATE TABLE ru_pins 
(
  description varchar(1024),
  link varchar(512),
  image varchar(512),
  boardname varchar(128),
  username varchar(128)
)
