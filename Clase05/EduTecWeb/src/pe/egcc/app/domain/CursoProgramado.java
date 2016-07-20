package pe.egcc.app.domain;

public class CursoProgramado {

  private int id;
  private String curso;
  private String ciclo;
  private String profesor;
  private int vacantes;
  private int matriculados;
  private double precio;
  private String horario;
  private int activo;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getCiclo() {
    return ciclo;
  }

  public void setCiclo(String ciclo) {
    this.ciclo = ciclo;
  }

  public String getProfesor() {
    return profesor;
  }

  public void setProfesor(String profesor) {
    this.profesor = profesor;
  }

  public int getVacantes() {
    return vacantes;
  }

  public void setVacantes(int vacantes) {
    this.vacantes = vacantes;
  }

  public int getMatriculados() {
    return matriculados;
  }

  public void setMatriculados(int matriculados) {
    this.matriculados = matriculados;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public String getHorario() {
    return horario;
  }

  public void setHorario(String horario) {
    this.horario = horario;
  }

  public int getActivo() {
    return activo;
  }

  public void setActivo(int activo) {
    this.activo = activo;
  }

}
