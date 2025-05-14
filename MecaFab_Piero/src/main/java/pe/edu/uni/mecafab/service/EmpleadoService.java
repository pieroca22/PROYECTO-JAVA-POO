package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;
import pe.edu.uni.mecafab.dto.EmpleadoDto;
import pe.edu.uni.mecafab.repository.EmpleadoRepository;

public class EmpleadoService {
	
	EmpleadoRepository clienteRepo = new EmpleadoRepository();
	
	//==============================
	// REGISTRAR EMPLEADO
	//==============================
	public void registrarEmpleado(EmpleadoDto dto) throws SQLException, Exception {
		clienteRepo.registrarEmpleado(dto);
	}
	
	//==============================
	// CONSULTAR EMPLEADO
	//==============================
	public List<EmpleadoConsultaDto> consultarEmpleado(EmpleadoConsultaDto dto) throws SQLException, Exception {
		return clienteRepo.consultarEmpleado(dto);
	}
	
}
