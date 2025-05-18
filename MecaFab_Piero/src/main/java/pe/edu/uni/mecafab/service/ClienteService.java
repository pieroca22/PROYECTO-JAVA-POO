package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.ClienteConsultaDto;
import pe.edu.uni.mecafab.dto.ClienteRegistroDto;
import pe.edu.uni.mecafab.repository.ClienteRepository;

public class ClienteService {
	
	ClienteRepository clienteRepo = new ClienteRepository();
	
	//==============================
	// REGISTRAR CLIENTE
	//==============================
	public void registrarCliente(ClienteRegistroDto dto) throws SQLException, Exception {
		clienteRepo.registrarCliente(dto);
	}
	
	//==============================
	// CONSULTAR CLIENTE
	//==============================
	public List<ClienteConsultaDto> consultarCliente(String patron) throws SQLException, Exception {
		return clienteRepo.consultarCliente(patron);
	}
	
}
