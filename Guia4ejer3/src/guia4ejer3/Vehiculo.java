
package guia4ejer3;

import javax.swing.JOptionPane;


abstract public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio_fab;
    private float precio_base;
    private Propietario propietario;

    public Vehiculo(String marca, String modelo, int anio_fab, float precio_base, Propietario propietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio_fab = anio_fab;
        this.precio_base = precio_base;
        this.propietario = propietario;
    }
    
    public Vehiculo(){
        this.marca="";
        this.modelo="";
        this.anio_fab=0;
        this.precio_base=0;
        this.propietario=null;
    }
    
    public void registrar(){
        do{
            marca=JOptionPane.showInputDialog("Ingrese la marca:");
        }while(marca != null && marca.trim().isEmpty());
        do{
            modelo=JOptionPane.showInputDialog("Ingrese el modelo:");
        }while(modelo != null && modelo.trim().isEmpty());
        do{
            anio_fab=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricacion:"));
        }while(anio_fab < 0);
        do{
            precio_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio base:"));
        }while(precio_base < 0);
        propietario=new Propietario();
        propietario.registrarPropietario();
    }
    
    public String mostrar(){
        String mos="";
        mos+="\nMarca: " + this.marca;
        mos+="\nModelo: " + this.modelo;
        mos+="\nAño de fabricacion: " + this.anio_fab;
        mos+="\nPrecio base: " + this.precio_base;
        mos+="\nPropietario: " + propietario.getNombreape();
        mos+="\nDni: " + propietario.getDni();
        return mos;
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

    public int getAnio_fab() {
        return anio_fab;
    }

    public void setAnio_fab(int anio_fab) {
        this.anio_fab = anio_fab;
    }

    public float getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(float precio_base) {
        this.precio_base = precio_base;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
    
}
