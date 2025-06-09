package pedidosfarmacia.unir.application;

import pedidosfarmacia.unir.controller.*;
import pedidosfarmacia.unir.view.*;

public class Ejecutar {

	public static void main(String[] args) {
            FormPedido vista = new FormPedido();
            PedidoController pedidoController = new PedidoController(vista);
            pedidoController.getVista().setVisible(true);
            
    }
}