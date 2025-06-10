package pedidosfarmacia.unir.view;

import pedidosfarmacia.unir.model.Pedido;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.*;

public class ResumenPedido extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public ResumenPedido(Pedido pedido, FormPedido origen) {
        setTitle("Pedido al distribuidor "  + pedido.getDistribuidor());
        setBounds(100, 100, 400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(224, 255, 255));
        setContentPane(contentPane);

        JLabel lblDistribuidor= new JLabel("Pedido al distribuidor " + pedido.getDistribuidor());
        lblDistribuidor.setBounds(20, 5, 400, 22);
        contentPane.add(lblDistribuidor);

        JLabel lblMedicamento = new JLabel(pedido.getCantidad() 
        		+ " unidades del " + pedido.getTipoMedicamento() 
        		+ " " + pedido.getNombreMedicamento());
        lblMedicamento.setBounds(20, 35, 400, 22);
        contentPane.add(lblMedicamento);

        JLabel lblFarmacia = new JLabel("<html>Para la farmacia situada en: <br>" 
        + pedido.getSucursal() + "</html>");
        lblFarmacia.setBounds(20, 55, 400, 60);
        contentPane.add(lblFarmacia);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.red);
        btnCancelar.setBounds(70, 135, 100, 30);
        btnCancelar.setForeground(Color.white);
        btnCancelar.addActionListener(e -> dispose());
        contentPane.add(btnCancelar);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBackground(new Color(34, 139, 34));
        btnEnviar.setForeground(Color.white);
        btnEnviar.setBounds(200, 135, 100, 30);
        btnEnviar.addActionListener(e -> {
            System.out.println("Pedido enviado");
            origen.limpiarFormulario();
            dispose();
        });
        contentPane.add(btnEnviar);
    }
}