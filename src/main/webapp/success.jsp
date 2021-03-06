<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
<title>Success</title>
</head>
<body>
	<%
		//allow access only if session exists
		String user = (String) session.getAttribute("user");
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		}
	%>
	
	<h3>Hi <%= userName %>, Login successful. Your Session ID: <%=sessionID %></h3>

	<h3>User session attribute: <%=user %></h3>
	
	<a href="checkout.jsp">Checkout Page</a>
		<form action="LogoutServlet" method="post">
			<input type="submit" value="Logout" >
		</form>
	
</body>
</html>