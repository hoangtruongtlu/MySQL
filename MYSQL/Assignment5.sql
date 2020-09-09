USE Testing;

-- Tạo View có chứa danh sách nhân viên thuộc phòng ban 'SAle'
CREATE VIEW EmployeeSale
AS
	SELECT A.*,D.DepartmentName
    FROM `Account` A
    JOIN Department D ON A.DepartmentID = D.DepartmentID
    WHERE D.DepartmentName = 'Sale';

-- Tạo View có chứa thông tin các Account tham gia vào nhiều group nhất

CREATE VIEW AccMostGroup 
AS
SELECT A.*,COUNT(A.AccountID)
FROM `Account` A
JOIN GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY A.AccountID
HAVING COUNT(A.AccountID) = (SELECT MAX(B.count)
							FROM
								   (SELECT COUNT(A.AccountID) count
									FROM `Account` A
									JOIN GroupAccount GA ON A.AccountID = GA.AccountID
									GROUP BY A.AccountID) AS B);

-- CREATE VIEW AccMostGroup 
-- AS
-- 	SELECT A.*,COUNT(A.AccountID)
-- 	FROM `Account` A
-- 	JOIN GroupAccount GA ON A.AccountID = GA.AccountID
-- 	GROUP BY A.AccountID
-- 	HAVING COUNT(A.AccountID) = (SELECT COUNT(A.AccountID)
-- 								FROM `Account` A
-- 								JOIN GroupAccount GA ON A.AccountID = GA.AccountID
-- 								GROUP BY A.AccountID
-- 								ORDER BY COUNT(A.AccountID) DESC
-- 								LIMIT 1);

-- Tạo View có chứa câu hỏi có content dài hơn 300

CREATE VIEW ContentLonger300
AS
	SELECT QuestionID,Content,length(Content)
    FROM Question
    WHERE length(Content) > 5;
    
-- Tạo View có chứa danh sách các phòng ban có nhiều nhân viên nhất

CREATE VIEW Dep_Max_Acc
AS
	SELECT D.*,COUNT(A.DepartmentID)
    FROM Department D
    JOIN `Account` A ON A.DepartmentID = D.DepartmentID
    GROUP BY D.DepartmentID
    HAVING COUNT(A.DepartmentID) = (SELECT COUNT(A.DepartmentID)
									FROM Department D
									JOIN `Account` A ON A.DepartmentID = D.DepartmentID
									GROUP BY D.DepartmentID
                                    ORDER BY COUNT(A.DepartmentID) DESC
                                    LIMIT 1);

-- Tạo View  chưa tất cả câu hỏi do user họ Nguyễn tạo

CREATE VIEW QuesNguyen
AS
	SELECT Q.*,A.FUllName
    FROM Question Q
    JOIN `Account` A ON Q.CreatorID = A.AccountID
    WHERE A.FUllName LIKE 'Nguyễn%'
    


								
                                    
									