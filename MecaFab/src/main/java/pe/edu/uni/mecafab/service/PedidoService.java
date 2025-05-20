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
	
	// ============================
	// Actualizar Pedido (Su estado)
	// ============================
	public void actualizarPedido(int idPedido, int idEstado) throws SQLException, Exception {

		if (idEstado > 4 || idEstado < 1) {
			throw new Exception("Estado no valido.");
		}

		if (idEstado == 1) {
			throw new Exception("El estado ya esta registrado.");
		}
		
		pedidoRepo.actualizarPedido(idPedido, idEstado);
	
	}
	
}
