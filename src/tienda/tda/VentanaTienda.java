/*
 * Interfaz Gráfica
 * @author Angel Angelino González
 */
package tienda.tda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTienda extends JFrame {

    private JTextField txtNombre, txtPrecio, txtCantidad, txtDias;
    private JTextArea areaSalida;
    private JButton btnCalcular, btnLimpiar;

    public VentanaTienda() {
        setTitle("Tienda - TDA");
        setSize(450, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 5, 5));

        // Formulario
        add(new JLabel(" Nombre del producto:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel(" Precio unitario:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel(" Cantidad:"));
        txtCantidad = new JTextField();
        add(txtCantidad);

        add(new JLabel(" Días para caducar:"));
        txtDias = new JTextField("10");
        add(txtDias);

        btnCalcular = new JButton("Calcular");
        btnLimpiar = new JButton("Limpiar");
        add(btnCalcular);
        add(btnLimpiar);

        areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida));

        JLabel lblAutor = new JLabel("Autor: Angel Angelino González");
        add(lblAutor);

        // Evento botón calcular al estilo tradicional
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nom = txtNombre.getText();
                    float prec = Float.parseFloat(txtPrecio.getText());
                    int cant = Integer.parseInt(txtCantidad.getText());
                    int dias = Integer.parseInt(txtDias.getText());

                    ProductoPerecedero p = new ProductoPerecedero(nom, prec, cant, dias);

                    String caduca = "NO";
                    if (p.estaPorCaducar()) {
                        caduca = "SÍ";
                    }

                    String res = "=== RESULTADO ===\n"
                            + "Producto: " + p.getNombre() + "\n"
                            + "Subtotal: $" + p.calcularSubtotal() + "\n"
                            + "IVA (16%): $" + p.calcularIVA() + "\n"
                            + "Total: $" + p.calcularTotal() + "\n"
                            + "Total c/desc (Recursivo): $" + p.calcularTotalConDescuentoRecursivo(cant) + "\n"
                            + "¿Por caducar?: " + caduca;

                    areaSalida.setText(res);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ingresa datos válidos.");
                }
            }
        });

        // Evento botón limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtPrecio.setText("");
                txtCantidad.setText("");
                txtDias.setText("10");
                areaSalida.setText("");
            }
        });
    }

    public static void main(String[] args) {
        VentanaTienda v = new VentanaTienda();
        v.setVisible(true);
    }
}