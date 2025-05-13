package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.RolDto;
import pe.edu.uni.mecafab.repository.RolRepository;

public class RolService {
	
	RolRepository rolRepo = new RolRepository();
	
	// OBTENER LOS ROLES QUE SE TIENEN EN LA BASE DE DATOS
	public List<RolDto> obtenerRoles() throws SQLException, Exception {
		return rolRepo.obtenerRoles();
	}
	
}
