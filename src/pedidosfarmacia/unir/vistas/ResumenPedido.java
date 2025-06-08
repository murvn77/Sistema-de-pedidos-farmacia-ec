package pedidosfarmacia.unir.vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pedidosfarmacia.unir.modelos.Pedido;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ResumenPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public ResumenPedido(Pedido pedido) {
	    setTitle("Pedido al distribuidor " + pedido.getDistribuidor());
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 450, 300);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JLabel lblTitulo = new JLabel("Pedido al distribuidor " + pedido.getDistribuidor());
	    lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblTitulo.setBounds(10, 20, 300, 20);
	    contentPane.add(lblTitulo);

	    JLabel lblResumen = new JLabel(pedido.getCantidad() + " unidades del " + pedido.getTipoMedicamento().toLowerCase() + " " + pedido.getNombreMedicamento());
	    lblResumen.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblResumen.setBounds(10, 60, 400, 20);
	    contentPane.add(lblResumen);

	    JLabel lblDireccion = new JLabel(pedido.getFarmacias());
	    lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblDireccion.setBounds(10, 100, 400, 52);
	    contentPane.add(lblDireccion);

	    JButton btnCancelar = new JButton("Cancelar");
	    btnCancelar.addActionListener(e -> dispose());
	    btnCancelar.setBounds(42, 192, 85, 21);
	    contentPane.add(btnCancelar);

	    JButton btnEnviar = new JButton("Enviar");
	    btnEnviar.addActionListener(e -> System.out.println("Pedido enviado"));
	    btnEnviar.setBounds(211, 192, 85, 21);
	    contentPane.add(btnEnviar);
	}
	
	
	
}
