package pe.edu.uni.mecafab.util;

public interface StringUtil {
	
	// limpia caracteres vacios
	static String limpiar(String texto) {
		return (texto == null) ? null : texto.trim();
	}
	
	// Coloca el primer caracter en mayuscula
	static String capitalizar(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			return texto;
		}
		texto = texto.trim().toLowerCase();
		return texto.substring(0, 1).toUpperCase() + texto.substring(1);
	}
	
	// Hace ambas
	static String limCap(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			return texto;
		}
		texto = texto.trim().toLowerCase();
		return texto.substring(0, 1).toUpperCase() + texto.substring(1);
	}
	
	// Para limpiar cajas de texto que almacenan int o double
	// Ideal para VIEW, y posiblemente fronted (html)
	static int limpiarInt(String texto) throws NumberFormatException {
		return Integer.parseInt(limpiar(texto));
	}

	static double limpiarDouble(String texto) throws NumberFormatException {
		return Double.parseDouble(limpiar(texto));
	}
	
}
