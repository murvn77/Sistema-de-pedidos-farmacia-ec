package pedidosfarmacia.unir.application;

import pedidosfarmacia.unir.controller.*;
import pedidosfarmacia.unir.view.*;

public class Ejecutar {

	public static void main(String[] args) {
            FormPedido vista = new FormPedido();
            new PedidoController(vista);
            vista.setVisible(true);
    }
}