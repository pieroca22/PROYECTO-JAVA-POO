package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;
import pe.edu.uni.mecafab.dto.EmpleadoRegistroDto;
import pe.edu.uni.mecafab.dto.RolEmpleadoDto;
import pe.edu.uni.mecafab.util.JdbcUtil;
import pe.edu.uni.mecafab.util.TransCodeUtil;

public class EmpleadoRepository {
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// ========================================================
	// Registrar Empleado
	// ========================================================
	public int registrarEmpleado(EmpleadoRegistroDto dto) throws SQLException, Exception {
		
		int idEmpleado = -1;
		
		try {

			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			
			String sql = """
                   INSERT INTO Empleado 
									(nombre, apellido, idRol) 
                   VALUES (?, ?, ?)
									""";
			ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getApellido());
			ps.setInt(3, dto.getIdRol());
			
			int filas = ps.executeUpdate();
			System.out.println("Empleado registrado: " + filas + " fila(s) afectada(s)");
			
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				idEmpleado = rs.getInt(1);
			}
			// Generar el código del cliente: EM-0000001
			String codigo = TransCodeUtil.transCodeEmpleado(idEmpleado);
			// Actualizar el cliente con su código
      String update = "UPDATE Empleado SET codigoEmpleado = ? WHERE idEmpleado = ?";
      try (PreparedStatement ps2 = cn.prepareStatement(update)) {
				ps2.setString(1, codigo);
				ps2.setInt(2, idEmpleado);
				ps2.executeUpdate();
      }
			
			cn.commit();
			
		} catch (SQLException e) {
			JdbcUtil.rollback(cn);
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
		} catch(Exception e) {
			JdbcUtil.rollback(cn);
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			JdbcUtil.cerrar(cn, ps, rs);
		}
		
		return idEmpleado;
		
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
                   SELECT em.idEmpleado, em.codigoEmpleado, 
									CONCAT(em.nombre,' ',em.apellido) AS empleado, 
									em.idRol, rl.descripcion  
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
				empleado.setCodigoEmpleado(rs.getString("codigoEmpleado"));
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
			JdbcUtil.cerrar(cn, ps, rs);
		}

	}
	
	// ========================================================
	// OBTENER LOS ROLES DE LOS EMPLEADOS
	// ========================================================
	public List<RolEmpleadoDto> obtenerRoles() throws SQLException, Exception {
		
		List<RolEmpleadoDto> lista = new ArrayList<>();
		
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			cn = AccesoDB.getConnection();
			
			String sql = """
                   SELECT idRol, descripcion 
									FROM Rol
									 """;
			
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				RolEmpleadoDto dto = new RolEmpleadoDto(rs.getInt("idRol"), rs.getString("descripcion"));
				lista.add(dto);
			}
			
		} catch (SQLException e) {
			throw new SQLException("Error al conectar a la BD.");
		} catch (Exception e) {
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e) {
			}
		}
		
		return lista;
		
	}
	
}
