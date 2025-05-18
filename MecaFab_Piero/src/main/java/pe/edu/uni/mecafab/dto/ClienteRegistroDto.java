package pe.edu.uni.mecafab.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRegistroDto {
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String direccion;
	private LocalDateTime fechaRegistro;
}
