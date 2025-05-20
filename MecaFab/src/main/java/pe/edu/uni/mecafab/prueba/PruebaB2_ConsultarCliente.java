package pe.edu.uni.mecafab.prueba;

import pe.edu.uni.mecafab.controller.ClienteController;
import pe.edu.uni.mecafab.dto.ClienteConsultaDto;

public class PruebaB2_ConsultarCliente {

	public static void main(String[] args) {

		try {
			// Datos
			String patron = "9";
			
			// Proceso
			ClienteController controller = new ClienteController();

			// Reporte
			for (ClienteConsultaDto cliente : controller.procesarConsultarCliente(patron)) {
				System.out.println("ID CLIENTE: " + cliente.getIdCliente() + "\t" +
													 "CLIENTE: " + cliente.getCliente()+ "\t" + 
													 "TELEFONO: " + cliente.getTelefono() + "\t" +
													 "EMAIL: " + cliente.getEmail() + "\t" + 
													 "DIRECCION: " + cliente.getDireccion() + "\t" +
													 "FECHA DE REGISTRO: " + cliente.getFechaRegistro() + "\n"
								);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
