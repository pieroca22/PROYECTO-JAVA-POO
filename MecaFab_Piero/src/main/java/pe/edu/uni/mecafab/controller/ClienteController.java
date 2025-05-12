package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import pe.edu.uni.mecafab.dto.ClienteDto;
import pe.edu.uni.mecafab.service.ClienteService;

public class ClienteController {
	ClienteService service = new ClienteService();
	
	// REGISTRAR CLIENTE
	public void registrarCliente(ClienteDto dto) throws SQLException, Exception {
		service.registrarCliente(dto);
	}
	
}
