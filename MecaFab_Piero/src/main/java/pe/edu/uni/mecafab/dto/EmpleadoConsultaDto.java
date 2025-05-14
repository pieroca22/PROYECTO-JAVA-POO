package pe.edu.uni.mecafab.dto;

public class EmpleadoConsultaDto {
	
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private int idRol;
	private String descripcionRol;

	public EmpleadoConsultaDto() {
	}

	public EmpleadoConsultaDto(String nombre, String apellido, String descripcionRol) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.descripcionRol = descripcionRol;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
	
}
