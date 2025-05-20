package pe.edu.uni.mecafab.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguimientoEstadoDto {
	
	private int idSeguimiento;
	private int idPedido;
	private int idEstado;
	private LocalDateTime fechaCambio;
	
}
