<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%	
			response.setHeader("Cache-Control","no-cache, no-store, max-age = 0, must-revalidate");
			response.addHeader("Cache-Control","post-check=0, pre-check=0");
			response.setHeader("Pragma","no-cache");
			response.setHeader("Expires", "0"); // Proxies.
			response.setDateHeader("Expires", 0);

           	request.removeAttribute("msg");
            session.setAttribute("user", null);
            session.removeAttribute("user");
            
            session.invalidate();
            
            response.sendRedirect("login.jsp");
            
            %>
</body>
</html>