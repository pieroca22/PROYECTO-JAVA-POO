package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.ClienteDto;
import pe.edu.uni.mecafab.util.ValidarCliente;

public class ClienteRepository {
	
	Connection cn = null;
	PreparedStatement ps = null;
	
	// ============================
	// Registrar Cliente
	// ============================
	public void registrarCliente(ClienteDto dto) throws SQLException, Exception {
		try {
			
			ValidarCliente.validarCliente(dto);
			
			cn = AccesoDB.getConnection();
			
			String sql = """
                   INSERT INTO Cliente 
									(nombre, apellido, telefono, email, direccion, fechaRegistro) 
                   VALUES (?, ?, ?, ?, ?, ?)
									""";
			ps = cn.prepareStatement(sql);
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getApellido());
			ps.setString(3, dto.getTelefono());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getDireccion());
			ps.setTimestamp(6, Timestamp.valueOf(dto.getFechaRegistro()));
			
			int filas = ps.executeUpdate();
			System.out.println("Cliente registrado: " + filas + " fila(s) afectada(s)");
			
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
