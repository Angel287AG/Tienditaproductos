/*
 * Subclase ProductoPerecedero
 * @author Angel Angelino González
 */

package tienda.tda;

public class ProductoPerecedero extends Producto {

    private int diasCaducidad;

    public ProductoPerecedero(String nombre, float precio, int cantidad, int diasCaducidad) {
        super(nombre, precio, cantidad);
        this.diasCaducidad = diasCaducidad;
    }

    public int getDiasCaducidad() {
        return diasCaducidad;
    }

    public void setDiasCaducidad(int diasCaducidad) {
        this.diasCaducidad = diasCaducidad;
    }

    public boolean estaPorCaducar() {
        if (diasCaducidad <= 3) {
            return true;
        } else {
            return false;
        }
    }
}