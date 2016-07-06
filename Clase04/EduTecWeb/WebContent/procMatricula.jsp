<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROCESO MATRICULA</title>
</head>
<body>
  <h1>MATRICULA</h1>
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
            </select>
          </td>
      </tr>
      <tr>
          <td>Estudiante:</td>
          <td>
            <select id="estu" name="estu">
              <option value="0">Selecccionar ..</option>
            </select>
          </td>
      </tr>
    </table>
  </form>  
  
  <script type="text/javascript">
  
  $("#ciclo").change(function() {
	  var curso = $("#curso");
	  curso.empty();
	  var ciclo = $("#ciclo").val();
	  if (ciclo == '0') {
		  return;
	  }
	  var data = "ciclo=" + ciclo;
	  curso.append('<option value="">Cargando...</option>').val('');
	  $.post("GetCursosPorCiclo", data, function(arreglo) {
		  curso.empty();
			 if(arreglo.length > 0){
			   curso.append("<option value='0'>[Seleccione curso]</option>");
			 } else {
			   curso.append("<option value='0'>[No hay cursos]</option>");
			 }
			 for (var i = 0; i < arreglo.length; i++) {
			   var item = "<option value='" + arreglo[i].codigo + "'>" + arreglo[i].texto + "</option>";
			   curso.append(item);
			 }
	  });
	});
  
  </script>
  
</body>
</html>