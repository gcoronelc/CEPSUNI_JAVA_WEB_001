<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<link rel="stylesheet" type="text/css" href="menu/menu.css">
<title>EDUTEC</title>
</head>
<body>

  <div id="EGCC_PAGINA">
  
    <div id="EGCC_CABECERA">
      <jsp:include page="cabecera.jsp"/>    
    </div>
    
    <div id="EGCC_MENU">
      <jsp:include page="menu/menu.jsp"/>    
    </div>
  
    <div id="EGCC_WORK">
	    <br/>
	    <br/>
	    <br/>
	    <br/>
	    <br/>    
    </div>
    
    <div id="EGCC_PIE" style="text-align: center; padding: 10px;">
      Derechos Reservados @ EGCC-2016<br/>
      www.desarrollasoftware.com    
    </div>
  
  
  </div>

  <script type="text/javascript" src="jquery/jquery.js"></script>
  <script type="text/javascript">
  
     function cargarPagina( pagina ){
    	 $("#EGCC_WORK").load(pagina);
     }
  
  
  </script>


</body>
</html>