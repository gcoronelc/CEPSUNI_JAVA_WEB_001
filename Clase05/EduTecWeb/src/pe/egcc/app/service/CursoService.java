package pe.egcc.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.domain.CursoProgramado;

public class CursoService {

  public void procProgCurso(CursoProgramado bean){
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Inicio de Tx
      cn.setAutoCommit(false);
      // Verificar ciclo
      String sql = "select count(1) cont "
          + "from ciclo "
          + "where IdCiclo = ? "
          + "and (FecInicio > getdate()) "
          + "or (year(FecInicio) = year(getdate()) "
          + "and month(FecInicio) = month(getdate()))";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getCiclo());
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int cont = rs.getInt("cont");
      rs.close();
      pstm.close();
      if(cont == 0){
        throw new Exception("El ciclo no existe o es pasado.");
      }
      // Verificar curso
      sql = "select count(1) cont "
          + "from curso "
          + "where IdCurso = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getCurso());
      rs = pstm.executeQuery();
      rs.next();
      cont = rs.getInt("cont");
      rs.close();
      pstm.close();
      if(cont == 0){
        throw new Exception("El curso no existe.");
      }
      // Leer tarifa
      sql = "select t.PrecioVenta tarifa "
          + "from curso c "
          + "join tarifa t on c.IdTarifa = t.IdTarifa "
          + "where c.IdCurso = ?";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getCurso());
      rs = pstm.executeQuery();
      rs.next();
      double tarifa = rs.getDouble("tarifa");
      rs.close();
      pstm.close();
      // insertar curso programado
      sql = "insert into CursoProgramado(IdCurso,"
          + "IdCiclo,Vacantes,Matriculados,"
          + "PreCursoProg,Horario,Activo) "
          + "values(?,?,?,0,?,?,1)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getCurso());
      pstm.setString(2, bean.getCiclo());
      pstm.setInt(3, bean.getVacantes());
      pstm.setDouble(4, tarifa);
      pstm.setString(5, bean.getHorario());
      pstm.executeUpdate();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e2) {
      }
      String texto = "Error en el proceso. ";
      if(e != null && !e.getMessage().isEmpty()){
        texto += "<br/>" + e.getMessage();
      }
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
  
  
}
