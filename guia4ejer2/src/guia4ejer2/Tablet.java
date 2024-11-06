
package guia4ejer2;

import javax.swing.JOptionPane;


public class Tablet extends Dispositivo{
    private String conectividad;

    public Tablet(String conectividad, String marca, String modelo, float precio_base, Cargador cargador) {
        super(marca, modelo, precio_base, cargador);
        this.conectividad = conectividad;
    }
    
    public Tablet(){
        super();
        this.conectividad="";
    }
    
    public void registrarProducto(){
        super.registrarProducto();
        do{
            this.conectividad=JOptionPane.showInputDialog("Ingrese tipo de conectividad (wifi/4g):");
        }while(!conectividad.equalsIgnoreCase("wifi") && !conectividad.equalsIgnoreCase("4g"));
    }
    
    public float precioFinal(){
        float precio=super.getPrecio_base();
        if(conectividad.equalsIgnoreCase("wifi")) precio *= 1.10;
        if(conectividad.equalsIgnoreCase("4g")) precio *= 1.20;
        return precio;
    }
    
    public String mostrarTablet(){
        String mos=super.mostrarProducto();
        mos+="\nTipo de conectividad: " + this.conectividad;
        mos+="\nPrecio final: " + this.precioFinal();
        return mos;
    }
    
    public void modificarTablet(){
        super.modificarDispositivo();
        do{
            this.conectividad=JOptionPane.showInputDialog("Ingrese tipo de conectividad (wifi/4g):");
        }while(!conectividad.equalsIgnoreCase("wifi") && !conectividad.equalsIgnoreCase("4g"));
    }

    public String getConectividad() {
        return conectividad;
    }

    public void setConectividad(String conectividad) {
        this.conectividad = conectividad;
    }
    
    
}
