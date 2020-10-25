<%@ include file="HomePage.jsp"%>
<h2 >Hello: <%= request.getParameter("username") %></h2>
<p>User Name: <b> <%= request.getParameter("username") %> </b></p>