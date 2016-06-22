package pe.egcc.app.dto;

public class ComboDto {

  private String codigo;
  private String texto;
  private int activo; // 1: Activo

  public ComboDto() {
  }

  public ComboDto(String codigo, String texto, int activo) {
    super();
    this.codigo = codigo;
    this.texto = texto;
    this.activo = activo;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public int getActivo() {
    return activo;
  }

  public void setActivo(int activo) {
    this.activo = activo;
  }

}
