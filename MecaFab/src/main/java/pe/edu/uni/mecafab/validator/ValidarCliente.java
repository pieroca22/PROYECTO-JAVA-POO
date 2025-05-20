package pe.edu.uni.mecafab.validator;

import pe.edu.uni.mecafab.dto.ClienteRegistroDto;

public interface ValidarCliente {

	public static void validarDatos(ClienteRegistroDto dto) throws Exception {

		// Solo letras y espacios
		String patronTexto = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";
		// Teléfono: exactamente 9 dígitos
		String patronTelefono = "^9\\d{8}$";
		// Email permitido: dominios conocidos
		String patronEmail = "^[\\w.-]+@(gmail\\.com|outlook\\.com|hotmail\\.com)$";
		// Direccion
		String patronDireccion = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ .,-]+$";


		// Nombre obligatorio
		if (!esTextoValido(dto.getNombre(), patronTexto)) {
			throw new Exception("El nombre solo debe contener letras y no puede estar vacío.");
		}

		// Apellido obligatorio
		if (!esTextoValido(dto.getApellido(), patronTexto)) {
			throw new Exception("El apellido solo debe contener letras y no puede estar vacío.");
		}

		// Teléfono obligatorio
		if (dto.getTelefono() == null || !dto.getTelefono().matches(patronTelefono)) {
			throw new Exception("Ingrese un número telefónico válido de 9 dígitos.");
		}

		// Dirección opcional, pero si se ingresó, debe ser válida
		if (dto.getDireccion() != null && !dto.getDireccion().trim().isEmpty()) {
			if (!dto.getDireccion().trim().matches(patronDireccion)) {
				throw new Exception("La dirección solo debe contener letras y espacios.");
			}
		}
		
		// Email opcional, pero si se ingresó, debe ser válido
		if (dto.getEmail() != null && !dto.getEmail().trim().isEmpty()) {
			if (!dto.getEmail().trim().matches(patronEmail)) {
				throw new Exception("Solo se permiten correos @gmail.com, @outlook.com o @hotmail.com.");
			}
		}
	}

	// Verifica que no sea nulo, no vacío y que cumpla el patrón
	private static boolean esTextoValido(String texto, String patron) {
		return texto != null && !texto.trim().isEmpty() && texto.trim().matches(patron);
	}
}
