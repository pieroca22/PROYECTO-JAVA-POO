package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.ClienteConsultaDto;
import pe.edu.uni.mecafab.dto.ClienteRegistroDto;
import pe.edu.uni.mecafab.util.JdbcUtil;

public class ClienteRepository {

	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// ============================
	// Registrar Cliente
	// ============================
	public int registrarCliente(ClienteRegistroDto dto) throws SQLException, Exception {
		
		int idCliente = -1;
		
		try {

			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);

			String sql = """
                   INSERT INTO Cliente 
									(nombre, apellido, telefono, email, direccion, fechaRegistro) 
                   VALUES (?, ?, ?, ?, ?, ?)
									""";
			ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getApellido());
			ps.setString(3, dto.getTelefono());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getDireccion());
			ps.setTimestamp(6, Timestamp.valueOf(dto.getFechaRegistro()));

			int filas = ps.executeUpdate();
			System.out.println("Cliente registrado: " + filas + " fila(s) afectada(s)");
			
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				idCliente = rs.getInt(1);
			}
			
			cn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(cn);
			throw new SQLException("Error al conectar a la BD." + e);
		} catch (Exception e) {
			JdbcUtil.rollback(cn);
			throw new Exception("Error inesperado: " + e);
		} finally {
			JdbcUtil.cerrar(cn, ps, rs);
		}
		
		return idCliente;
		
	}

	// ============================
	// Consultar Cliente
	// ============================
	public List<ClienteConsultaDto> consultarCliente(String patron) throws SQLException, Exception {
		
		List<ClienteConsultaDto> lista = new ArrayList<>();
		
		try {
			
			cn = AccesoDB.getConnection();
			
			// EN MEJORA, HACERLO ESTILO WHATSAPP LA BUSQUEDA
			String sql = """
                   SELECT 
									idCliente, CONCAT(nombre,' ',apellido) AS cliente, apellido,
                   telefono, email, direccion, fechaRegistro 
									FROM Cliente 
                   WHERE nombre COLLATE Latin1_General_CI_AI LIKE ? OR 
                         apellido COLLATE Latin1_General_CI_AI LIKE ? OR 
                         telefono LIKE ? OR 
                         email LIKE ? OR 
                         direccion COLLATE Latin1_General_CI_AI LIKE ?
									""";
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, "%" + patron + "%");
			ps.setString(2, "%" + patron + "%");
			ps.setString(3, "%" + patron + "%");
			ps.setString(4, "%" + patron + "%");
			ps.setString(5, "%" + patron + "%");

			rs = ps.executeQuery();
			while(rs.next()) {
				ClienteConsultaDto cliente = new ClienteConsultaDto();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setCliente(rs.getString("cliente"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setFechaRegistro(rs.getTimestamp("fechaRegistro").toLocalDateTime());
				lista.add(cliente);
			}
			
		} catch (SQLException e) {
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			JdbcUtil.cerrar(cn, ps, rs);
		}
		
		return lista;
		
	}


}