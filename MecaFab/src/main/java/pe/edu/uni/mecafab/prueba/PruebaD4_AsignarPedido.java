package pe.edu.uni.mecafab.prueba;

import java.time.LocalDateTime;
import pe.edu.uni.mecafab.controller.AsignarPedidoController;
import pe.edu.uni.mecafab.controller.PedidoController;
import pe.edu.uni.mecafab.dto.AsignacionDto;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;

public class PruebaD4_AsignarPedido {

	public static void main(String[] args) {

		PedidoController pedidoController = new PedidoController();
		AsignarPedidoController asignarController = new AsignarPedidoController();

		try {
			
			// Datos
			AsignacionDto dto = new AsignacionDto();
			dto.setIdPedido(1);
			dto.setIdEmpleado(1);
			dto.setFechaAsignacion(LocalDateTime.now());
			
			// Listamos primero
			System.out.println("Pedidos para asignar:");
			for (PedidoConsultaDto p : pedidoController.procesarListarPedido()) {
				System.out.println(
								p.getIdPedido() + " | "
								+ p.getIdCliente() + " | "
								+ p.getCliente() + " | "
								+ p.getDescripcion() + " | "
								+ p.getEstado()
				);
			}
			
			// Asignamos el primer pedido al empleado ID 1
			int idAsignacion = asignarController.asignarPedido(dto);
			
			// Vemos que ya no aparece el pedido id = 1, y el idEstado 1 --> 2
			System.out.println("Pedidos para asignar actualizado:");
			for (PedidoConsultaDto p : pedidoController.procesarListarPedido()) {
				System.out.println(
								p.getIdPedido() + " | "
								+ p.getIdCliente() + " | "
								+ p.getCliente() + " | "
								+ p.getDescripcion() + " | "
								+ p.getEstado()
				);
			}
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
