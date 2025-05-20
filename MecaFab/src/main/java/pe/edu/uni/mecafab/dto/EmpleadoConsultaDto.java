package pe.edu.uni.mecafab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoConsultaDto {

	private int idEmpleado;
	private String empleado;
	private int idRol;
	private String descripcionRol;

}
