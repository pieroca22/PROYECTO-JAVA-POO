package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import pe.edu.uni.mecafab.dto.EmpleadoDto;
import pe.edu.uni.mecafab.service.EmpleadoService;

public class EmpleadoController {
	
	EmpleadoService service = new EmpleadoService();
	
	// Registrar Empleado
	public void registrarEmpleado(EmpleadoDto dto) throws SQLException, Exception {
		service.registrarCliente(dto);
	}
	
}
