package pe.edu.uni.mecafab.util;

public class TransCodeUtil {
	
	public static String transCodeCliente(int id) {
		return String.format("CL-%07d", id);
	}
	
	public static String transCodeEmpleado(int id) {
		return String.format("EM-%07d", id);
	}
	
	public static String transCodePedido(int id) {
		return String.format("PD-%09d", id);
	}
	
}
