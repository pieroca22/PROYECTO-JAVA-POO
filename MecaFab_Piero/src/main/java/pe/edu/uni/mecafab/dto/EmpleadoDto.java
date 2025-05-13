package pe.edu.uni.mecafab.dto;

public class EmpleadoDto {

	private int idEmpleado;
	private String nombre;
	private String apellido;
	private int idRol;

	public EmpleadoDto() {
	}

	public EmpleadoDto(String nombre, String apellido, int idRol) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.idRol = idRol;
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

}
