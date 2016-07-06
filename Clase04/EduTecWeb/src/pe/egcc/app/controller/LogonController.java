package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.app.domain.Empleado;
import pe.egcc.app.service.ServiceLogeo;

@WebServlet({ "/LogonIngresar", "/LogonSalir" })
public class LogonController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = request.getServletPath();
    if (path.equals("/LogonIngresar")) {
      logonIngresar(request, response);
    } else if (path.equals("/LogonSalir")) {
      logonSalir(request, response);
    }
  }

  private void logonIngresar(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String destino;
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      ServiceLogeo service = new ServiceLogeo();
      Empleado bean = service.verificar(usuario, clave);
      if (bean == null) {
        throw new Exception("Datos incorrectos.");
      }
      // Guardar bean en session
      HttpSession session = request.getSession();
      session.setAttribute("usuario", bean);
      // Destino
      destino = "main.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

  private void logonSalir(HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub

  }

}
