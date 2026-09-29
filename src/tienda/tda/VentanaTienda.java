/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.tda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTienda extends JFrame {

    private JTextField txtNombre, txtPrecio, txtCantidad, txtDias;
    private JTextArea areaResultado;
    private JButton btnCalcular, btnLimpiar;

    public VentanaTienda() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Tienda - TDA");
        setSize(500, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Formulario de entrada
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 8, 8));

        panelFormulario.add(new JLabel(" Nombre del producto:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel(" Precio unitario ($):"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel(" Cantidad:"));
        txtCantidad = new JTextField();
        panelFormulario.add(txtCantidad);

        panelFormulario.add(new JLabel(" Días para caducar:"));
        txtDias = new JTextField("10");
        panelFormulario.add(txtDias);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnCalcular = new JButton("Calcular");
        btnLimpiar = new JButton("Limpiar");
        panelBotones.add(btnCalcular);
        panelBotones.add(btnLimpiar);

        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.add(panelFormulario, BorderLayout.CENTER);
        panelNorte.add(panelBotones, BorderLayout.SOUTH);

        add(panelNorte, BorderLayout.NORTH);

        // Área de resultados
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Identificación del Autor en la GUI (Requisito obligatorio)
        JLabel lblAutor = new JLabel("Autor: Angel Angelino González", SwingConstants.CENTER);
        lblAutor.setFont(new Font("SansSerif", Font.BOLD, 12));
        add(lblAutor, BorderLayout.SOUTH);

        // Eventos
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }

    private void calcular() {
        try {
            String nombre = txtNombre.getText();
            float precio = Float.parseFloat(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());
            int dias = Integer.parseInt(txtDias.getText());

            ProductoPerecedero producto = new ProductoPerecedero(nombre, precio, cantidad, dias);

            String reporte = "=== RESUMEN DE COMPRA ===\n"
                    + "Producto: " + producto.getNombre() + "\n"
                    + "Subtotal: $" + String.format("%.2f", producto.calcularSubtotal()) + "\n"
                    + "IVA (16%): $" + String.format("%.2f", producto.calcularIVA()) + "\n"
                    + "Total sin descuento: $" + String.format("%.2f", producto.calcularTotal()) + "\n"
                    + "Total Recursivo (con 5% desc): $" + String.format("%.2f", producto.calcularTotalConDescuentoRecursivo(cantidad)) + "\n"
                    + "¿Próximo a caducar?: " + (producto.estaPorCaducar() ? "SÍ (Atención)" : "NO");

            areaResultado.setText(reporte);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingresa valores numéricos válidos en precio, cantidad y días.",
                    "Error de Entrada",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtDias.setText("10");
        areaResultado.setText("");
        txtNombre.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaTienda().setVisible(true));
    }
}