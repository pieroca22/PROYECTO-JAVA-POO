package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.AsignacionDto;
import pe.edu.uni.mecafab.dto.EstadoPedidoDto;
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
	public List<PedidoConsultaDto> listarPedidosRegistrados() throws SQLException, Exception {
		return pedidoRepo.listarPedidosRegistrados();
	}
	
	// ============================
	// Asignar Pedido a Empleado
	// ============================
	public int asignarPedido(AsignacionDto dto) throws SQLException, Exception {
		return pedidoRepo.asignarPedido(dto);
	}
	
	// ============================
	// Listar Todos los Pedidos
	// ============================
	public List<PedidoConsultaDto> listarPedidos() throws SQLException, Exception {
		return pedidoRepo.listarPedidos();
	}
	
	// ============================
	// Actualizar Pedido (Su estado)
	// ============================
	public void actualizarPedido(int idPedido, int idEstado) throws SQLException, Exception {

		if (idEstado > 6 || idEstado < 1) {
			throw new Exception("Estado no valido.");
		}
		
		pedidoRepo.actualizarPedido(idPedido, idEstado);
	
	}
	
	// ============================
	// Listar Todos los Estados
	// ============================
	public List<EstadoPedidoDto> listarEstados() throws SQLException, Exception {
		return pedidoRepo.listarEstados();
	}
	
}
