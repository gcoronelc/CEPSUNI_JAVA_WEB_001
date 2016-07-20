package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.egcc.app.domain.CursoProgramado;
import pe.egcc.app.dto.ComboDto;
import pe.egcc.app.dto.MensajeDto;
import pe.egcc.app.service.CombosService;
import pe.egcc.app.service.CursoService;

@WebServlet({"/ProgCursoLoad","/ProgCursoSave","/MatriculaLoad",
  "/GetCursosPorCiclo", "/GetAluNoMatriculados"})
public class CursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String path = request.getServletPath();
	  if(path.equals("/ProgCursoLoad")){
	    progCursoLoad(request,response);
	  } else if(path.equals("/ProgCursoSave")){
	    progCursoSave(request,response);
    } else if(path.equals("/MatriculaLoad")){
      matriculaLoad(request,response);
    } else if(path.equals("/GetCursosPorCiclo")){
      getCursosPorCiclo(request,response);
    } else if(path.equals("/GetAluNoMatriculados")){
      getAluNoMatriculados(request,response);
    }
	  
	  
	}


  private void getAluNoMatriculados(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<ComboDto> lstAlumnos = null;
    try {
      // Datos
      int idCursoProg = Integer.parseInt( request.getParameter("idcursoprog") );
      System.err.println("IdCursoProg: " + idCursoProg);
      // Proceso
      CombosService service = new CombosService();
      lstAlumnos = service.getAlumnosNoMatriculados(idCursoProg);
    } catch (Exception e) {
      lstAlumnos = new ArrayList<>();
    }
    
    Gson gson = new Gson();
    String textoJson = gson.toJson(lstAlumnos);
    
    System.err.println("TEXT: " + textoJson);
    UtilController.generaSalida(response, textoJson);
  }


  private void getCursosPorCiclo(HttpServletRequest request, 
      HttpServletResponse response) throws IOException {
    
    List<ComboDto> lstCursos = null;
    try {
      // Datos
      String ciclo = request.getParameter("ciclo");
      System.err.println("Ciclo: " + ciclo);
      // Proceso
      CombosService service = new CombosService();
      lstCursos = service.getCursos(ciclo);
    } catch (Exception e) {
      lstCursos = new ArrayList<>();
    }
    
    Gson gson = new Gson();
    String textoJson = gson.toJson(lstCursos);
    
    System.err.println("TEXT: " + textoJson);
    UtilController.generaSalida(response, textoJson);
    
  }


  private void matriculaLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
     CombosService service = new CombosService();
     List<ComboDto> lstCiclos = service.getCiclosProg();
     //List<ComboDto> lstEstudiantes = service.getEstudiantes();
     // Agregar en el request
     request.setAttribute("ciclos", lstCiclos);
     //request.setAttribute("estudiantes", lstEstudiantes);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procMatricula.jsp");
    rd.forward(request, response);
  }


  private void progCursoSave(HttpServletRequest request, 
      HttpServletResponse response) throws IOException {
    MensajeDto dto = new MensajeDto();
    try {
      // Datos
      CursoProgramado bean = new CursoProgramado();
      bean.setCiclo(request.getParameter("ciclo"));
      bean.setCurso(request.getParameter("curso"));
      bean.setHorario(request.getParameter("horario"));
      bean.setVacantes(Integer.parseInt(request.getParameter("vacantes")));
      // Proceso
      CursoService service = new CursoService();
      service.procProgCurso(bean);
      // Preparando la respuesta
      dto.setCode(1);
      dto.setText("Proceso ejecutado correctamente.");
    } catch (Exception e) {
      e.printStackTrace();
      dto.setCode(-1);
      dto.setText(e.getMessage());
    }
    UtilController.generaSalida(response, dto);
  }


  private void progCursoLoad(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
    try {
      // Datos
     CombosService service = new CombosService();
     List<ComboDto> lstCiclos = service.getCiclosProg();
     List<ComboDto> lstCursos = service.getCursos();
     // Agregar en el request
     request.setAttribute("ciclos", lstCiclos);
     request.setAttribute("cursos", lstCursos);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procProgCurso.jsp");
    rd.forward(request, response);
  }
	
	
	

}
