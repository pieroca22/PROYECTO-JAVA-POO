package pe.edu.uni.mecafab.prueba;

import pe.edu.uni.mecafab.controller.PedidoController;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;

public class PruebaD2_ConsultarPedido {

	public static void main(String[] args) {

		try {
			// Datos
			String patron = "a";
			
			// Proceso
			PedidoController controller = new PedidoController();
			// Reporte
			for (PedidoConsultaDto pedido : controller.procesarConsultarPedido(patron)) {
				System.out.println("ID PEDIDO: " + pedido.getIdPedido()+ "\t" +
													 "CLIENTE: " + pedido.getCliente()+ "\t" +
													 "DESCRIPCION: " + pedido.getDescripcion()+ "\t" +
													 "FECHA DE SOLICITUD: " + pedido.getFechaSolicitud()+ "\t" +
													 "FECHA DE VENCIMIENTO: " + pedido.getFechaComprometida()+ "\t" +
													 "ESTADO: " + pedido.getEstado() + "\n"
								);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
