<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo</title>
</head>
<body>
	<%@ page errorPage="Error.jsp" %>
	<%@ include file="header.html" %>
	
	<p>Hello World!</p>
	<%
		out.print("Welcome!");
	%>
	<%="Welcome to Java"%>
	<div>
		<%=Calendar.getInstance().getTime()%>
	</div>
	<div>
		<%!int data = 50;%>
		<%="Data: " + data%>
	</div>

	<div>
		<%
			int a = 5;
			int b = 1;
			out.print(a / b);
		%>
	</div>
	<% String name = config.getInitParameter("fullname");
		out.print(name);	
		String age = application.getInitParameter("age");
		out.print(age);
	%>
</body>
</html>