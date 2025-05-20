package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.EmpleadoConsultaDto;
import pe.edu.uni.mecafab.dto.EmpleadoRegistroDto;
import pe.edu.uni.mecafab.repository.EmpleadoRepository;
import pe.edu.uni.mecafab.util.StringUtil;
import pe.edu.uni.mecafab.validator.ValidarEmpleado;

public class EmpleadoService {
	
	EmpleadoRepository clienteRepo = new EmpleadoRepository();
	
	//==============================
	// REGISTRAR EMPLEADO
	//==============================
	public int registrarEmpleado(EmpleadoRegistroDto dto) throws SQLException, Exception {
		
		// Limpiamos y capitalizamos los datos
		dto.setNombre(StringUtil.limCap(dto.getNombre()));
		dto.setApellido(StringUtil.limCap(dto.getApellido()));
		
		// Verificamos si los datos son validos
		ValidarEmpleado.validarDatos(dto);
		
		return clienteRepo.registrarEmpleado(dto);
	}
	
	//==============================
	// CONSULTAR EMPLEADO
	//==============================
	public List<EmpleadoConsultaDto> consultarEmpleado(String patron) throws SQLException, Exception {
		return clienteRepo.consultarEmpleado(patron);
	}
	
}
