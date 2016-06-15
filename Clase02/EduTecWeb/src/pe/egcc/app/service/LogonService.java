package pe.egcc.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.domain.Empleado;

public class LogonService {

  
  public Empleado validar(String id, String clave){
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select IdEmpleado, Clave, ApeEmpleado, "
          + "NomEmpleado, Cargo, DirEmpleado, "
          + "TelEmpleado, EmailEmpleado "
          + "from empleado "
          + "where IdEmpleado = ? "
          + "and Clave = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, id);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = new Empleado();
        bean.setId(rs.getString("IdEmpleado"));
        bean.setApellido(rs.getString("ApeEmpleado"));
        bean.setNombre(rs.getString("NomEmpleado"));
        bean.setCargo(rs.getString("Cargo"));
        bean.setDireccion(rs.getString("DirEmpleado"));
        bean.setTelefono(rs.getString("TelEmpleado"));
        bean.setEmail(rs.getString("EmailEmpleado"));
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
    return bean;
  }
}
