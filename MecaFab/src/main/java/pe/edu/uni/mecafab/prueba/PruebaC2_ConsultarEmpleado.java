package pe.edu.uni.mecafab.prueba;

import pe.edu.uni.mecafab.controller.EmpleadoController;
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;

public class PruebaC2_ConsultarEmpleado {

	public static void main(String[] args) {

		try {
			// Datos
			String patron = "a";
			
			// Proceso
			EmpleadoController controller = new EmpleadoController();

			// Reporte
			for (EmpleadoConsultaDto empleado : controller.procesarConsultarEmpleado(patron)) {
				System.out.println("CODIGO EMPLEADO: " + empleado.getCodigoEmpleado() + "\t" +
													 "EMPLEADO: " + empleado.getEmpleado()+ "\t" +
													 "ROL: " + empleado.getDescripcionRol()+ "\n"
								);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
