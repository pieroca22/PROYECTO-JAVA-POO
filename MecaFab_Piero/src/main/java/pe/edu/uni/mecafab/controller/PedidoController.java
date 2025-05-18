package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;
import pe.edu.uni.mecafab.dto.PedidoRegistroDto;
import pe.edu.uni.mecafab.service.PedidoService;

public class PedidoController {
	
	PedidoService pedidoService = new PedidoService();
	
	// ============================
	// Registrar Pedido
	// ============================
	public int procesarRegistrarPedido(PedidoRegistroDto dto) throws SQLException, Exception {
		return pedidoService.registrarPedido(dto);
	}
	
	// ============================
	// Consultar Pedido
	// ============================
	public List<PedidoConsultaDto> procesarConsultarPedido(String patron) throws SQLException, Exception {
		return pedidoService.consultarPedido(patron);
	}
	
}
