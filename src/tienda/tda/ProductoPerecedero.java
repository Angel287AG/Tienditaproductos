/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.tda;

/**
 *
 * @author angel
 */
public class ProductoPerecedero extends Producto {

    private int diasParaCaducar;

    public ProductoPerecedero(String nombre, float precio, int cantidad, int diasParaCaducar) {
        super(nombre, precio, cantidad);
        this.diasParaCaducar = diasParaCaducar;
    }

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    public void setDiasParaCaducar(int diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }

    public boolean estaPorCaducar() {
        return diasParaCaducar <= 3;
    }

    @Override
    public String toString() {
        return super.toString() + " | Caduca en: " + diasParaCaducar + " días";
    }
}