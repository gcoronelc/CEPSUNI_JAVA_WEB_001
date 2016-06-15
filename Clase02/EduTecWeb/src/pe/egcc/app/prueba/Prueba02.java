package pe.egcc.app.prueba;

import pe.egcc.app.domain.Empleado;
import pe.egcc.app.service.LogonService;

public class Prueba02 {

  public static void main(String[] args) {
    try {
      LogonService service = new LogonService();
      Empleado bean = service.validar("acampo", "acampo");
      if(bean == null){
        throw new RuntimeException("Datos incorrectos.");
      }
      System.out.println("Hola: " + bean.getNombre());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
