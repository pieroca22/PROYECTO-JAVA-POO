package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.AsignacionDto;
import pe.edu.uni.mecafab.dto.EstadoPedidoDto;
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
	
	// ============================
	// Listar Pedidos en inicio de espera (Para la asignacion del empleado)
	// ============================
	public List<PedidoConsultaDto> procesarListarPedidosRegistrados() throws SQLException, Exception {
		return pedidoService.listarPedidosRegistrados();
	}
	
	// ============================
	// Asignar Pedido a Empleado
	// ============================
	public int procesarAsignarPedido(AsignacionDto dto) throws SQLException, Exception {
		return pedidoService.asignarPedido(dto);
	}
	
	// ============================
	// Listar Todos los Pedidos
	// ============================
	public List<PedidoConsultaDto> procesarListarPedidos() throws SQLException, Exception {
		return pedidoService.listarPedidos();
	}
	
	// ============================
	// Actualizar Pedido (Su estado)
	// ============================
	public void procesarActualizarPedido(int idPedido, int idEstado) throws SQLException, Exception {
		pedidoService.actualizarPedido(idPedido, idEstado);
	}
	
	// ============================
	// Listar Todos los Estados
	// ============================
	public List<EstadoPedidoDto> procesarListarEstados() throws SQLException, Exception {
		return pedidoService.listarEstados();
	}
	
}
