package pedidosfarmacia.unir.controller;

import pedidosfarmacia.unir.model.Pedido;
import pedidosfarmacia.unir.view.FormPedido;
import pedidosfarmacia.unir.view.ResumenPedido;

import javax.swing.*;

public class PedidoController {

    private FormPedido vista;

    public PedidoController(FormPedido vista) {
        this.vista = vista;
        inicializarEventos();
    }
    
    public FormPedido getVista() {
        return vista;
    }

    private void inicializarEventos() {
        vista.getBotonConfirmar().addActionListener(e -> {
            String nombreMed = vista.getNombreMedicamento().getText().trim();
            String tipo = (String) vista.getTipoMedicamento().getSelectedItem();
            String cantidadTexto = vista.getCantidad().getText().trim();

            if (nombreMed.isEmpty() || !nombreMed.matches(".*[a-zA-Z0-9].*")) {
                JOptionPane.showMessageDialog(vista, "El nombre del medicamento es inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int cantidadInt;
            try {
                cantidadInt = Integer.parseInt(cantidadTexto);
                if (cantidadInt <= 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (tipo == null || tipo.equals("Seleccione...")) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un tipo de medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!vista.isDistribuidorSeleccionado()) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un distribuidor.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!vista.isSucursalSeleccionada()) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar al menos una sucursal.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Pedido pedido = new Pedido(
                nombreMed,
                tipo,
                cantidadInt,
                vista.getDistribuidorSeleccionado(),
                vista.getFarmaciasSeleccionadas()
            );
            
            new ResumenPedido(pedido, vista).setVisible(true);
        });

        vista.getBotonBorrar().addActionListener(e -> vista.limpiarFormulario());
    }
}