package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;
import pe.edu.uni.mecafab.dto.EmpleadoDto;
import pe.edu.uni.mecafab.util.ValidarEmpleado;

public class EmpleadoRepository {
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// ========================================================
	// Registrar Empleado
	// ========================================================
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
	
	// ========================================================
	// Consultar Empleado (Utilizamos EmpleadoConsultaDto)
	// ========================================================
	public List<EmpleadoConsultaDto> consultarEmpleado(EmpleadoConsultaDto dto) throws SQLException, Exception {
		
		try {

			List<EmpleadoConsultaDto> lista = new ArrayList<>();
			
			cn = AccesoDB.getConnection();
			
			String sql = """
                   SELECT em.*, rl.descripcion FROM Empleado em 
                   JOIN Rol rl ON rl.idRol = em.idRol 
                   WHERE em.nombre COLLATE Latin1_General_CI_AI LIKE ? OR 
                   	    em.apellido COLLATE Latin1_General_CI_AI LIKE ? OR 
                   	    rl.descripcion COLLATE Latin1_General_CI_AI LIKE ?
									""";
			ps = cn.prepareStatement(sql);
			ps.setString(1, "%" + dto.getNombre() + "%");
			ps.setString(2, "%" + dto.getApellido() + "%");
			ps.setString(3, "%" + dto.getDescripcionRol()+ "%");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				EmpleadoConsultaDto empleado = new EmpleadoConsultaDto();
				empleado.setIdEmpleado(rs.getInt("idEmpleado"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellido(rs.getString("apellido"));
				empleado.setDescripcionRol(rs.getString("descripcion"));
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
