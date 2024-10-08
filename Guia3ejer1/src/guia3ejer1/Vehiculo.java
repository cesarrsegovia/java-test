
package guia3ejer1;

import javax.swing.JOptionPane;


public class Vehiculo {
    private String denominacion;
    private String marca;
    private int stock;
    private float precio;
    
    Vehiculo(){
        denominacion="";
        marca="";
        stock=0;
        precio=0f;
    }
    
    public void registrarVehiculo(){
        denominacion=JOptionPane.showInputDialog("Ingrese la denominacion del vehiculo:");
        marca=JOptionPane.showInputDialog("Ingrese la marca:");
        stock=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de stock:"));
        precio=Float.parseFloat(JOptionPane.showInputDialog("Ingrese precio del vehiculo:"));
    }
    
    public void mostrarVehiculo(){
        JOptionPane.showMessageDialog(null, "Denominacion: " + this.getDenominacion() + "\nMarca: " + this.getMarca()
        + "\nCantidad stock: " + this.getStock() + "\nPrecio: " + this.getPrecio());
    }
    
    public void modificarVehiculo(){
        denominacion=JOptionPane.showInputDialog("Ingrese la denominacion del vehiculo:");
        marca=JOptionPane.showInputDialog("Ingrese la marca:");
        stock=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de stock:"));
        precio=Float.parseFloat(JOptionPane.showInputDialog("Ingrese precio del vehiculo:"));
    }                                                                                                                                                                          

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
