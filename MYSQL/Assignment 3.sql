-- Assignment 3:

CREATE DATABASE Testing;
USE Testing;

CREATE TABLE Department (
	DepartmentID TINYINT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName NVARCHAR(50) NOT NULL
);

CREATE TABLE `Position` (
	PositionID TINYINT AUTO_INCREMENT PRIMARY KEY,
    PositionName ENUM('Dev','Test','Scrum Master','PM') NOT NULL
);

CREATE TABLE `Account` (
	AccountID TINYINT AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) NOT NULL UNIQUE KEY,
    UserName VARCHAR(50) NOT NULL UNIQUE KEY,
    FUllName VARCHAR(50) NOT NULL,
    DepartmentID TINYINT NOT NULL,
    PositionID TINYINT NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Group` (
	GroupID TINYINT AUTO_INCREMENT PRIMARY KEY,
    GroupName NVARCHAR(20) NOT NULL UNIQUE KEY,
    CreatorID TINYINT NOT NULL,
    CreateDate DATETIME DEFAULT NOW()
);

CREATE TABLE GroupAccount(
	GroupID TINYINT NOT NULL,
    AccountID TINYINT NOT NULL,
    JoinDate DATETIME DEFAULT NOW(),
	PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE TypeQuestion(
	TypeID TINYINT AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Essay','Multiple-Choice') NOT NULL
);

CREATE TABLE CategoryQuestion(
	CategoryID TINYINT AUTO_INCREMENT PRIMARY KEY,
    CategoryName NVARCHAR(50) NOT NULL
);

CREATE TABLE Question(
	QuestionID TINYINT AUTO_INCREMENT PRIMARY KEY,
    Content NVARCHAR(100) NOT NULL,
    CategoryID TINYINT NOT NULL,
    TypeID TINYINT NOT NULL,
    CreatorID TINYINT NOT NULL,
    CreateDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Answer(
	AnswerID TINYINT AUTO_INCREMENT PRIMARY KEY,
    Content NVARCHAR(100) NOT NULL,
    QuestionID TINYINT NOT NULL,
    IsCorrect BOOL NOT NULL,
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Exam(
	ExamID TINYINT AUTO_INCREMENT PRIMARY KEY,
    `Code` VARCHAR(10) NOT NULL,
    Title NVARCHAR(50) NOT NULL,
    CategoryID TINYINT NOT NULL,
    Duration TINYINT NOT NULL,
    CreatorID TINYINT NOT NULL,
    CreateDate DATE NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ExamQuestion(
	ExamID TINYINT NOT NULL,
    QuestionID TINYINT NOT NULL,
    PRIMARY KEY(ExamID,QuestionID),
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID) ON DELETE CASCADE ON UPDATE CASCADE
   --  FOREIGN KEY(QuestionID) REFERENCES Question(QuestionsID) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS `Position`;
DROP TABLE IF EXISTS `Account`;
DROP TABLE IF EXISTS `Group`;
DROP TABLE IF EXISTS GroupAccount;
DROP TABLE IF EXISTS TypeQuestion;
DROP TABLE IF EXISTS CategoryQuestion;
DROP TABLE IF EXISTS Question;
DROP TABLE IF EXISTS Answer;
DROP TABLE IF EXISTS Exam;
DROP TABLE IF EXISTS ExamQuestion;

-- INSERT DATABASE

-- Add Data Department
INSERT INTO Department(DepartmentName)
VALUES		('Sale'),
			('Marketing'),
			('HR'),
			('Dev'),
			('Engineering'),
			('Purchasing');

-- Add Data Position
INSERT INTO `position`(PositionName) 
VALUES 		('Dev'),
			('Test'),
			('Scrum Master'),
			('PM');

-- Add Data Account
INSERT INTO account(Email,UserName,FUllName,DepartmentID,PositionID,CreateDate)
VALUES
			('truong@gmail.com','Truong','Hoang Van Truong',3,4,'2020/07/16'),
			('trung@gmail.com','Trung','Nguyen Van Trung',4,2,'2020/04/8'),
			('trang@gmail.com','Trang','Nguyen Thi Trang',1,4,'2020/06/24'),
			('nhung@gmail.com','Nhung','Tran Kieu Nhung',3,2,'2019/10/18'),
			('nhiem@gmail.com','Nhiem','Ta Tuong Nhiem',2,2,'2020/02/11'),
			('tu@gmail.com','Tu','Le Dang Tu',4,1,'2020/05/15'),
			('viet@gmail.com','Viet','Hoang Van Viet',3,4,'2020/07/16'),
			('kien@gmail.com','Kien','Nguyen Van Kien',2,2,'2020/04/8'),
			('Linh@gmail.com','Linh','Nguyen Thi Giang',2,2,'2019/10/18');
INSERT INTO account(Email,UserName,FUllName,DepartmentID,PositionID,CreateDate)
VALUES
			('Ngan@gmail.com','Ngan','Nguyen Thu Ngan',2,2,'2019/10/19');
-- Add Data Group
INSERT INTO `group`(GroupName,CreatorID,CreateDate)
VALUES
			('A',1,'2019/10/31'),
			('B',2,'2020/01/01'),
            ('O',3,'2020/03/10'),
			('C',4,'2020/02/14'),
            ('J',5,'2019/03/05'),
			('D',6,'2020/06/18'),
			('E',7,'2020/10/03'),
			('F',8,'2020/04/08'),
			('G',9,'2020/04/09'),
			('H',10,'2020/04/10');
            
-- Add Data GroupAccount
SELECT * FROM groupaccount;
INSERT INTO groupaccount(GroupID,AccountID,JoinDate) 
VALUES
							(1,1,'2020/02/14'),
							(1,4,'2020/01/01'),
							(2,5,'2020/10/03'),
							(1,2,'2019/10/31'),
							(4,6,'2020/05/15'),
							(1,5,'2020/04/06'),
							(1,7,'2020/04/07'),
							(8,3,'2020/04/08'),
							(1,9,'2020/04/09'),
							(10,10,'2020/04/10');
                            
-- Add Data TypeQuestion
INSERT INTO typequestion(TypeName) 
VALUES 			('Essay'),
				('Multiple-Choice');

-- Add Data CategoryQuestion
INSERT INTO categoryquestion(CategoryName) 
VALUES 			('JAVA'),
				('.NET'),
				('RUBY'),
				('C'),
				('PYHTON'),
				('GO'),
                ('PHP'),
                ('C#'),
                ('C++'),
                ('SQL');

-- Add Data Question
INSERT INTO question(Content,CategoryID,TypeID,CreatorID,CreateDate)
VALUES
	('RUBY',1,1,1,'2020/01/01'),
    ('JAVA',2,1,2,'2020/02/24'),
    ('SQL',3,2,3,'2020/05/05'),
    ('PHP',4,1,4,'2020/10/31'),
    ('GO',5,2,5,'2020/06/16'),
    ('C++',6,1,5,'2020/06/16'),
    ('RUBY',7,2,5,'2020/06/17'),
    ('PYTHON',8,2,5,'2020/06/17'),
    ('C',10,1,5,'2020/06/18'),
    ('JAVA',9,1,5,'2020/06/18');
    
-- Add Data Answer
INSERT INTO answer(Content,QuestionID,IsCorrect)
VALUES 				('Trả lời 01',   1	,	FALSE	),
					('Trả lời 02',   5	,	TRUE	),
                    ('Trả lời 03',   6	,	FALSE	),
                    ('Trả lời 04',   7	,	TRUE	),
                    ('Trả lời 05',   2	,	TRUE	),
                    ('Trả lời 06',   3	,	TRUE	),
                    ('Trả lời 07',   4	,	FALSE	),
                    ('Trả lời 08',   8	,	FALSE	),
                    ('Trả lời 09',   9	,	TRUE	),
                    ('Trả lời 10',   10	,	TRUE	);
-- Add Data Exam
INSERT INTO exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate)
VALUES				('VTIQ001'	, 'C#'		,	1	,	60		,   '5'		,'2019-04-05'),
					('VTIQ002'	, 'PHP'		,	10	,	60		,   '1'		,'2019-04-05'),
                    ('VTIQ003'	, 'C++'		,	9	,	120		,   '2'		,'2019-04-07'),
                    ('VTIQ004'	, 'JAVA'	,	6	,	60		,   '3'		,'2020-04-08'),
                    ('VTIQ005'	, 'RUBY'	,	5	,	120		,   '4'		,'2020-04-10'),
                    ('VTIQ006'	, 'PYTHON'	,	3	,	60		,   '6'		,'2020-04-05'),
                    ('VTIQ007'	, 'SQL'		,	2	,	60		,   '7'		,'2020-04-05'),
                    ('VTIQ008'	, 'C'		,	8	,	60		,   '8'		,'2020-04-07'),
                    ('VTIQ009'	, '.NET'	,	4	,	90		,   '9'		,'2020-04-07'),
                    ('VTIQ010'	, 'GO'		,	7	,	90		, 	'10' 	,'2020-04-08');

-- Add Data ExamQuestion
INSERT INTO examquestion(ExamID,QuestionID)
value					(	1	,	5	),
						(	2	,	10	), 
						(	3	,	4	), 
						(	4	,	3	), 
						(	5	,	7	), 
						(	6	,	10	), 
						(	7	,	2	), 
						(	8	,	10	), 
						(	9	,	9	), 
						(	10	,	8	); 

-- 	QUERY DATABASE

#Lay thong toan toan bo phong ban:
SELECT * FROM Department;
#Lay ID cua phong ban 'Sale':
SELECT DepartmentID FROM Department WHERE DepartmentName='Sale';
#Lay thong tin	account co full name dai nhat va sap xep theo thu tu giam dan
SELECT * FROM `account` WHERE length(FUllName) = (SELECT max(length(FUllName)) FROM Account) ORDER  BY FUllName DESC;
#Lay thong tin account co full name dai nhat va thuoc  phong ban co ID = 3:
SELECT * FROM `account` WHERE length(FUllName) = (SELECT max(length(FUllName)) FROM Account WHERE DepartmentID=3) AND DepartmentID=3;
#Lay ra ten Group da tham gia truoc ngay 20/12/2019:
SELECT GroupName,CreateDate FROM `group` WHERE CreateDate < '2019/12/20';
#Lay ra ID Question co >=4 cau tra loi:
SELECT QuestionID FROM Answer GROUP BY QuestionID HAVING count(QuestionID) >=4;
#Lay ra 5 Group duoc tao gan day nhat:
SELECT * FROM `group` ORDER BY CreateDate DESC LIMIT 5;
#Dem so nhan vien thuoc Department co id = 2:
SELECT DepartmentID,count(AccountID) FROM `Account` WHERE DepartmentID=2;
#Lay ra ten nhien vien bat dau bang chu 'D' va ket thuc bang chu 'o':
SELECT FUllName
FROM `Account`
WHERE FUllName LIKE 'D%o';
#Xoa tat ca Exam duoc tao truoc ngay 20/12/2019:
SELECT * FROM Exam;
DELETE
FROM Exam
WHERE CreateDate < '2019/12/20';

#Xoa tat ca noi dung bat dau bang tu "Câu hỏi":
select count(1) FROM Question
WHERE (SUBSTRING_INDEX(Content,' ',1)) = 'JAVA';

SELECT * FROM Question;
DELETE
FROM Question
WHERE (SUBSTRING_INDEX(Content,' ',2)) = 'Câu hỏi';

#Update thong tin cua account co ID =5 ....:
UPDATE `Account`
SET FUllName= "Nguyễn Bá Lộc", Email ='loc.nguyenba@vti.com.vn'
WHERE AccountID=5;
SELECT * FROM `Account`;
#Update Account co id =5 se thuoc Group co id =4:
UPDATE GroupAccount
SET	AccountID=5
WHERE GroupID=4;
SELECT * FROM GroupAccount
