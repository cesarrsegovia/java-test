
package guia4ejer2;

import javax.swing.JOptionPane;


public class Smartphone extends Dispositivo{
    private int almacenamiento;
    private String camara_frontal;
    private String camara_to;

    public Smartphone(int almacenamiento, String camara_frontal, String camara_to, String marca, String modelo, float precio_base, Cargador cargador) {
        super(marca, modelo, precio_base, cargador);
        this.almacenamiento = almacenamiento;
        this.camara_frontal = camara_frontal;
        this.camara_to = camara_to;
    }

    public Smartphone() {
        super();
        this.almacenamiento = 0;
        this.camara_frontal = "";
        this.camara_to = "";
    }
    
    public void registrarProducto(){
        super.registrarProducto();
        do{
            this.almacenamiento=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de almacenamiento (128/256/512)"));
        }while(almacenamiento != 128 && almacenamiento != 256 && almacenamiento != 512);
        do{
            this.camara_frontal=JOptionPane.showInputDialog("Tiene camara frontal?");
        }while(!camara_frontal.equalsIgnoreCase("si") && !camara_frontal.equalsIgnoreCase("no"));
        do{
            this.camara_to=JOptionPane.showInputDialog("Tiene camara teleobjetivo?");
        }while(!camara_to.equalsIgnoreCase("si") && !camara_to.equalsIgnoreCase("no"));
    }
    
    public float precioFinal(){
        float precio=super.getPrecio_base();
        switch(almacenamiento){
            case 128: precio += 2000; break;
            case 256: precio += 4000; break;
            case 512: precio += 6000; break;
        }
        if(this.camara_frontal.equalsIgnoreCase("si")) precio += 5000;
        if(this.camara_to.equalsIgnoreCase("si")) precio += 5000;
        return precio;
    }
    
    public String mostrarSmart(){
        String mos=super.mostrarProducto();
        mos+="\nAlmacenamiento: " + this.almacenamiento + " GB";
        mos+="\nCamara frontal: " + this.camara_frontal;
        mos+="\nCamara teleobjetivo: " + this.camara_to;
        mos+="\nPrecio final: " + this.precioFinal();
        return mos;
    }
    
    public void modificarSmart(){
        super.modificarDispositivo();
        do{
            this.almacenamiento=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de almacenamiento (128/256/512)"));
        }while(almacenamiento != 128 && almacenamiento != 256 && almacenamiento != 512);
        do{
            this.camara_frontal=JOptionPane.showInputDialog("Tiene camara frontal?");
        }while(!camara_frontal.equalsIgnoreCase("si") && !camara_frontal.equalsIgnoreCase("no"));
        do{
            this.camara_to=JOptionPane.showInputDialog("Tiene camara teleobjetivo?");
        }while(!camara_to.equalsIgnoreCase("si") && !camara_to.equalsIgnoreCase("no"));
    }
    

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getCamara_frontal() {
        return camara_frontal;
    }

    public void setCamara_frontal(String camara_frontal) {
        this.camara_frontal = camara_frontal;
    }

    public String getCamara_to() {
        return camara_to;
    }

    public void setCamara_to(String camara_to) {
        this.camara_to = camara_to;
    }
    
    
}
