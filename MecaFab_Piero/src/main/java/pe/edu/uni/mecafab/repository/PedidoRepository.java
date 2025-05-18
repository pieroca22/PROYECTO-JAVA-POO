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
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;
import pe.edu.uni.mecafab.dto.PedidoRegistroDto;

public class PedidoRepository {
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// ============================
	// Registrar Pedido
	// ============================
	public int registrarPedido(PedidoRegistroDto dto) throws SQLException, Exception {
		
		int idPedido = -1;
		
		try {
			
			cn = AccesoDB.getConnection();
			
			String sql = """
            INSERT INTO 
            Pedido (idCliente, descripcion, fechaSolicitud, fechaComprometida, idEstado)
            VALUES (?,?,?,?,?)
                """;
			
			ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, dto.getIdCliente());
			ps.setString(2, dto.getDescripcion());
			ps.setTimestamp(3, Timestamp.valueOf(dto.getFechaSolicitud()));
			ps.setDate(4, dto.getFechaComprometida());
			ps.setInt(5, dto.getIdEstado());
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				idPedido = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
			}
		}
		
		return idPedido;
	}
	
	// ============================
	// Consultar Pedido
	// ============================
	public List<PedidoConsultaDto> consultarPedido(String patron) throws SQLException, Exception {
		
		List<PedidoConsultaDto> lista = new ArrayList<>();
		
		try {
			
			cn = AccesoDB.getConnection();
			
			String sql = """
					SELECT pe.idPedido, pe.idCliente, 
							 CONCAT(cl.nombre,' ',cl.apellido) AS cliente, 
							 pe.descripcion, pe.fechaSolicitud, pe.fechaComprometida,  
							 pe.idEstado, es.descripcion AS estado
					FROM Pedido pe 
					JOIN Cliente cl ON cl.idCliente = pe.idCliente 
					JOIN Estado es ON es.idEstado = pe.idEstado 
					WHERE cl.nombre COLLATE Latin1_General_CI_AI LIKE ? OR 
							cl.apellido COLLATE Latin1_General_CI_AI LIKE ? OR 
							cl.telefono LIKE ?
                """;
			
			ps = cn.prepareStatement(sql);
			ps.setString(1, "%" + patron + "%");
			ps.setString(2, "%" + patron + "%");
			ps.setString(3, "%" + patron + "%");
			
			rs = ps.executeQuery();
			while (rs.next()) {
				PedidoConsultaDto empleado = new PedidoConsultaDto();
				empleado.setIdPedido(rs.getInt("idPedido"));
				empleado.setIdCliente(rs.getInt("idCliente"));
				empleado.setCliente(rs.getString("cliente"));
				empleado.setDescripcion(rs.getString("descripcion"));
				empleado.setFechaSolicitud(rs.getTimestamp("fechaSolicitud").toLocalDateTime());
				empleado.setFechaComprometida(rs.getDate("fechaComprometida"));
				empleado.setIdEstado(rs.getInt("idEstado"));
				empleado.setEstado(rs.getString("estado"));
				lista.add(empleado);
			}
			
		} catch (SQLException e) {
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (cn != null) cn.close();
			} catch (Exception e) {
			}
		}
		
		return lista;
	}
	
}
