create database SENG2050_c3269995;

use SENG2050_c3269995;
-- drop table game_info;
-- drop table minesweeper_info;
-- drop table user_info;
-- MYSQL
-- create user 'Assign2Login'@'localhost' identified by 'c3269995';
-- grant all privileges on SENG2050_c3269995 to 'Assign2Login'@'localhost';

-- MSSQL
-- create login Assign2Login with password = 'c3269995';
-- create user Assign2Login for login Assign2Login;
-- grant select, insert, update, delete to Assign2Login;

create table user_info (

	userID INT primary key not null AUTO_INCREMENT,
    userName varchar(40) not null,
    password varchar(40) not null

);

create table minesweeper_info (

	mineID INT primary key not null AUTO_INCREMENT,
    userID INT not null,
    gameMode varchar(40) not null,
    gridSize int not null,
    
    FOREIGN KEY (userID) REFERENCES user_info(userID) ON DELETE CASCADE

);

create table game_info (

	gameID INT primary key not null AUTO_INCREMENT,
    mineID INT not null,
    rowNum int not null,
    cellNum int not null,
    cellType varchar(40) not null,
    
    FOREIGN KEY (mineID) REFERENCES minesweeper_info(mineID) ON DELETE CASCADE

)

insert into user_info(userName, password) values ('admin', 'admin');
insert into user_info(userName, password) values ('tim', 'tim');
insert into user_info(userName, password) values ('sean', 'sean');

-- TEST Queries

-- select * from user_info left join minesweeper_info on user_info.userID = minesweeper_info.userID;
-- select userID from user_info where userName = 'admin';
select * from minesweeper_info;
select * from user_info;
select * from game_info;
-- select rowNum,count(distinct rowNum) from game_info order by rowNum;

-- INSERT into game_info(gameID, mineID, rowNum, cellNum, cellType) values (1, 1, 1, 1, 'Insert2') on duplicate key update  cellType = values('Update2') ;
-- delete from game_info where mineID = 3 and (select count(mineID) from game_info) > 2;

-- INSERT into game_info(gameID, mineID, rowNum, cellNum, cellType) values (1, 1, 1, 1, 'Insert2'

-- UPDATE game_info SET cellType = 'bomb' where mineID = 1 IF @@rowcount = 0
-- UPDATE game_info SET cellType = 'test' where mineID = 1;

-- update minesweeper_info SET gridSize = 20, gameMode = 'Advanced' where mineID = 1;

