package pe.edu.uni.mecafab.prueba;

import pe.edu.uni.mecafab.controller.PedidoController;
import pe.edu.uni.mecafab.dto.PedidoConsultaDto;

public class PruebaD3_ListarPedidos {
    public static void main(String[] args) {
        try {
            PedidoController controller = new PedidoController();
            System.out.println("Pedidos para asignar:");
            for (PedidoConsultaDto p : controller.procesarListarPedido()) {
                System.out.println(
                    p.getIdPedido() + " | " +
                    p.getIdCliente()+ " | " +
                    p.getCliente() + " | " +
                    p.getDescripcion()+ " | " +
                    p.getEstado()
                );
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
