package pe.edu.uni.mecafab.prueba;

import pe.edu.uni.mecafab.controller.EmpleadoController;
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;

public class Prueba03_ConsultarEmpleado {

	public static void main(String[] args) {

		try {
			// Datos
			EmpleadoConsultaDto dto = new EmpleadoConsultaDto("z", "z", "admin");
			
			// Proceso
			EmpleadoController controller = new EmpleadoController();

			// Reporte
			for (EmpleadoConsultaDto empleado : controller.procesarConsultarEmpleado(dto)) {
				System.out.println("ID EMPLEADO: " + empleado.getIdEmpleado() + "\t" +
													 "NOMBRE: " + empleado.getNombre() + "\t" +
													 "APELLIDO: " + empleado.getNombre() + "\t" +
													 "ROL: " + empleado.getDescripcionRol()+ "\n"
								);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
