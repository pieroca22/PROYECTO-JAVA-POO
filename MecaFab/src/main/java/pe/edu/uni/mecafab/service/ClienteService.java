package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.ClienteConsultaDto;
import pe.edu.uni.mecafab.dto.ClienteRegistroDto;
import pe.edu.uni.mecafab.repository.ClienteRepository;
import pe.edu.uni.mecafab.util.StringUtil;
import pe.edu.uni.mecafab.validator.ValidarCliente;

public class ClienteService {
	
	ClienteRepository clienteRepo = new ClienteRepository();
	
	//==============================
	// REGISTRAR CLIENTE
	//==============================
	public int registrarCliente(ClienteRegistroDto dto) throws SQLException, Exception {
		
		// Limpiamos y capitalizamos los datos
		dto.setNombre(StringUtil.limCap(dto.getNombre()));
		dto.setApellido(StringUtil.limCap(dto.getApellido()));
		dto.setTelefono(StringUtil.limCap(dto.getTelefono()));
		dto.setEmail(StringUtil.limCap(dto.getEmail()));
		dto.setDireccion(StringUtil.limCap(dto.getDireccion()));
		
		// Verificamos que sea valido los datos ingresados
		ValidarCliente.validarDatos(dto);
		
		return clienteRepo.registrarCliente(dto);
	}
	
	//==============================
	// CONSULTAR CLIENTE
	//==============================
	public List<ClienteConsultaDto> consultarCliente(String patron) throws SQLException, Exception {
		return clienteRepo.consultarCliente(patron);
	}
	
}
