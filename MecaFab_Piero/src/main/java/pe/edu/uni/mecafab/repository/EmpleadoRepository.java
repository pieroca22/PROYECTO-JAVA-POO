package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.EmpleadoDto;
import pe.edu.uni.mecafab.util.ValidarEmpleado;

public class EmpleadoRepository {
	
	Connection cn = null;
	PreparedStatement ps = null;
	
	// ============================
	// Registrar Empleado
	// ============================
	public void registrarEmpleado(EmpleadoDto dto) throws SQLException, Exception {
		try {
			
			ValidarEmpleado.validarEmpleado(dto);
			
			cn = AccesoDB.getConnection();
			
			String sql = """
                   INSERT INTO Empleado 
									(nombre, apellido, idRol) 
                   VALUES (?, ?, ?)
									""";
			ps = cn.prepareStatement(sql);
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getApellido());
			ps.setInt(3, dto.getIdRol());
			
			int filas = ps.executeUpdate();
			System.out.println("Empleado registrado: " + filas + " fila(s) afectada(s)");
			
		} catch (SQLException e) {
			throw new SQLException("Error al conectar a la BD.");
		} catch(Exception e) {
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e) {
			}
		}
		
	}
	
}
