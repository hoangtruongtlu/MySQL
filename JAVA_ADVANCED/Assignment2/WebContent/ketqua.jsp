<%
	String so1 = request.getParameter("so1");
	String so2 = request.getParameter("so2");
	if (so1.trim().length()==0 || so2.trim().length()==0){
		response.sendRedirect("index.jsp");
	}
	else if(request.getParameter("cong") != null){
		out.print(so1 + " + " + so2 + " = " + (Integer.parseInt(so1) + Integer.parseInt(so2)));
	}
	else if (request.getParameter("tru") != null){
		out.print(so1 + " - " + so2 + " = " + (Integer.parseInt(so1) - Integer.parseInt(so2)));
	}
	else if (request.getParameter("nhan") != null){
		out.print(so1 + " * " + so2 + " = " + Integer.parseInt(so1) * Integer.parseInt(so2));
	}
	else if (request.getParameter("chia") != null){
		out.print(so1 + " / " + so2 + " = " + Integer.parseInt(so1) / Integer.parseInt(so2));
	}
%>