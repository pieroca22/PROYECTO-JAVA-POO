package pe.edu.uni.mecafab.prueba;

import java.util.List;
import pe.edu.uni.mecafab.controller.EmpleadoController;
import pe.edu.uni.mecafab.dto.RolEmpleadoDto;

public class PruebaC0_ObtenerRoles {

	public static void main(String[] args) {

		try {
			// Datos
			List<RolEmpleadoDto> list;
			
			// Proceso
			EmpleadoController controller = new EmpleadoController();
			list = controller.procesarObtenerRoles();
			
			// Reporte
			for (RolEmpleadoDto dto : list) {
				System.out.println("ID Rol: " + dto.getIdRol() + "\t" + 
													 "Descripcion: " + dto.getDescripcion());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
