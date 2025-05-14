package pe.edu.uni.mecafab.dto;

// SOLO PARA CONSULTAR EL EMPLEADO HEREDA DE "EmpleadoDto"
public class EmpleadoConsultaDto extends EmpleadoDto{
	
	private String descripcionRol;

	public EmpleadoConsultaDto() {
	}

	public EmpleadoConsultaDto(String nombre, String apellido, String descripcionRol) {
		super(nombre, apellido);
		this.descripcionRol = descripcionRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
	
}
