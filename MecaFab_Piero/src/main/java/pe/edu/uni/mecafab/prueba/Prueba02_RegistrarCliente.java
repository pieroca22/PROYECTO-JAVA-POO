package pe.edu.uni.mecafab.prueba;

import java.time.LocalDateTime;
import pe.edu.uni.mecafab.controller.ClienteController;
import pe.edu.uni.mecafab.dto.ClienteDto;

public class Prueba02_RegistrarCliente {
	
	public static void main(String[] args) {
		
		try {
			// Datos
			ClienteDto dto = new ClienteDto();
			dto.setNombre("Jose");
			dto.setApellido("Karlos");
			dto.setTelefono("903723128");
			dto.setEmail("josekarlo@gma-il.com");
			dto.setDireccion("Calle 10");
			dto.setFechaRegistro(LocalDateTime.now());
			
			// Proceso
			ClienteController controller = new ClienteController();
			controller.registrarCliente(dto);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	
}
