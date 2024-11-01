
package guia4ejer2;

import javax.swing.JOptionPane;


public class Laptop extends Dispositivo{
    private String tamanio_pant;
    private int ram;

    public Laptop(String tamanio_pant, int ram, String marca, String modelo, float precio_base, Cargador cargador) {
        super(marca, modelo, precio_base, cargador);
        this.tamanio_pant = tamanio_pant;
        this.ram = ram;
    }
    
    public Laptop(){
        super();
        this.tamanio_pant="";
        this.ram=0;
    }
    
    public void registrarProducto(){
        super.registrarProducto();
        do{
            this.tamanio_pant=JOptionPane.showInputDialog("Ingresar tamaño de pantalla (pequeña/mediana/grande):");
        }while(!tamanio_pant.equalsIgnoreCase("pequeña") && !tamanio_pant.equalsIgnoreCase("mediana") && !tamanio_pant.equalsIgnoreCase("grande"));
        do{
            this.ram=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de memoria RAM:"));
        }while(ram != 4 && ram != 8 && ram != 16 && ram != 32);
    }
    
    public float precioFinal(){
        float precio=super.getPrecio_base();
        if(tamanio_pant.equalsIgnoreCase("mediana")) precio *= 1.10;
        if(tamanio_pant.equalsIgnoreCase("grande")) precio *= 1.20;
        switch(ram){
            case 4: precio += 2000; break;
            case 8: precio += 4000; break;
            case 16: precio += 6000; break;
            case 32: precio += 8000; break;
        }
        return precio;
    }
    
    public String mostrarLaptop(){
        String mos=super.mostrarProducto();
        mos+="\nTamaño de pantalla: " + this.tamanio_pant;
        mos+="\nCantidad de memoria RAM: " + this.ram + " GB.";
        mos+="\nPrecio final: " + this.precioFinal();
        return mos;
    }

    public String getTamanio_pant() {
        return tamanio_pant;
    }

    public void setTamanio_pant(String tamanio_pant) {
        this.tamanio_pant = tamanio_pant;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
    
    
}
