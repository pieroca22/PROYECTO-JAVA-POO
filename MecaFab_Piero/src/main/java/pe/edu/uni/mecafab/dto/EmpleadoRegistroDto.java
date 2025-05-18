package pe.edu.uni.mecafab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoRegistroDto {

	private String nombre;
	private String apellido;
	private int idRol;

}
