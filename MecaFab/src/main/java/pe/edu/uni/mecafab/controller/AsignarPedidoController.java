package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import pe.edu.uni.mecafab.dto.AsignacionDto;
import pe.edu.uni.mecafab.service.AsignarPedidoService;

public class AsignarPedidoController {
	
	AsignarPedidoService service = new AsignarPedidoService();
	
	// ============================
	// Asignar Pedido a Empleado
	// ============================
	public int asignarPedido(AsignacionDto dto) throws SQLException, Exception {
		return service.asignarPedido(dto);
	}
	
}
