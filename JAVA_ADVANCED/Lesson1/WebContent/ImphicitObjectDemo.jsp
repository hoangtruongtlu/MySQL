<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RequestPage.jsp"> 
		<input type="text" name="fullname"> <input type="submit" value="send"> 
	</form>
	
	<% String name = config.getInitParameter("fullname");
		out.print(name);	
		String age = application.getInitParameter("age");
		out.print(age);
	%>
	
</body>
</html>