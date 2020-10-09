create database FinalExam;

use FinalExam;

create table manager(
	ManagerID TINYINT AUTO_INCREMENT,
	FullName VARCHAR(200) NOT NULL,
    Email VARCHAR(100) NOT NULL,
	Pass VARCHAR(100) NOT NULL,
    ExpInYear TINYINT,
    
    primary key(ManagerID)
);

create table employee(
	EmployeeID TINYINT AUTO_INCREMENT,
	FullName VARCHAR(200) NOT NULL,
    Email VARCHAR(100) NOT NULL,
	Pass VARCHAR(100) NOT NULL,
    ProjectID INT NOT NULL,
    ProSkill VARCHAR(100),
    
    primary key(EmployeeID)
);

create table project(
	 ProjectID TINYINT AUTO_INCREMENT,
     TeamSize INT NOT NULL,
     ManagerID TINYINT NOT NULL,
     EmployeeID TINYINT NOT NULL,
     
     PRIMARY KEY(ProjectID),
     UNIQUE KEY(ManagerID,EmployeeID)
);

insert into manager(FullName,Email,Pass,ExpInYear)
values
			('Hoang Van Truong','hoangtruong@gmail.com','Truong97',5);
insert into manager(FullName,Email,Pass,ExpInYear)
values
			('Hoang Van trung','hoangtrung@gmail.com','Truong97',5);
insert into employee(FullName,Email,Pass,ProjectID,ProSkill)
values
			('Hoang Van Truong','hoangtruong@gmail.com','Truong97',1,'Dev');
insert into project(TeamSize,ManagerID,EmployeeID)
values
			(50,1,1);
select * from project
		join manager on project.ManagerID = manager.ManagerID
		join employee on project.employeeID = employee.employeeID
	where projectID=1;