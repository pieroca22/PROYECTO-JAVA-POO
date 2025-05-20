package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;
import pe.edu.uni.mecafab.dto.PedidoRegistroDto;
import pe.edu.uni.mecafab.repository.PedidoRepository;

public class PedidoService {

	PedidoRepository pedidoRepo = new PedidoRepository();
	
	// ============================
	// Registrar Pedido
	// ============================
	public int registrarPedido(PedidoRegistroDto dto) throws SQLException, Exception {
		return pedidoRepo.registrarPedido(dto);
	}
	
	// ============================
	// Consultar Pedido
	// ============================
	public List<PedidoConsultaDto> consultarPedido(String patron) throws SQLException, Exception {
		return pedidoRepo.consultarPedido(patron);
	}
	
	// ============================
	// Listar Pedidos en inicio de espera (Para la asignacion del empleado)
	// ============================
	public List<PedidoConsultaDto> listarPedidos() throws SQLException, Exception {
		return pedidoRepo.listarPedidos();
	}
	
}
