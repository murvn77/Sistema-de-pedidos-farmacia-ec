package pedidosfarmacia.unir.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pedidosfarmacia.unir.modelos.Pedido;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class FormPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreMedicamento;
	private JTextField cantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPedido frame = new FormPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String distribuidorSeleccionado(JRadioButton rdbtnCofarma, JRadioButton rdbtnCemefar, JRadioButton rdbtnEmpsephar) {
	    if (rdbtnCofarma.isSelected()) return "Cofarma";
	    if (rdbtnCemefar.isSelected()) return "Cemefar";
	    if (rdbtnEmpsephar.isSelected()) return "Empsephar";
	    return "";
	}    
	
	private String farmaciasSeleccionadas(JCheckBox sedePrincipal, JCheckBox sedeSecundaria) {
	    boolean principal = sedePrincipal.isSelected();
	    boolean secundaria = sedeSecundaria.isSelected();
	    StringBuilder direccion = new StringBuilder("Para la farmacia situada en ");

	    if (principal && secundaria) {
	        direccion.append("Calle de la Rosa n. 28 y Calle Alcazabilla n. 3");
	    } else if (principal) {
	        direccion.append("Calle de la Rosa n. 28");
	    } else if (secundaria) {
	        direccion.append("Calle Alcazabilla n. 3");
	    } else {
	        direccion = new StringBuilder("No se ha seleccionado ninguna farmacia");
	    }

	    return direccion.toString();
	}


	/**
	 * Create the frame.
	 */
	public FormPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formulario de solicitud de medicamentos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(107, 10, 258, 22);
		contentPane.add(lblNewLabel);		
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del medicamento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 54, 272, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de medicamento");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 131, 272, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 86, 272, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Distribuidor");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 194, 272, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sucursal");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 249, 272, 22);
		contentPane.add(lblNewLabel_5);
		
		nombreMedicamento = new JTextField();
		nombreMedicamento.setBounds(292, 57, 204, 22);
		contentPane.add(nombreMedicamento);
		nombreMedicamento.setColumns(10);
		
		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(296, 91, 204, 22);
		contentPane.add(cantidad);
		
		JComboBox<String> tipoMedicamento = new JComboBox<String>();		
		tipoMedicamento.addItem("Seleccione...");
		tipoMedicamento.addItem("Analgésico");
		tipoMedicamento.addItem("Analéptico");
		tipoMedicamento.addItem("Anestésico");
		tipoMedicamento.addItem("Antiácido");
		tipoMedicamento.addItem("Antidepresivo");
		tipoMedicamento.addItem("Antibiótico");
		tipoMedicamento.setBounds(292, 133, 204, 21);
		contentPane.add(tipoMedicamento);

		
		JRadioButton rdbtnCofarma = new JRadioButton("Cofarma");
		rdbtnCofarma.setBounds(33, 222, 103, 21);
		contentPane.add(rdbtnCofarma);
		
		JRadioButton rdbtnCemefar = new JRadioButton("Cemefar");
		rdbtnCemefar.setBounds(168, 222, 103, 21);
		contentPane.add(rdbtnCemefar);
		
		JRadioButton rdbtnEmpsephar = new JRadioButton("Empsephar");
		rdbtnEmpsephar.setBounds(273, 222, 103, 21);
		contentPane.add(rdbtnEmpsephar);
		
		ButtonGroup groupRdbtn = new ButtonGroup();
		groupRdbtn.add(rdbtnCofarma);
		groupRdbtn.add(rdbtnCemefar);
		groupRdbtn.add(rdbtnEmpsephar);
		
		JCheckBox sedePrincipal = new JCheckBox("Principal");
		sedePrincipal.setBounds(10, 289, 93, 21);
		contentPane.add(sedePrincipal);
		
		JCheckBox sedeSecundaria = new JCheckBox("Secundaria");
		sedeSecundaria.setBounds(107, 289, 93, 21);
		contentPane.add(sedeSecundaria);		
		
		JButton botonConfimar = new JButton("Confirmar");
		botonConfimar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreMed = nombreMedicamento.getText().trim();
                String tipo = (String) tipoMedicamento.getSelectedItem();
                String cantidadTexto = cantidad.getText().trim();

                if (nombreMed.isEmpty() || !nombreMed.matches(".*[a-zA-Z0-9].*")) {
                    JOptionPane.showMessageDialog(contentPane, "El nombre del medicamento es inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int cantidadInt = 0;
                try {
                    cantidadInt = Integer.parseInt(cantidadTexto);
                    if (cantidadInt <= 0) throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "La cantidad debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (tipo == null || tipo.equals("Seleccione...")) {
                    JOptionPane.showMessageDialog(contentPane, "Debe seleccionar un tipo de medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
          
                if (!rdbtnCofarma.isSelected() && !rdbtnCemefar.isSelected() && !rdbtnEmpsephar.isSelected()) {
                    JOptionPane.showMessageDialog(contentPane, "Debe seleccionar un distribuidor.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!sedePrincipal.isSelected() && !sedeSecundaria.isSelected()) {
                    JOptionPane.showMessageDialog(contentPane, "Debe seleccionar al menos una sucursal.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

         
                String farmacias = farmaciasSeleccionadas(sedePrincipal, sedeSecundaria);
                
                String tipoMed = (String) tipoMedicamento.getSelectedItem();

                Pedido pedido = new Pedido(
                    nombreMed,
                    tipoMed,
                    cantidadInt,
                    distribuidorSeleccionado(rdbtnCofarma, rdbtnCemefar, rdbtnEmpsephar),
                    farmacias.trim()
                );
                
                ResumenPedido resumen = new ResumenPedido(pedido);
            	resumen.setVisible(true);
            }
        });

		botonConfimar.setBounds(71, 392, 85, 21);
		contentPane.add(botonConfimar);
		
		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreMedicamento.setText("");
				cantidad.setText("");
				tipoMedicamento.setSelectedIndex(0);
				groupRdbtn.clearSelection();
				sedePrincipal.setSelected(false);
				sedeSecundaria.setSelected(false);
			}
		});
		botonBorrar.setBounds(216, 392, 85, 21);
		contentPane.add(botonBorrar);
		
		
       
	}
}
