package pe.edu.uni.mecafab.util;

public interface StringUtil {
	
	// limpia caracteres vacios
	public static String limpiar(String texto) {
		return (texto == null) ? null : texto.trim();
	}
	
	// Coloca el primer caracter en mayuscula
	public static String capitalizar(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			return texto;
		}
		texto = texto.trim().toLowerCase();
		return texto.substring(0, 1).toUpperCase() + texto.substring(1);
	}
	
	// Hace ambas
	public static String limCap(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			return texto;
		}
		texto = texto.trim().toLowerCase();
		return texto.substring(0, 1).toUpperCase() + texto.substring(1);
	}
	
}
