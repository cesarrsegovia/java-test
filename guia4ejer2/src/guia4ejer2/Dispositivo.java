
package guia4ejer2;

import javax.swing.JOptionPane;


abstract public class Dispositivo {
    private String marca;
    private String modelo;
    private float precio_base;
    private Cargador cargador;

    public Dispositivo(String marca, String modelo, float precio_base, Cargador cargador) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio_base = precio_base;
        this.cargador=cargador;
    }
    
    public Dispositivo(){
        this.marca="";
        this.modelo="";
        this.precio_base=0;
        this.cargador=cargador;
    }
    
    public void registrarProducto(){
        this.marca=JOptionPane.showInputDialog("Ingrese la marca:");
        this.modelo=JOptionPane.showInputDialog("Ingrese el modelo:");
        this.precio_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio base:"));
        this.cargador = Cargador.registrarCargador();
    }
    
    public String mostrarProducto(){
        String a="";
        a+="\nModelo: " + this.modelo;
        a+="\nMarca: " + this.marca;
        a+="\nP. Base: " + this.precio_base;
        return a;
    }
    
    abstract float precioFinal();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(float precio_base) {
        this.precio_base = precio_base;
    }
    
    
}
