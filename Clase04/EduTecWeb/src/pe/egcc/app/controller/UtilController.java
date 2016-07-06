package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.egcc.app.dto.MensajeDto;

public class UtilController {

  public static void generaSalida
  (HttpServletResponse response, MensajeDto dto) 
  throws IOException {

    // Generando texto Gson
    Gson gson = new Gson();
    String textoJson = gson.toJson(dto);
    
    // response.setContentType("text/plain; charset=ISO-8859-2");
    response.setContentType("application/json; charset=ISO-8859-2");
    PrintWriter out = response.getWriter(); 
    out.print(textoJson); 
    out.close(); 
    
  }

}
