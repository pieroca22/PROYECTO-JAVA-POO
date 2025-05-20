package pe.edu.uni.mecafab.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionDto {

    private int idAsignacion;
    private int idPedido;
    private int idEmpleado;
    private LocalDateTime fechaAsignacion;

    public AsignacionDto(int idPedido, int idEmpleado, LocalDateTime fechaAsignacion) {
        this.idPedido = idPedido;
        this.idEmpleado = idEmpleado;
        this.fechaAsignacion = fechaAsignacion;
    }

}