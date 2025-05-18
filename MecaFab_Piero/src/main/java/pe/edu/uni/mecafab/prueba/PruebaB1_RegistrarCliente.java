package pe.edu.uni.mecafab.prueba;

import java.time.LocalDateTime;
import pe.edu.uni.mecafab.controller.ClienteController;
import pe.edu.uni.mecafab.dto.ClienteRegistroDto;

public class PruebaB1_RegistrarCliente {
	
	public static void main(String[] args) {
		
		try {
			// Datos
			ClienteRegistroDto dto = new ClienteRegistroDto();
			dto.setNombre("Jose");
			dto.setApellido("Karlos");
			dto.setTelefono("903723128");
			dto.setEmail("josekarlo@gma-il.com");
			dto.setDireccion("Calle 10");
			dto.setFechaRegistro(LocalDateTime.now());
			
			// Proceso
			ClienteController controller = new ClienteController();
			controller.procesarRegistrarCliente(dto);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	
}
