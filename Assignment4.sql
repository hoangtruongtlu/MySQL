USE classicmodels;

SELECT  * FROM Orders;
SELECT  * FROM customers;
SELECT * FROM OrderDetails;
SELECT * FROM Products;

-- Tổng giá trị các hóa đơn đã xuất kho trong tháng 8-2004
SELECT *
FROM Orders o
JOIN OrderDetails od ON o.orderNumber = od.orderNumber
WHERE o.`status`='Shipped' AND o.shippedDate BETWEEN '2004-08-01' AND '2004-08-31';

SELECT *
FROM Orders o
JOIN OrderDetails od ON o.orderNumber = od.orderNumber;


-- Lợi nhuận thu được từ mỗi khách hàng 
SELECT c.customerName, SUM(od.quantityOrdered*od.priceEach - p.buyPrice*od.quantityOrdered) Profit
FROM orderdetails od
JOIN orders o 		ON od.orderNumber = o.orderNumber
JOIN products p 	ON od.productCode = p.productCode
JOIN customers c 	ON o.customerNumber = c.CustomerNumber
GROUP BY c.CustomerName;

-- Doanh thu mà mỗi sản phẩm mang lại
SELECT p.productCode,p.productName, SUM(od.quantityOrdered*od.priceEach) Revenue
FROM products p
JOIN orderdetails od	ON p.productCode = od.productCode
GROUP BY p.productCode;