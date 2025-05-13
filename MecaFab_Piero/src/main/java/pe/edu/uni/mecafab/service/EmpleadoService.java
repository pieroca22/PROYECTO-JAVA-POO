package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import pe.edu.uni.mecafab.dto.EmpleadoDto;
import pe.edu.uni.mecafab.repository.EmpleadoRepository;

public class EmpleadoService {
	
	EmpleadoRepository clienteRepo = new EmpleadoRepository();
	
	//==============================
	// REGISTRAR EMPLEADO
	//==============================
	public void registrarCliente(EmpleadoDto dto) throws SQLException, Exception {
		clienteRepo.registrarEmpleado(dto);
	}
	
}
