package pe.edu.uni.mecafab.prueba;

import java.sql.Date;
import java.time.LocalDateTime;
import pe.edu.uni.mecafab.controller.PedidoController;
import pe.edu.uni.mecafab.dto.PedidoRegistroDto;

public class PruebaD1_RegistrarPedido {

	public static void main(String[] args) {
		try {
			
			// Datos
			int idCliente = 1;
			String descripcion = "Pedido de reparo de metal";
			LocalDateTime fechaSolicitud = LocalDateTime.now();
			Date fechaComprometida = Date.valueOf("2025-06-03"); // En realidad deberia ponerse cuando se asigne el empleado
			int idEstado = 1; // En espera de inicio
			PedidoRegistroDto dto = new PedidoRegistroDto(idCliente, descripcion, fechaSolicitud, null, idEstado);
			
			// Proceso
			PedidoController controller = new PedidoController();
			int idPedido = controller.procesarRegistrarPedido(dto);
			
			// Reporte
			System.out.println("ID Pedido: " + idPedido);
			System.out.println("Pedido Registrado Correctamente");
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

}
