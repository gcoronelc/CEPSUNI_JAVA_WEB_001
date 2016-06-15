package pe.egcc.app.service;

import pe.egcc.app.dto.VentaDto;

public class VentaService {
  
  public void procesar(VentaDto dto){
    // Variables
    double importe, impuesto, total;
    // Proceso
    total = dto.getPrecio() * dto.getCant();
    total = truncar(total);
    importe = truncar(total / 1.18);
    impuesto = truncar(total - importe);
    // Salida
    dto.setImporte(importe);
    dto.setImpuesto(impuesto);
    dto.setTotal(total);
  }
  
  private double truncar(double valor){
    valor = valor * 100;
    valor = Math.round(valor);
    valor = valor / 100.0;
    return valor;
  }

}
