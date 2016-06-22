package pe.egcc.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.domain.Empleado;
import pe.egcc.app.dto.ComboDto;

public class CombosService {

  public List<ComboDto> getCiclosProg(){
    List<ComboDto> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select idciclo from ciclo where FecInicio >= getdate() "
          + "union  "
          + "select idciclo from ciclo "
          + "where year(FecInicio) = year(getdate()) "
          + "and month(FecInicio) = month(getdate()) ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        ComboDto dto = new ComboDto();
        dto.setCodigo(rs.getString("idciclo"));
        dto.setTexto(rs.getString("idciclo"));
        lista.add(dto);        
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }
    return lista;
  }
  
  public List<ComboDto> getCursos(){
    List<ComboDto> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select IdCurso, NomCurso from curso ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        ComboDto dto = new ComboDto();
        dto.setCodigo(rs.getString("IdCurso"));
        dto.setTexto(rs.getString("NomCurso"));
        lista.add(dto);        
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }
    return lista;
  }
  
  
}
