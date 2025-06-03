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
import pe.edu.uni.mecafab.dto.AsignacionDto;
import pe.edu.uni.mecafab.dto.EstadoPedidoDto;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;
import pe.edu.uni.mecafab.dto.PedidoRegistroDto;
import pe.edu.uni.mecafab.util.JdbcUtil;
import pe.edu.uni.mecafab.util.TransCodeUtil;

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
			cn.setAutoCommit(false);

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
			if (rs.next()) {
				idPedido = rs.getInt(1);
			}
			// Generar el código del cliente: PD-0000001
			String codigo = TransCodeUtil.transCodePedido(idPedido);
			// Actualizar el cliente con su código
      String update = "UPDATE Pedido SET codigoPedido = ? WHERE idPedido = ?";
      try (PreparedStatement ps2 = cn.prepareStatement(update)) {
				ps2.setString(1, codigo);
				ps2.setInt(2, idPedido);
				ps2.executeUpdate();
      }

			cn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(cn);
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
		} catch (Exception e) {
			JdbcUtil.rollback(cn);
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			JdbcUtil.cerrar(cn, ps, rs);
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
					SELECT pe.idPedido, pe.codigoPedido, pe.idCliente, 
							 CONCAT(cl.nombre,' ',cl.apellido) AS cliente, 
							 pe.descripcion AS descripcionPedido, 
                pe.fechaSolicitud, pe.fechaComprometida,  
							 pe.idEstado, es.descripcion AS descripcionEstado
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
				empleado.setCodigoPedido(rs.getString("codigoPedido"));
				empleado.setIdCliente(rs.getInt("idCliente"));
				empleado.setCliente(rs.getString("cliente"));
				empleado.setDescripcion(rs.getString("descripcionPedido"));
				empleado.setFechaSolicitud(rs.getTimestamp("fechaSolicitud").toLocalDateTime());
				empleado.setFechaComprometida(rs.getDate("fechaComprometida"));
				empleado.setIdEstado(rs.getInt("idEstado"));
				empleado.setEstado(rs.getString("descripcionEstado"));
				lista.add(empleado);
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

	// ============================
	// Listar Pedidos registrados (Para la asignacion del empleado)
	// ============================
	public List<PedidoConsultaDto> listarPedidosRegistrados() throws SQLException, Exception {

		List<PedidoConsultaDto> lista = new ArrayList<>();

		try {

			cn = AccesoDB.getConnection();

			String sql = """
            SELECT pe.idPedido, pe.codigoPedido, 
									pe.descripcion AS descripcionPedido, 
                   pe.fechaSolicitud, pe.fechaComprometida, 
                   pe.idCliente, 
                   CONCAT(cl.nombre,' ',cl.apellido) AS cliente, 
                   pe.idEstado, 
                   est.descripcion AS descripcionEstado 
            FROM Pedido pe 
            JOIN Cliente cl ON pe.idCliente = cl.idCliente
            JOIN Estado est ON pe.idEstado = est.idEstado
            WHERE pe.idEstado = 1 
            ORDER BY pe.fechaSolicitud 
                """;

			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				PedidoConsultaDto empleado = new PedidoConsultaDto();
				empleado.setIdPedido(rs.getInt("idPedido"));
				empleado.setCodigoPedido(rs.getString("codigoPedido"));
				empleado.setIdCliente(rs.getInt("idCliente"));
				empleado.setCliente(rs.getString("cliente"));
				empleado.setDescripcion(rs.getString("descripcionPedido"));
				empleado.setFechaSolicitud(rs.getTimestamp("fechaSolicitud").toLocalDateTime());
				empleado.setFechaComprometida(rs.getDate("fechaComprometida"));
				empleado.setIdEstado(rs.getInt("idEstado"));
				empleado.setEstado(rs.getString("descripcionEstado"));
				lista.add(empleado);
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

	// ============================
	// Asignar Pedido a Empleado
	// ============================
	public int asignarPedido(AsignacionDto dto) throws SQLException, Exception {

		int idAsignacion = -1;
		
		try {

			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);

			String sqlInsert = """
                     INSERT INTO Asignacion 
                     (idPedido, idEmpleado, fechaAsignacion) 
                     VALUES (?,?,?)
                     """;

			String sqlUpdate = """
                     UPDATE Pedido 
                     SET idEstado = ? WHERE idPedido = ?
                     """;
			
			// Insert: Asignar un pedido a un empleado
			ps = cn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, dto.getIdPedido());
			ps.setInt(2, dto.getIdEmpleado());
			ps.setTimestamp(3, Timestamp.valueOf(dto.getFechaAsignacion()));
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				idAsignacion = rs.getInt(1);
			}
			
			// Update: Se actualiza el estado del pedido
			try (PreparedStatement ps2 = cn.prepareStatement(sqlUpdate)) {
				ps2.setInt(1, 2); // idEstado = 2 --> Registrado
				ps2.setInt(2, dto.getIdPedido());
				ps2.executeUpdate();
			}
			
			cn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(cn);
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
		} catch (Exception e) {
			JdbcUtil.rollback(cn);
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			JdbcUtil.cerrar(cn, ps, rs);
		}

		return idAsignacion;
		
	}
	
	// ============================
	// Listar Todos los Pedidos
	// ============================
	public List<PedidoConsultaDto> listarPedidos() throws SQLException, Exception {

		List<PedidoConsultaDto> lista = new ArrayList<>();

		try {

			cn = AccesoDB.getConnection();

			String sql = """
						SELECT pe.idPedido, pe.codigoPedido, 
                   pe.descripcion AS descripcionPedido, 
                   pe.fechaSolicitud, pe.fechaComprometida, 
                   pe.idCliente, 
                   CONCAT(cl.nombre,' ',cl.apellido) AS cliente, 
                   pe.idEstado, 
                   est.descripcion AS descripcionEstado 
            FROM Pedido pe 
            JOIN Cliente cl ON pe.idCliente = cl.idCliente
            JOIN Estado est ON pe.idEstado = est.idEstado
            ORDER BY pe.fechaSolicitud DESC, pe.idEstado ASC
                """;

			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				PedidoConsultaDto empleado = new PedidoConsultaDto();
				empleado.setIdPedido(rs.getInt("idPedido"));
				empleado.setCodigoPedido(rs.getString("codigoPedido"));
				empleado.setIdCliente(rs.getInt("idCliente"));
				empleado.setCliente(rs.getString("cliente"));
				empleado.setDescripcion(rs.getString("descripcionPedido"));
				empleado.setFechaSolicitud(rs.getTimestamp("fechaSolicitud").toLocalDateTime());
				empleado.setFechaComprometida(rs.getDate("fechaComprometida"));
				empleado.setIdEstado(rs.getInt("idEstado"));
				empleado.setEstado(rs.getString("descripcionEstado"));
				lista.add(empleado);
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
	
	// ============================
	// Actualizar Estado del Pedido
	// ============================
	public void actualizarPedido(int idPedido, int idEstado) throws SQLException, Exception {

		try {

			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);

			String sql = """
						UPDATE Pedido 
						SET idEstado = ? WHERE idPedido = ?
                """;

			ps = cn.prepareStatement(sql);
			ps.setInt(1, idEstado);
			ps.setInt(2, idPedido);

			int filas = ps.executeUpdate();
			System.out.println("✅ Filas afectadas: " + filas);

			cn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(cn);
			throw new SQLException("Error al conectar a la BD." + e.getMessage());
		} catch (Exception e) {
			JdbcUtil.rollback(cn);
			throw new Exception("Error inesperado: " + e.getMessage());
		} finally {
			JdbcUtil.cerrar(cn, ps, rs);
		}

	}
	
	// ============================
	// Listar Todos los Estados
	// ============================
	public List<EstadoPedidoDto> listarEstados() throws SQLException, Exception {
		
		List<EstadoPedidoDto> lista = new ArrayList<>();

		try {

			cn = AccesoDB.getConnection();

			String sql = """
						SELECT idEstado, descripcion, categoria 
             FROM Estado
                """;

			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EstadoPedidoDto estado = new EstadoPedidoDto();
				estado.setIdEstado(rs.getInt("idEstado"));
				estado.setDescripcion(rs.getString("descripcion"));
				estado.setCategoria("categoria");
				lista.add(estado);
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
