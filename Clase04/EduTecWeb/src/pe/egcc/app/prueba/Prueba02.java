package pe.egcc.app.prueba;

import pe.egcc.app.domain.Empleado;
import pe.egcc.app.service.ServiceLogeo;

public class Prueba02 {

  public static void main(String[] args) {
    try {
      ServiceLogeo service = new ServiceLogeo();
      Empleado bean = service.verificar("acampo", "acampo");
      if(bean == null){
        throw new RuntimeException("Datos incorrectos.");
      }
      System.out.println("Hola: " + bean.getNombre());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
