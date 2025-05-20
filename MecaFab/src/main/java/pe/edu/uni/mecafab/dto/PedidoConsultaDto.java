package pe.edu.uni.mecafab.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoConsultaDto {
	private int idPedido;
	private int idCliente;
	private String cliente;
	private String descripcion;
	private LocalDateTime fechaSolicitud;
	private Date fechaComprometida;
	private int idEstado;
	private String estado;
}
