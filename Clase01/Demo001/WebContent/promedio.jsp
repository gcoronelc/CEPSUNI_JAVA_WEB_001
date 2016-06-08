<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
// Variables
int n1 = 0, n2 = 0, n3 = 0, pr = 0;
if(request.getParameter("btnProcesar") != null){
	// Datos
	n1 = Integer.parseInt(request.getParameter("n1"));
	n2 = Integer.parseInt(request.getParameter("n2"));
	n3 = Integer.parseInt(request.getParameter("n3"));
	// Promedio
	pr = (n1 + n2 + n3) / 3;
}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CALCULO DE PROMEDIO</title>
</head>
<body>
  <h1>PROMEDIO DE 3 NUMEROS</h1>
  <form method="post" action="promedio.jsp">
    <p>Número 1: <input type="text" name="n1"/></p>
    <p>Número 2: <input type="text" name="n2"/></p>
    <p>Número 3: <input type="text" name="n3"/></p>
    <input type="submit" value="Procesar" name="btnProcesar"/>
  </form>
  
  <% if(request.getParameter("btnProcesar") != null){ %>
	  <h2>RESULTADO</h2>
	  <p>Número 1: <%=n1%></p>
	  <p>Número 2: <%=n2%></p>
	  <p>Número 3: <%=n3%></p>
	  <p>Promedio: <%=pr%></p>
  <% } %>
  
</body>
</html>