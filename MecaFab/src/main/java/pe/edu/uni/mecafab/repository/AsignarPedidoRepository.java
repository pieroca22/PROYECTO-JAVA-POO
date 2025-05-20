package pe.edu.uni.mecafab.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import pe.edu.uni.mecafab.db.AccesoDB;
import pe.edu.uni.mecafab.dto.AsignacionDto;
import pe.edu.uni.mecafab.util.JdbcUtil;

public class AsignarPedidoRepository {

	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

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
	
}
