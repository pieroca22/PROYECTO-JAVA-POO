package pe.edu.uni.mecafab.controller;

import java.sql.SQLException;
import java.util.List;
import pe.edu.uni.mecafab.dto.ClienteConsultaDto;
import pe.edu.uni.mecafab.dto.ClienteRegistroDto;
import pe.edu.uni.mecafab.service.ClienteService;

public class ClienteController {
	ClienteService service = new ClienteService();
	
	// REGISTRAR CLIENTE
	public void procesarRegistrarCliente(ClienteRegistroDto dto) throws SQLException, Exception {
		service.registrarCliente(dto);
	}
	
	// CONSULTAR CLIENTE
	public List<ClienteConsultaDto> procesarConsultarCliente(String patron) throws SQLException, Exception {
		return service.consultarCliente(patron);
	}
	
}
