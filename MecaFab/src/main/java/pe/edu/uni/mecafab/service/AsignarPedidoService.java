package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import pe.edu.uni.mecafab.dto.AsignacionDto;
import pe.edu.uni.mecafab.repository.AsignarPedidoRepository;

public class AsignarPedidoService {

	AsignarPedidoRepository asignarRepo = new AsignarPedidoRepository();
	
	// ============================
	// Asignar Pedido a Empleado
	// ============================
	public int asignarPedido(AsignacionDto dto) throws SQLException, Exception {
		return asignarRepo.asignarPedido(dto);
	}
	
}
