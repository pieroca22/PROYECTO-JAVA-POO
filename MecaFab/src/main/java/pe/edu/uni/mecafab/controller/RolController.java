package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.RolDto;
import pe.edu.uni.mecafab.service.RolService;

public class RolController {
	
	RolService service = new RolService();
	
	// Obtener Roles
	public List<RolDto> obtenerRoles() throws SQLException, Exception {
		return service.obtenerRoles();
	}
}
