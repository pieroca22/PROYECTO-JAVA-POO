package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;
import pe.edu.uni.mecafab.dto.EmpleadoRegistroDto;
import pe.edu.uni.mecafab.util.StringUtil;
import pe.edu.uni.mecafab.util.ValidarEmpleadoUtil;

public class EmpleadoRepository {
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// ========================================================
	// Registrar Empleado
	// ========================================================
	public void registrarEmpleado(EmpleadoRegistroDto dto) throws SQLException, Exception {
		try {
			
			// Limpiar y capitalizar el dto primero
			dto.setNombre(StringUtil.limCap(dto.getNombre()));
			dto.setApellido(StringUtil.limCap(dto.getApellido()));
			
			ValidarEmpleadoUtil.validarDatos(dto);
			
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
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
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
	public List<EmpleadoConsultaDto> consultarEmpleado(String patron) throws SQLException, Exception {
		
		try {

			List<EmpleadoConsultaDto> lista = new ArrayList<>();
			
			cn = AccesoDB.getConnection();
			
			// EN MEJORA, HACERLO ESTILO WHATSAPP LA BUSQUEDA
			String sql = """
                   SELECT em.idEmpleado, CONCAT(em.nombre,' ',em.apellido) AS empleado, 
									em.idRol, 
									rl.descripcion 
									FROM Empleado em 
                   JOIN Rol rl ON rl.idRol = em.idRol 
                   WHERE em.nombre COLLATE Latin1_General_CI_AI LIKE ? OR 
                   	    em.apellido COLLATE Latin1_General_CI_AI LIKE ? OR 
                   	    rl.descripcion COLLATE Latin1_General_CI_AI LIKE ?
									""";
			ps = cn.prepareStatement(sql);
			ps.setString(1, "%" + patron + "%");
			ps.setString(2, "%" + patron + "%");
			ps.setString(3, "%" + patron + "%");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				EmpleadoConsultaDto empleado = new EmpleadoConsultaDto();
				empleado.setIdEmpleado(rs.getInt("idEmpleado"));
				empleado.setEmpleado(rs.getString("empleado"));
				empleado.setIdRol(rs.getInt("idRol"));
				empleado.setDescripcionRol(rs.getString("descripcion"));
				lista.add(empleado);
			}
			
			return lista;
			
		} catch (SQLException e) {
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
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
