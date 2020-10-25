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

	<form action="Login" method="post">
		<h1>Login Page</h1>
		User Name <input  type="text" name="username"></input> <br>
		Password <input  type="password" name="password"></input> <br>
		Remember <input type="checkbox" name="choose"> <br>
		<input type="submit" value="Submit"></input>
		<a href="Login.jsp">Cancel</a>
	</form>
</body>
</html>