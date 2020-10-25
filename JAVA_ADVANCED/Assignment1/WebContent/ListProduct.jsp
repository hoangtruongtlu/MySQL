<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%@ include file="HomePage.jsp"%>
		
		<h2>Product List</h2>
		<table>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<tr>
				<td>P001</td>
				<td>Java Core</td>
				<td>2000</td>
				<td><a href="">Edit</a></td>
				<td><a href="">Delete</a> </td>
			</tr>
			<tr>
				<td><%= request.getParameter("code") %></td>
				<td><%= request.getParameter("name") %></td>
				<td><%= request.getParameter("price") %></td>
				<td><a href="">Edit</a></td>
				<td><a href="">Delete</a></td>
			</tr>
		</table>
		<a href="CreateProduct.jsp">Create Product</a>
</body>
</html>