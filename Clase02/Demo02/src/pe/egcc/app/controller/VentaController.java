package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.dto.VentaDto;
import pe.egcc.app.service.VentaService;

@WebServlet({ "/CalcularVenta", "/hhhhh", "/oooo" })
public class VentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/CalcularVenta")){
		  calcularVenta(request,response);
		}
	}

  private void calcularVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Datos
    VentaDto dto = new VentaDto();
    dto.setPrecio(Double.parseDouble(request.getParameter("precio")));
    dto.setCant(Integer.parseInt(request.getParameter("cant")));
    // Proceso
    VentaService service = new VentaService();
    service.procesar(dto);
    // Forward
    request.setAttribute("dto", dto);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  }

}
