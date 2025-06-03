package pe.edu.uni.mecafab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoPedidoDto {
	private int idEstado;
	private String descripcion;
	private String categoria;
}
