package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.EmpleadoDto;
import pe.edu.uni.mecafab.util.ValidarEmpleado;

public class EmpleadoRepository {
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
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
	
	// ============================
	// Consultar Empleado
	// ============================
	public List<EmpleadoDto> consultarEmpleado(EmpleadoDto dto) throws SQLException, Exception {
		
		try {

			List<EmpleadoDto> lista = new ArrayList<>();
			
			cn = AccesoDB.getConnection();
			
			String sql = """
                   SELECT * FROM Empleado em 
                   WHERE nombre COLLATE Latin1_General_CI_AI LIKE ? OR 
                   	  apellido COLLATE Latin1_General_CI_AI LIKE ? OR 
                   	  (SELECT descripcion FROM Rol rl WHERE rl.idRol = em.idRol) COLLATE Latin1_General_CI_AI LIKE ?
									""";
			ps = cn.prepareStatement(sql);
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getApellido());
			ps.setString(3, rol);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				EmpleadoDto empleado = new EmpleadoDto();
				empleado.setIdEmpleado(rs.getInt("idEmpleado"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellido(rs.getString("apellido"));
				empleado.setIdRol(rs.getInt("idRol"));
				lista.add(empleado);
			}
			
			return lista;
			
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
