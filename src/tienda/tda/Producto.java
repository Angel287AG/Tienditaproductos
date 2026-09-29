/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.tda;

/**
 *
 * @author angel
 */
public class Producto {

    // Atributos del TDA
    private String nombre;
    private float precio;
    private int cantidad;

    // 1. Constructor por defecto
    public Producto() {
        this.nombre = "Sin nombre";
        this.precio = 0.0f;
        this.cantidad = 1;
    }

    // 2. Constructor parametrizado con validaciones
    public Producto(String nombre, float precio, int cantidad) {
        setNombre(nombre);
        setPrecio(precio);
        setCantidad(cantidad);
    }

    // 3. Constructor copia
    public Producto(Producto copia) {
        this.nombre = copia.nombre;
        this.precio = copia.precio;
        this.cantidad = copia.cantidad;
    }

    // Métodos de acceso (Getters y Setters con encapsulamiento)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            this.nombre = "Sin nombre";
        }
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            this.precio = 0.0f;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        } else {
            this.cantidad = 1;
        }
    }

    //  Calcula subtotal sin impuestos
    public float calcularSubtotal() {
        return precio * cantidad;
    }

    // Calcula IVA (16%)
    public float calcularIVA() {
        return calcularSubtotal() * 0.16f;
    }

    // Calcula el total sumando IVA
    public float calcularTotal() {
        return calcularSubtotal() + calcularIVA();
    }

    // Método de Lógica 4 (RECURSIVO): Calcula total con 5% de descuento por unidad
    // Caso base: cuando n == 1, retorna el precio unitario con descuento.
    // Condición de avance: suma el precio descontado y llama a la función decrementando n.
    public float calcularTotalConDescuentoRecursivo(int n) {
        if (n <= 1) { 
            return precio * 0.95f;
        } else { 
            return (precio * 0.95f) + calcularTotalConDescuentoRecursivo(n - 1);
        }
    }

    @Override
    public String toString() {
        return nombre + " x" + cantidad + " = $" + calcularTotal();
    }
}