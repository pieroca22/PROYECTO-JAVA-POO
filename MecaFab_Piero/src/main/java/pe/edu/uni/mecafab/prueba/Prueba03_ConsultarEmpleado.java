package pe.edu.uni.mecafab.prueba;

import pe.edu.uni.mecafab.controller.EmpleadoController;
import pe.edu.uni.mecafab.dto.EmpleadoDto;

public class Prueba03_ConsultarEmpleado {

	public static void main(String[] args) {

		try {
			// Datos
			EmpleadoDto dto = new EmpleadoDto("p", "a");
			
			// Proceso
			EmpleadoController controller = new EmpleadoController();

			// Reporte
			for (EmpleadoDto empleado : controller.procesarConsultarEmpleado(dto)) {
				System.out.println("ID EMPLEADO: " + empleado.getIdEmpleado() + "\t" +
													 "NOMBRE: " + empleado.getNombre() + "\t" +
													 "APELLIDO: " + empleado.getNombre() + "\n"
								);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
