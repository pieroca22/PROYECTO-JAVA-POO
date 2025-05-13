package pe.edu.uni.mecafab.prueba;

import java.util.List;
import pe.edu.uni.mecafab.controller.RolController;
import pe.edu.uni.mecafab.dto.RolDto;

public class Prueba04_ObtenerRoles {

	public static void main(String[] args) {

		try {
			// Datos
			List<RolDto> list = null;
			
			// Proceso
			RolController controller = new RolController();
			list = controller.obtenerRoles();
			
			// Reporte
			for (RolDto dto : list) {
				System.out.println("ID Rol: " + dto.getIdRol() + "\t" + 
													 "Descripcion: " + dto.getDescripcion());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
