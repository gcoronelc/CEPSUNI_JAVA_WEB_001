<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROGRAMAR CURSO</title>
</head>
<body>
  <h1>PROGRAMAR CURSO</h1>
  <form id="form1">
    <table>
	    <tr>
          <td>Ciclo:</td>
          <td>
            <select id="ciclo" name="ciclo">
              <option value="0">Selecccionar ..</option>
              <c:forEach items="${ciclos}" var="r">
                <option value="${r.codigo}">${r.texto}</option>
              </c:forEach>
            </select>
          
          </td>
	    </tr>
      <tr>
          <td>Curso:</td>
          <td>
            <select id="curso" name="curso">
              <option value="0">Selecccionar ..</option>
              <c:forEach items="${cursos}" var="r">
                <option value="${r.codigo}">${r.texto}</option>
              </c:forEach>
            </select>
          
          </td>
      </tr>
      <tr>
          <td>Horario:</td>
          <td><input type="text" name="horario"/></td>
      </tr>
      <tr>
          <td>Vacantes:</td>
          <td><input type="text" name="vacantes"/></td>
      </tr>
    </table>
    <input type="button" id="btnProcesar" value="Programar" />
  </form>
  
  <script type="text/javascript">
  
    $("#btnProcesar").click(function(){
    	// Validar ciclo
    	var ciclo = $("#ciclo").val();
    	if(ciclo == 0){
    		alert("Seleccione un ciclo.");
    		return;
    	}
    	// Validar curso
      var ciclo = $("#curso").val();
      if(ciclo == 0){
        alert("Seleccione un curso.");
        return;
      }
      // Proceso
      var data = $("#form1").serialize();
      $.post("ProgCursoSave",data,function(texto){
    	  alert(texto);
      });
    });
  
  </script>
  
</body>
</html>