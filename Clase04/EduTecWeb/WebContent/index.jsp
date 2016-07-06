<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INICIO DE SESIÓN</title>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<style type="text/css">

  #LOGON{
    width: 300px;
    margin: 10px auto;
    padding: 10px;
    background-color: white;
  }

</style>
</head>
<body>
  <div id="LOGON">
    <div style="width: 100%;">
      <img alt="" src="img/logo.jpg">
    </div>
    
    <h1>INICIO DE SESIÓN</h1>
    
    <c:if test="${requestScope.error != null}">
      <div class="msgError">${requestScope.error}</div>
    </c:if>
    
    <div style="width: 100%;">
      <form method="post" action="LogonIngresar">
	       <table>
	         <tr>
		          <td>Usuario:</td>
		          <td><input type="text" name="usuario" /></td>
	         </tr>      
	         <tr>
		          <td>Clave:</td>
		          <td><input type="password" name="clave" /></td>
	         </tr>
	        </tr>      
	       </table>
	       <input type="submit" value="Ingresar" />
      </form>
    </div>
    
    
  </div>
</body>
</html>