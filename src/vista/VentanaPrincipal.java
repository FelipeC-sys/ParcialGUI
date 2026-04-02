package vista;

import javax.swing.*;
import controlador.Coordinador;
import modelo.ClienteDTO;
import modelo.CompraDTO;

public class VentanaPrincipal extends JFrame {

    private JTextField txtNombre, txtValor, txtCantidad;
    private JComboBox<String> comboTipo;
    private JLabel lblResultado;

    private Coordinador coordinador;

    public VentanaPrincipal() {

        coordinador = new Coordinador();

        setTitle("Sistema de Compras");
        setSize(420, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 🔹 Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 30, 180, 25);
        add(txtNombre);

        // 🔹 Tipo
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 70, 100, 25);
        add(lblTipo);

        comboTipo = new JComboBox<>(new String[] { "A", "B", "C" });
        
        // 🔹 Valor
        JLabel lblValor = new JLabel("Valor Unitario:");
        lblValor.setBounds(30, 110, 120, 25);
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(150, 110, 180, 25);
        add(txtValor);

        // 🔹 Cantidad
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(30, 150, 100, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(150, 150, 180, 25);
        add(txtCantidad);

        // 🔹 BOTONES
        JButton btnComprar = new JButton("Comprar");
        btnComprar.setBounds(30, 200, 100, 30);
        add(btnComprar);

        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(150, 200, 100, 30);
        add(btnMostrar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(270, 200, 100, 30);
        add(btnLimpiar);

        // 🔹 RESULTADO
        lblResultado = new JLabel("");
        lblResultado.setBounds(30, 250, 350, 40);
        add(lblResultado);

        // 🔥 EVENTOS
        btnComprar.addActionListener(e -> realizarCompra());
        btnMostrar.addActionListener(e -> mostrarDatos());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        setVisible(true);
    }

    // 🔥 COMPRA (usa Coordinador + BD)
    private void realizarCompra() {

        try {
            String nombre = txtNombre.getText();
            String tipo = comboTipo.getSelectedItem().toString();

            if (nombre.isEmpty() || txtValor.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
                lblResultado.setText("Complete todos los campos");
                return;
            }

            double valor = Double.parseDouble(txtValor.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            if (valor <= 0 || cantidad <= 0) {
                lblResultado.setText("Valores deben ser mayores a 0");
                return;
            }

            ClienteDTO cliente = new ClienteDTO(nombre, tipo);
            CompraDTO compra = new CompraDTO(cantidad, valor);

            String resultado = coordinador.realizarCompra(cliente, compra);

            lblResultado.setText(resultado);

        } catch (NumberFormatException e) {
            lblResultado.setText("Solo números en valor y cantidad");
        }
    }

    // 🔥 MOSTRAR DATOS
    private void mostrarDatos() {

        try {
            String nombre = txtNombre.getText();
            String tipo = comboTipo.getSelectedItem().toString();
            double valor = Double.parseDouble(txtValor.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            lblResultado.setText(
                    "Cliente: " + nombre +
                            " | Tipo: " + tipo +
                            " | Cant: " + cantidad +
                            " | Valor: " + valor);

        } catch (Exception e) {
            lblResultado.setText("Datos incompletos");
        }
    }

    // 🔥 LIMPIAR
    private void limpiarCampos() {
        txtNombre.setText("");
        txtValor.setText("");
        txtCantidad.setText("");
        comboTipo.setSelectedIndex(0);
        lblResultado.setText("Campos limpiados");
    }
}