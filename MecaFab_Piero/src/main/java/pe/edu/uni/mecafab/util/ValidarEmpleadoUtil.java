package pe.edu.uni.mecafab.util;

import pe.edu.uni.mecafab.dto.EmpleadoDto;

public interface ValidarEmpleadoUtil {

	public static void validarDatos(EmpleadoDto dto) throws Exception {

		// Solo letras y espacios
		String patronTexto = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

		// Nombre obligatorio
		if (!esTextoValido(dto.getNombre(), patronTexto)) {
			throw new Exception("El nombre solo debe contener letras y no puede estar vacío.");
		}

		// Apellido obligatorio
		if (!esTextoValido(dto.getApellido(), patronTexto)) {
			throw new Exception("El apellido solo debe contener letras y no puede estar vacío.");
		}

	}

	// Verifica que no sea nulo, no vacío y que cumpla el patrón
	private static boolean esTextoValido(String texto, String patron) {
		return texto != null && !texto.trim().isEmpty() && texto.trim().matches(patron);
	}
}
