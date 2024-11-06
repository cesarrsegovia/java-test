
package guia4ejer2;

import javax.swing.JOptionPane;


abstract public class Dispositivo {
    private String marca;
    private String modelo;
    private float precio_base;
    private Cargador cargador;

    public Cargador getCargador() {
        return cargador;
    }

    public void setCargador(Cargador cargador) {
        this.cargador = cargador;
    }

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
        do{
            this.marca=JOptionPane.showInputDialog("Ingrese la marca:");
        }while(marca == null || marca.trim().isEmpty());
        do{
            this.modelo=JOptionPane.showInputDialog("Ingrese el modelo:");
        }while(modelo == null || modelo.trim().isEmpty());
        this.precio_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio base:"));
        cargador=new Cargador();
        cargador.registrarCargador();
    }
    
    public String mostrarProducto(){
        String a="";
        a+="\nModelo: " + this.modelo;
        a+="\nMarca: " + this.marca;
        a+="\nP. Base: " + this.precio_base;
        a+="\nPotencia cargador: " + cargador.getPotencia_car();
        a+="\nTipo cargador: " + cargador.getTipo_car();
        return a;
    }
    
    public void modificarDispositivo(){
        do{
            this.marca=JOptionPane.showInputDialog("Ingrese la marca:");
        }while(marca == null || marca.trim().isEmpty());
        do{
            this.modelo=JOptionPane.showInputDialog("Ingrese el modelo:");
        }while(modelo == null || modelo.trim().isEmpty());
        this.precio_base=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio base:"));
        cargador=new Cargador();
        cargador.registrarCargador();
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
