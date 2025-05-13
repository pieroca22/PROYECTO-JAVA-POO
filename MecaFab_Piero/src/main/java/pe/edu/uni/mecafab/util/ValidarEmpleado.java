package pe.edu.uni.mecafab.util;

import pe.edu.uni.mecafab.dto.EmpleadoDto;

public interface ValidarEmpleado {

	public static void validarEmpleado(EmpleadoDto dto) throws Exception {
		String patronTexto = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

		if (dto.getNombre() == null || !dto.getNombre().matches(patronTexto)) {
			throw new Exception("El nombre solo debe contener letras y espacios.");
		}
		if (dto.getApellido() == null || !dto.getApellido().matches(patronTexto)) {
			throw new Exception("El apellido solo debe contener letras y espacios.");
		}

	}

}
