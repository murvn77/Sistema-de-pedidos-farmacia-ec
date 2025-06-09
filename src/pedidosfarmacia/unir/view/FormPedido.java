package pedidosfarmacia.unir.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.*;

public class FormPedido extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nombreMedicamento;
    private JTextField cantidad;
    private JComboBox<String> tipoMedicamento;
    private ButtonGroup rdbtnGrupo;
    private JRadioButton rdbtnCofarma, rdbtnCemefar, rdbtnEmpsephar;
    private JCheckBox sedePrincipal, sedeSecundaria;
    private JButton botonConfirmar, botonBorrar;

    public FormPedido() {
        setTitle("Formulario de Pedidos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 499);
        
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(224, 255, 255));
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("<html>Formulario de solicitud<br>de medicamentos</html>");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(50, 2, 300, 50);  
        contentPane.add(lblTitulo);


        JLabel lblNombre = new JLabel("Nombre del medicamento");
        lblNombre.setBounds(10, 54, 200, 22);
        contentPane.add(lblNombre);

        nombreMedicamento = new JTextField();
        nombreMedicamento.setBounds(20, 84, 200, 22);
        contentPane.add(nombreMedicamento);
        
        JLabel lblCantidad = new JLabel("Cantidad");
        lblCantidad.setBounds(10, 114, 200, 22);
        contentPane.add(lblCantidad);
        

        cantidad = new JTextField();
        cantidad.setBounds(20, 144, 200, 22);
        contentPane.add(cantidad);

        JLabel lblTipoMedicamento = new JLabel("Tipo de medicamento");
        lblTipoMedicamento.setBounds(10, 174, 200, 22);
        contentPane.add(lblTipoMedicamento);
        
        tipoMedicamento = new JComboBox<>();
        tipoMedicamento.setBounds(20, 204, 200, 22);
		tipoMedicamento.addItem("Seleccione...");
		tipoMedicamento.addItem("Analgésico");
		tipoMedicamento.addItem("Analéptico");
		tipoMedicamento.addItem("Anestésico");
		tipoMedicamento.addItem("Antiácido");
		tipoMedicamento.addItem("Antidepresivo");
		tipoMedicamento.addItem("Antibiótico");
        contentPane.add(tipoMedicamento);

        JLabel lblDistribuidor = new JLabel("Distribuidor");
        lblDistribuidor.setBounds(10, 234, 200, 22);
        contentPane.add(lblDistribuidor);
        
        rdbtnCofarma = new JRadioButton("Cofarma");
        rdbtnCofarma.setBounds(20, 260, 100, 22);
        rdbtnCofarma.setBackground(new Color(224, 255, 255));
        contentPane.add(rdbtnCofarma);
        rdbtnCemefar = new JRadioButton("Cemefar");
        rdbtnCemefar.setBounds(20, 286, 100, 22);
        rdbtnCemefar.setBackground(new Color(224, 255, 255));
        contentPane.add(rdbtnCemefar);
        rdbtnEmpsephar = new JRadioButton("Empsephar");
        rdbtnEmpsephar.setBounds(20, 312, 100, 22);
        rdbtnEmpsephar.setBackground(new Color(224, 255, 255));
        contentPane.add(rdbtnEmpsephar);

        rdbtnGrupo = new ButtonGroup();
        rdbtnGrupo.add(rdbtnCofarma);
        rdbtnGrupo.add(rdbtnCemefar);
        rdbtnGrupo.add(rdbtnEmpsephar);
        
        JLabel lblSucursal = new JLabel("Sucursal");
        lblSucursal.setBounds(10, 342, 200, 22);
        contentPane.add(lblSucursal);
        
        sedePrincipal = new JCheckBox("Principal");
        sedePrincipal.setBounds(20, 368, 100, 22);
        sedePrincipal.setBackground(new Color(224, 255, 255));
        contentPane.add(sedePrincipal);
        sedeSecundaria = new JCheckBox("Secundaria");
        sedeSecundaria.setBounds(170, 368, 100, 22);
        sedeSecundaria.setBackground(new Color(224, 255, 255));
        contentPane.add(sedeSecundaria);


        botonBorrar = new JButton("Borrar");
        botonBorrar.setBounds(20, 410, 100, 25);
        botonBorrar.setBackground(Color.red);
        botonBorrar.addActionListener(e -> limpiarFormulario());
        contentPane.add(botonBorrar);
        
        botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setBounds(170, 410, 100, 25);
        botonConfirmar.setBackground(Color.green);
        contentPane.add(botonConfirmar);
    }

    public JTextField getNombreMedicamento() { return nombreMedicamento; }
    public JTextField getCantidad() { return cantidad; }
    public JComboBox<String> getTipoMedicamento() { return tipoMedicamento; }
    public JButton getBotonConfirmar() { return botonConfirmar; }
    public JButton getBotonBorrar() { return botonBorrar; }

    public boolean isDistribuidorSeleccionado() {
        return rdbtnCofarma.isSelected() || rdbtnCemefar.isSelected() || rdbtnEmpsephar.isSelected();
    }

    public String getDistribuidorSeleccionado() {
        if (rdbtnCofarma.isSelected()) return "Cofarma";
        if (rdbtnCemefar.isSelected()) return "Cemefar";
        if (rdbtnEmpsephar.isSelected()) return "Empsephar";
        return "";
    }

    public boolean isSucursalSeleccionada() {
        return sedePrincipal.isSelected() || sedeSecundaria.isSelected();
    }

    public String getFarmaciasSeleccionadas() {
        if (sedePrincipal.isSelected() && sedeSecundaria.isSelected())
            return "Calle de la Rosa n. 28 y Calle Alcazabilla n. 3";
        else if (sedePrincipal.isSelected())
            return "Calle de la Rosa n. 28";
        else if (sedeSecundaria.isSelected())
            return "Calle Alcazabilla n. 3";
        else
            return "";
    }

    public void limpiarFormulario() {
        nombreMedicamento.setText("");
        cantidad.setText("");
        tipoMedicamento.setSelectedIndex(0);
        rdbtnGrupo.clearSelection();
        sedePrincipal.setSelected(false);
        sedeSecundaria.setSelected(false);
    }
}