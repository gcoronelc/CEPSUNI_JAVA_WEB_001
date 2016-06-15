<%@page import="pe.egcc.app.dto.VentaDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  VentaDto dto = null;
  if( request.getAttribute("dto") != null){  
    dto = (VentaDto) request.getAttribute("dto");
  }
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>CALCULO DE VENTA</h1>
  <form method="post" action="CalcularVenta">
    <p>Precio: <input type="text" name="precio"/></p>
    <p>Cantidad: <input type="text" name="cant"/></p>
    <p><input type="submit" name="btnProcesar"
              value="Procesar"/></p>
  </form>
  
  <% if( request.getAttribute("dto") != null ){ %>
  <h2>RESULTADO</h2>
  <p>Importe: <%= dto.getImporte() %> </p>
  <p>Impuesto: <%= dto.getImpuesto() %> </p>
  <p>Total: <%= dto.getTotal() %> </p>
  <% } %>
</body>
</html>