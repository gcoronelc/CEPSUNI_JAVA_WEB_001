package pe.egcc.app.prueba;

import pe.egcc.app.dto.VentaDto;
import pe.egcc.app.service.VentaService;

public class Prueba01 {

  public static void main(String[] args) {
    // Dato
    VentaDto dto = new VentaDto();
    dto.setPrecio(459.56);
    dto.setCant(5);
    // Proceso
    VentaService service = new VentaService();
    service.procesar(dto);
    // Reporte
    System.out.println("Importe: " + dto.getImporte());
    System.out.println("Impuesto: " + dto.getImpuesto());
    System.out.println("Total: " + dto.getTotal());
  }
}
