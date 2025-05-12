package pe.edu.uni.mecafab.service;

import java.sql.SQLException;
import pe.edu.uni.mecafab.dto.ClienteDto;
import pe.edu.uni.mecafab.repository.ClienteRepository;

public class ClienteService {
	
	ClienteRepository clienteRepo = new ClienteRepository();
	
	// REGISTRAR CLIENTE
	public void registrarCliente(ClienteDto dto) throws SQLException, Exception {
		clienteRepo.registrarCliente(dto);
	}
	
}
