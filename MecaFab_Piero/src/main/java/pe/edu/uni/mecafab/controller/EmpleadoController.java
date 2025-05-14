package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.EmpleadoDto;
import pe.edu.uni.mecafab.service.EmpleadoService;

public class EmpleadoController {
	
	EmpleadoService service = new EmpleadoService();
	
	// Registrar Empleado
	public void procesarRegistrarEmpleado(EmpleadoDto dto) throws SQLException, Exception {
		service.registrarEmpleado(dto);
	}
	
	// Consultar Empleado
	public List<EmpleadoDto> procesarConsultarEmpleado(EmpleadoDto dto) throws SQLException, Exception {
		return service.consultarEmpleado(dto);
	}
	
}
