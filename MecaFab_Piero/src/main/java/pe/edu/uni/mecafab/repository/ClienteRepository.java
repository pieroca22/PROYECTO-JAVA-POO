package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.ClienteDto;
import pe.edu.uni.mecafab.util.ValidarCliente;

public class ClienteRepository {

	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

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
		} catch (Exception e) {
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
			}
		}

	}

	// ============================
	// Consultar Cliente
	// ============================
	public List<ClienteDto> consultarCliente(ClienteDto dto) throws SQLException, Exception {
		
		try {
			
			List<ClienteDto> lista = new ArrayList<>();
			
			cn = AccesoDB.getConnection();
			
			// EN MEJORA, HACERLO ESTILO WHATSAPP LA BUSQUEDA
			String sql = """
                   SELECT * FROM Cliente
                   WHERE nombre COLLATE Latin1_General_CI_AI LIKE ? OR 
                         apellido COLLATE Latin1_General_CI_AI LIKE ? OR 
                         telefono LIKE ? OR 
                         email LIKE ? OR 
                         direccion COLLATE Latin1_General_CI_AI LIKE ?
									""";
			ps = cn.prepareStatement(sql);
			ps.setString(1, "%" + dto.getNombre() + "%");
			ps.setString(2, "%" + dto.getApellido() + "%");
			ps.setString(3, "%" + dto.getTelefono() + "%");
			ps.setString(4, "%" + dto.getEmail() + "%");
			ps.setString(5, "%" + dto.getDireccion() + "%");

			rs = ps.executeQuery();
			while(rs.next()) {
				ClienteDto cliente = new ClienteDto();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setFechaRegistro(rs.getTimestamp("fechaRegistro").toLocalDateTime());
				lista.add(cliente);
			}
			
			return lista;
			
		} catch (SQLException e) {
			throw new SQLException("Error al conectar a la BD.");
		} catch (Exception e) {
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
			}
		}

	}


}