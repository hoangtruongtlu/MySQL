use testing;

-- create table truong(
-- 	age int
-- );

-- select * from truong;

delete from `position` where positionID = 5;
select * from `position`;
truncate table `position` ;
set foreign_key_checks=0;
alter table `position` MODIFY positionName varchar(20);