<%
	String name = request.getParameter("fullname");
	out.print(name);
	session.setAttribute("name", name);
	session.removeAttribute("name");
	response.sendRedirect("ResponePage.jsp");
%>