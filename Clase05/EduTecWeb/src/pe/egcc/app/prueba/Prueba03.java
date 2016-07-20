package pe.egcc.app.prueba;

import java.util.List;

import pe.egcc.app.dto.ComboDto;
import pe.egcc.app.service.CombosService;

public class Prueba03 {

  public static void main(String[] args) {
    try {
      CombosService service = new CombosService();
      List<ComboDto> lista = service.getAlumnosNoMatriculados(7777);
      for(ComboDto dto: lista){
        System.out.println(dto.getTexto());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
