package pe.egcc.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Sumar", "/Restar", 
  "/Multiplicar", "/Dividir", "/Mayor" })
public class MateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Se recibe dos parámetros: n1 y n2
   */
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    if (path.equals("/Sumar")) {
      sumar(request, response);
    } else if (path.equals("/Restar")) {
      restar(request, response);
    } else if (path.equals("/Multiplicar")) {
      multiplicar(request, response);
    } else if (path.equals("/Dividir")) {
      dividir(request, response);
    } else if (path.equals("/Mayor")) {
      mayor(request, response);
    }
  }

  private void mayor(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    // Datos
    int num1 = Integer.parseInt(request.getParameter("n1"));
    int num2 = Integer.parseInt(request.getParameter("n2"));
    int num3 = Integer.parseInt(request.getParameter("n3"));
    // Proceso
    int lista[] = {num1,num2,num3};
    Arrays.sort(lista);
    int numMayor = lista[lista.length - 1];
    // Reporte
    request.setAttribute("n1", num1);
    request.setAttribute("n2", num2);
    request.setAttribute("n3", num3);
    request.setAttribute("mayor", numMayor);
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("mayor.jsp");
    rd.forward(request, response);
  }

  private void dividir(HttpServletRequest request, HttpServletResponse response) {

  }

  private void multiplicar(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    int num1 = Integer.parseInt(request.getParameter("n1"));
    int num2 = Integer.parseInt(request.getParameter("n2"));
    
    out.println("<p>Número 1: " + num1 + "</p>");
    out.println("<p>Número 2: " + num2 + "</p>");
        
    int rpta = num1 * num2;
    
    out.println("<p>Producto: " + rpta + "</p>");
    out.flush();
    
  }

  private void restar(HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub

  }

  private void sumar(HttpServletRequest request, 
      HttpServletResponse response) throws IOException {
    // Datos
    int num1 = Integer.parseInt(request.getParameter("n1"));
    int num2 = Integer.parseInt(request.getParameter("n2"));
    // Proceso
    int suma = num1 + num2;
    // Reporte
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<p>Número 1: " + num1 + "</p>");
    out.println("<p>Número 2: " + num2 + "</p>");
    out.println("<p>Suma: " + suma + "</p>");
    out.flush();
  }

}
