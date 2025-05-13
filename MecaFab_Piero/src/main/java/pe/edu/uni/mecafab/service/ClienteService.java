package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.ClienteDto;
import pe.edu.uni.mecafab.repository.ClienteRepository;

public class ClienteService {
	
	ClienteRepository clienteRepo = new ClienteRepository();
	
	//==============================
	// REGISTRAR CLIENTE
	//==============================
	public void registrarCliente(ClienteDto dto) throws SQLException, Exception {
		clienteRepo.registrarCliente(dto);
	}
	
	//==============================
	// CONSULTAR CLIENTE
	//==============================
	public List<ClienteDto> consultarCliente(ClienteDto dto) throws SQLException, Exception {
		return clienteRepo.consultarCliente(dto);
	}
	
}
