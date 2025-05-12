package pe.edu.uni.mecafab.util;

import pe.edu.uni.mecafab.dto.ClienteDto;

public interface ValidarCliente {

	public static void validarCliente(ClienteDto dto) throws Exception {
		String patronTexto = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";
		String patronTelefono = "\\d{9}";
		String patronEmail = "^[\\w.-]+@(gmail\\.com|outlook\\.com|hotmail\\.com)$";

		if (dto.getNombre() == null || !dto.getNombre().matches(patronTexto)) {
			throw new Exception("El nombre solo debe contener letras y espacios.");
		}
		if (dto.getApellido() == null || !dto.getApellido().matches(patronTexto)) {
			throw new Exception("El apellido solo debe contener letras y espacios.");
		}

		if (dto.getTelefono() == null || !dto.getTelefono().matches(patronTelefono)) {
			throw new Exception("El teléfono solo debe contener 9 dígitos numéricos.");
		}

		if (dto.getEmail() == null || !dto.getEmail().matches(patronEmail)) {
			throw new Exception("Solo se permiten correos @gmail.com, @outlook.com o @hotmail.com.");
		}

	}

}
