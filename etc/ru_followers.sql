
CREATE TABLE ru_followers
(
  username varchar( 128),
  follows  varchar(128 )
)


insert into ru_followers ( username, follows ) values ('qwer', 'keth')
insert into ru_followers ( username, follows ) values ('qwer', 'user01')
insert into ru_followers ( username, follows ) values ('qwer', 'user02')
insert into ru_followers ( username, follows ) values ('user2', 'keth')


select * from ru_followers
