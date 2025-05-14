package pe.edu.uni.mecafab.prueba;

import pe.edu.uni.mecafab.controller.ClienteController;
import pe.edu.uni.mecafab.dto.ClienteDto;

public class PruebaB2_ConsultarCliente {

	public static void main(String[] args) {

		try {
			// Datos
			ClienteDto dto = new ClienteDto("p", "p", "91ads1", "adsaf@gmail.com", "easda");
			
			// Proceso
			ClienteController controller = new ClienteController();

			// Reporte
			for (ClienteDto cliente : controller.procesarConsultarCliente(dto)) {
				System.out.println("ID CLIENTE: " + cliente.getIdCliente() + "\t" +
													 "NOMBRE: " + cliente.getNombre() + "\t" +
													 "APELLIDO: " + cliente.getApellido() + "\t" + 
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
