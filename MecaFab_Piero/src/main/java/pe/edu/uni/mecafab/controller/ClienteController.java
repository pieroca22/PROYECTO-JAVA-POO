package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.ClienteDto;
import pe.edu.uni.mecafab.service.ClienteService;

public class ClienteController {
	ClienteService service = new ClienteService();
	
	// REGISTRAR CLIENTE
	public void procesarRegistrarCliente(ClienteDto dto) throws SQLException, Exception {
		service.registrarCliente(dto);
	}
	
	// CONSULTAR CLIENTE
	public List<ClienteDto> procesarConsultarCliente(ClienteDto dto) throws SQLException, Exception {
		return service.consultarCliente(dto);
	}
	
}
