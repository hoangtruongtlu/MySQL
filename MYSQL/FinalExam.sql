CREATE DATABASE Manage_Studen_Marks;
USE Manage_Studen_Marks;

DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
	RN 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` 		NVARCHAR(50) NOT NULL,
    Age			TINYINT NOT NULL,
    Gender		VARCHAR(10) NOT NULL
);

CREATE TABLE `Subject`
(
	sID 		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    sName		NVARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE StudentSubject
(
	RN			INT UNSIGNED NOT NULL,
    sID			INT UNSIGNED NOT NULL,
    Mark		TINYINT UNSIGNED NOT NULL,
    `Date`		DATE NOT NULL,
    PRIMARY KEY (RN,sID),
    FOREIGN KEY (RN) 		REFERENCES Student(RN) 					ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (sID) 		REFERENCES `Subject`(sID) 				ON DELETE CASCADE ON UPDATE CASCADE
);

-- Insert dữ liệu

INSERT INTO Student(`Name`,Age,Gender)
VALUES
		(N'Hoàng Văn Trường' 	,	'24'	,	'1'		),
        (N'Nguyễn Trung Hiếu'	,	'22'	,	'1'		),
        (N'Lê Trung Kiên'		,	'23'	,	'1'		),
        (N'Nguyễn Kim Chi'		,	'24'	,	'0'		),
		(N'Hoàng Văn Trung' 	,	'24'	,	'null'	);
SELECT * FROM Student;
INSERT INTO Subject(sName)
VALUES
		(N'Toán'		),
        (N'Ngữ văn'		),
        (N'Tiếng Anh'	),
        (N'Vật Lý'		),
        (N'Hóa học'		);
        
INSERT INTO StudentSubject(RN,sID,Mark,`Date`)
VALUES
		(	1	,	1	,	8	,	'2020/09/09'	),
        (	2	,	2	,	9	,	'2020/09/09'	),
        (	3	,	3	,	7	,	'2020/09/09'	),
        (	1	,	3	,	6	,	'2020/09/09'	),
        (	4	,	4	,	6	,	'2020/09/09'	),
        (	5	,	2	,	7	,	'2020/09/09'	);

-- Lấy tất cả môn học mà không có bất kì điểm nào
SELECT * FROM studentsubject;
SELECT S.*
FROM `Subject` S
LEFT JOIN StudentSubject SS ON S.sID = SS.sID
WHERE Mark IS NULL;
                    
-- Lấy danh sách môn học có ít nhất 2 diểm

SELECT	S.*
FROM `Subject` S
JOIN StudentSubject SS ON S.sID = SS.sID
GROUP BY SS.sID
HAVING Count(SS.sID) >=2;

-- Tạo View
CREATE VIEW StudentInfo 
AS
	SELECT SS.RN,SS.sID,Sd.`Name`,Sd.Age,Sb.sName,SS.Mark,SS.`Date`,CASE	WHEN Sd.Gender = '1' THEN 'FEMALE'
																					WHEN Sd.Gender = '0' THEN 'MALE'
																					ELSE 'UNKNOW'
																			END AS Gender
    FROM StudentSubject SS
    JOIN Student Sd ON SS.RN = Sd.RN
    JOIN `Subject` Sb ON SS.sID = Sb.sID;

-- Procedure xóa tất cả thông tin liên quan đến học sinh có cùng tên như parameter(name,mark) và tất cả điểm nhỏ hơn của học sinh đó
-- DROP PROCEDURE Delete_NameOrMark;
-- DELIMITER $$
-- CREATE PROCEDURE Delete_NameOrMark(IN In_Student_Name NVARCHAR(50), IN In_Mark INT)
-- BEGIN
-- 	IF In_Student_Name = '*'
--     THEN
-- 		DELETE FROM StudentSubject;
-- 	ELSE
-- 		DELETE FROM StudentSubject
--         WHERE 	(SELECT Student.`Name`  FROM Student
-- 				JOIN StudentSubject	ON 	Student.RN = StudentSubject.RN) = In_Student_Name
-- 				AND StudentSubject.Mark < In_Mark;
-- 	END IF;
-- END$$
-- DELIMITER ;

-- CALL Delete_NameOrMark('Nguyễn Trung Hiếu',10);

-- Trigger CasUpdate

DELIMITER $$
CREATE TRIGGER CasUpdate
BEFORE UPDATE ON StudentSubject
FOR EACH ROW
BEGIN
		UPDATE `Subject`
        SET `Subject`.sID = OLD.sID
        WHERE `Subject`.sID = NEW.sID;
        
END $$
DELIMITER ;

UPDATE `Subject`
SET sID = 6
WHERE sID = 2;
SELECT * FROM StudentSubject;

-- Trigger casDel

DELIMITER $$
CREATE TRIGGER CasDel
BEFORE DELETE ON StudentSubject
FOR EACH ROW
BEGIN
		DELETE 
        FROM Student
        WHERE Student.RN = OLD.RN;
END $$
DELIMITER ;

DELETE
FROM Student
WHERE RN = 1;

SELECT * FROM StudentSubject;

