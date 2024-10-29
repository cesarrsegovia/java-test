
package guia4ejer1;

import javax.swing.JOptionPane;

abstract public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private float precio_base;
    
    public Producto(int id, String nombre, String marca, float precio_base) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio_base = precio_base;
    }
    
    public Producto() {
        this.id = 0;
        this.nombre = "";
        this.marca = "";
        this.precio_base = 0;
    }
    
    public void registrarProducto(int i){
        this.id=i;
        this.nombre=JOptionPane.showInputDialog("Ingrese el nombre:");
        this.marca=JOptionPane.showInputDialog("Ingrese la marca:");
        this.precio_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio base:"));
    }
    
    public String mostrarProducto(){
        String a="";
        a+="\nId: " + this.id;
        a+="\nNombre: " + this.nombre;
        a+="\nMarca: " + this.marca;
        a+="\nP. Base: " + this.precio_base;
        return a;
    }
    
    abstract float precioFinal();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(float precio_base) {
        this.precio_base = precio_base;
    }
}
