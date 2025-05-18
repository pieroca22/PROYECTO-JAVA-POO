package pe.edu.uni.mecafab.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteConsultaDto {
	private int idCliente;
	private String cliente;
	private String telefono;
	private String email;
	private String direccion;
	private LocalDateTime fechaRegistro;
}
