<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>MAYOR DE 3 NUMEROS</h1>
  <form method="post" action="Mayor">
    <p>Número 1: <input type="text" name="n1"/></p>
    <p>Número 2: <input type="text" name="n2"/></p>
    <p>Número 3: <input type="text" name="n3"/></p>
    <input type="submit" value="Procesar" name="btnProcesar"/>
  </form>
  
  <% if( request.getAttribute("mayor") != null) { %>
	  <p>Número 1: <%= request.getAttribute("n1") %></p>
	  <p>Número 2: <%= request.getAttribute("n2") %></p>
	  <p>Número 3: <%= request.getAttribute("n3") %></p>
	  <p>Mayor: <%= request.getAttribute("mayor") %></p>
  <% } %>  
  
</body>
</html>