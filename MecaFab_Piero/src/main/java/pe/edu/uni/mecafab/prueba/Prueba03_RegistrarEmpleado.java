package pe.edu.uni.mecafab.prueba;

import pe.edu.uni.mecafab.controller.EmpleadoController;
import pe.edu.uni.mecafab.dto.EmpleadoDto;

public class Prueba03_RegistrarEmpleado {

	public static void main(String[] args) {

		try {
			// Datos
			EmpleadoDto dto = new EmpleadoDto();
			dto.setNombre("Pedro");
			dto.setApellido("Neto");
			dto.setIdRol(1); // 1: Jefe de taller | 2: Encargado de produccion | 3: Personal administrativo

			// Proceso
			EmpleadoController controller = new EmpleadoController();
			controller.procesarRegistrarEmpleado(dto);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
