/*
 * TDA Producto
 * @author Angel Angelino González
 */
package tienda.tda;

public class Producto {

    private String nombre;
    private float precio;
    private int cantidad;

    public Producto() {
        this.nombre = "Sin nombre";
        this.precio = 0.0f;
        this.cantidad = 1;
    }

    public Producto(String nombre, float precio, int cantidad) {
        if (nombre != null && !nombre.equals("")) {
            this.nombre = nombre;
        } else {
            this.nombre = "Sin nombre";
        }

        if (precio >= 0) {
            this.precio = precio;
        } else {
            this.precio = 0.0f;
        }

        if (cantidad > 0) {
            this.cantidad = cantidad;
        } else {
            this.cantidad = 1;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        }
    }

   
    public float calcularSubtotal() {
        return precio * cantidad;
    }

    public float calcularIVA() {
        return calcularSubtotal() * 0.16f;
    }

    public float calcularTotal() {
        return calcularSubtotal() + calcularIVA();
    }

    // Método recursivo
    public float calcularTotalConDescuentoRecursivo(int cant) {
        if (cant <= 1) {
            return precio * 0.95f;
        }
        return (precio * 0.95f) + calcularTotalConDescuentoRecursivo(cant - 1);
    }
}