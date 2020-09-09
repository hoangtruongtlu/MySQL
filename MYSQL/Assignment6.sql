USE Testing;

-- Câu 1: Tạo Store để người dùng đăng nhập vào tên phòng ban và in ra tất cả account thuộc phòng ban đó
DELIMITER $$
CREATE PROCEDURE Acc_In_Dep (IN Import_Dep_Name VARCHAR(50))
BEGIN
		SELECT A.*
        FROM `Account` A
        JOIN Department D ON A.DepartmentID = D.DepartmentID
        WHERE Import_Dep_Name = DepartmentName;
END $$
DELIMITER ; 

CALL Acc_In_Dep('Sale');

-- Câu 2: Tạo Store để in ra số lượng account trong mỗi group

DELIMITER $$
CREATE PROCEDURE Acc_In_Gr()
BEGIN
		SELECT GroupID,COUNT(AccountID) 
        FROM GroupAccount
		GROUP BY GroupID;
END $$
DELIMITER ; 

CALL Acc_In_Gr();

-- Câu 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại 
 
DELIMITER $$
CREATE PROCEDURE TypeQues_Of_Moth()
BEGIN
	SELECT TypeID,COUNT(QuestionID)
    FROM Question
	WHERE MONTH(CreateDate) = MONTH(NOW())
    GROUP BY TypeID;
END $$
DELIMITER ; 

CALL TypeQues_Of_Moth();

-- Câu 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DELIMITER $$
CREATE PROCEDURE Type_Max_Ques()
BEGIN
		SELECT TypeID
        FROM Question
        GROUP BY TypeID
        HAVING COUNT(QuestionID) = (SELECT  COUNT(QuestionID)
									FROM Question
									GROUP BY TypeID
									ORDER BY COUNT(QuestionID) DESC
									LIMIT 1);
END $$
DELIMITER ;

CALL Type_Max_Ques();

-- Câu 5: Sử dụng store ở question 4 để tìm ra tên của type question 
				
DELIMITER $$
CREATE PROCEDURE Find_Name_Of_TypeQues()
BEGIN
		SELECT TypeName
        FROM Question Q
        JOIN TypeQuestion TQ ON Q.TypeID = TQ.TypeID
        GROUP BY Q.TypeID
        HAVING COUNT(QuestionID) = (SELECT  COUNT(QuestionID)
									FROM Question
									GROUP BY TypeID
									ORDER BY COUNT(QuestionID) DESC
									LIMIT 1);
END $$
DELIMITER ;

CALL Find_Name_Of_TypeQues();

-- Câu 6 : Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào
-- hoặc  trả về user có username chứa chuỗi của người dùng nhập vào 
 
 DELIMITER $$
 CREATE PROCEDURE Name_GrOrUser(IN StringInput VARCHAR(50), IN In_Select INT)
 BEGIN
		IF In_Select = 1 THEN
			SELECT *
			FROM `Group`
			WHERE GroupName LIKE CONCAT('%',StringInput,'%'); -- CONCAT() Hàm cộng chuỗi
        ELSE
			SELECT AccountID,UserName,FullName
            FROM `Account`
            WHERE UserName LIKE CONCAT('%',StringInput,'%');
		END IF;
END $$
DELIMITER ;

CALL Name_GrOrUser('Tru',2);
SELECT * FROM `Account`;
SELECT * FROM `Group`;

-- Câu 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán 
-- username sẽ giống email nhưng bỏ phần @..mail đi 
-- positionID: sẽ có default là developer 
-- departmentID: sẽ được cho vào 1 phòng chờ 
-- Sau đó in ra kết quả tạo thành công 

DELIMITER $$
CREATE PROCEDURE Insert_Account(IN	Import_Email VARCHAR(50), IN Import_FullName NVARCHAR(50))						
BEGIN
	DECLARE Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(Import_email,'@',1);
    DECLARE PositionID TINYINT DEFAULT 1;
    DECLARE DepartmentID TINYINT DEFAULT 10;
    DECLARE CreateDate DATETIME DEFAULT NOW();
    
	INSERT INTO `Account` 	(Email,Username,FullName,DepartmentID,PositionID,CreateDate)
    VALUE					(Import_Email,Username,Import_FullName,DepartmentID,PositionID,CreateDate);
	
    SELECT 	*
    FROM 	`Account`A;
	
END$$
DELIMITER ;

CALL Insert_Account('Truong21097@gmail.com','Hoàng Văn Trường')

-- Câu 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice 
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất 

DELIMITER $$
CREATE PROCEDURE Max_Content_TypeID(IN Select_TypeName VARCHAR(20))
BEGIN
		IF (Select_TypeName ='Essay') THEN
			SELECT Content,MAX(LENGTH(Content))
			FROM Question
			WHERE TypeID = (SELECT TypeID
							FROM TypeQuestion
							WHERE TypeName = Select_TypeName);
        ELSEIF (Select_TypeName = 'Multiple-Choice') THEN
			SELECT Content,MAX(LENGTH(Content))
			FROM Question
            WHERE TypeID = (SELECT TypeID
							FROM TypeQuestion
							WHERE TypeName = Select_TypeName);
		END IF;
END$$
DELIMITER ;

CALL Max_Content_TypeID('Multiple-Choice')

-- Câu 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID 

DELIMITER $$
CREATE PROCEDURE Delete_Exam (IN in_ExamID TINYINT)
BEGIN
	DELETE 	
    FROM 	Exam 
    WHERE	ExamID = in_ExamID;	
END$$
DELIMITER ;

CALL Delete_Exam(4);
SELECT * FROM Exam;

-- Câu 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi, sau đó in số lượng record đã remove từ các table liên quan trong khi removing 
DROP PROCEDURE IF EXISTS Exam_Last_3year1;
DELIMITER $$
CREATE PROCEDURE Exam_Last_3year1()
BEGIN
	SELECT ExamID
	FROM Exam
	WHERE YEAR(NOW())-YEAR(CreateDate)=1;
    DELETE
    FROM Exam
    WHERE ExamID IN (SELECT B.ExamID
					FROM(
									SELECT ExamID
									FROM Exam
									WHERE YEAR(NOW())-YEAR(CreateDate)=1) AS B);
	SELECT ROW_COUNT(); -- Lấy ra số dòng đã được truy vấn(DELETE,INSERT,UPDATE) trước đó
END$$
DELIMITER ;

CALL Exam_Last_3year1();

-- DELIMITER $$
-- CREATE PROCEDURE Exam_Last_3year()
-- BEGIN
-- 	WITH ExamIdLast3Y AS(
-- 		SELECT ExamID
-- 		FROM Exam
-- 		WHERE YEAR(NOW())-YEAR(CreateDate)=1)
--     DELETE
--     FROM Exam
--     WHERE ExamID IN (SELECT * FROM ExamIdLast3Y);
-- END$$
-- DELIMITER ;

-- CALL Exam_Last_3year();
-- Câu 11:  Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào 
-- tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc 

DELIMITER $$
CREATE PROCEDURE Delete_Department(IN In_DepName VARCHAR(50))
BEGIN
		UPDATE `Account`
        SET DepartmentID = 10
        WHERE DepartmentID = (SELECT DepartmentID
								FROM Department
                                WHERE DepartmentName = In_DepName);
		DELETE
        FROM Department
        WHERE DepartmentName = In_DepName;
END$$
DELIMITER ;

CALL Delete_Department('Sale');

-- Câu 12: Viết Store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE  Count_Ques_In_Month;
DELIMITER $$
CREATE PROCEDURE Count_Ques_In_Month()
BEGIN
		SELECT MIY.`Month`, COUNT(QuestionID) Count
		FROM
		(
             SELECT 1 `Month`
             UNION SELECT 2
             UNION SELECT 3
             UNION SELECT 4
             UNION SELECT 5
             UNION SELECT 6
             UNION SELECT 7
             UNION SELECT 8
             UNION SELECT 9
             UNION SELECT 10
             UNION SELECT 11
             UNION SELECT 12
        ) AS MIY
		LEFT JOIN Question ON MIY.`Month` = MONTH(CreateDate)
        WHERE YEAR(CreateDate) = YEAR(NOW())
		GROUP BY MIY.`Month`
		ORDER BY MIY.`Month` ASC;
END$$
DELIMITER ;

CALL Count_Ques_In_Month();

-- Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất

DROP PROCEDURE Count_Ques_Last_6month;
DELIMITER $$
CREATE PROCEDURE Count_Ques_Last_6month()
BEGIN
		SELECT Recent6Month.`Month`,IF(Count(QuestionID)>0,Count(QuestionID),'NO DATA') Count
        FROM (
				SELECT MONTH(DATE_SUB(CURRENT_DATE(),INTERVAL 0 MONTH)) `Month`
                UNION
                SELECT MONTH(DATE_SUB(CURRENT_DATE(),INTERVAL 1 MONTH)) 
                UNION
                SELECT MONTH(DATE_SUB(CURRENT_DATE(),INTERVAL 2 MONTH)) 
                UNION
                SELECT MONTH(DATE_SUB(CURRENT_DATE(),INTERVAL 3 MONTH)) 
                UNION
                SELECT MONTH(DATE_SUB(CURRENT_DATE(),INTERVAL 4 MONTH)) 
                UNION
                SELECT MONTH(DATE_SUB(CURRENT_DATE(),INTERVAL 5 MONTH)) 
			) AS Recent6Month
            LEFT JOIN Question ON Recent6Month.`Month` = Month(CreateDate)
            GROUP BY Recent6Month.`Month`
            ORDER BY Recent6Month.`Month`;
END$$
DELIMITER ;

CALL Count_Ques_Last_6month();

SELECT 1 Month
UNION SELECT 2;