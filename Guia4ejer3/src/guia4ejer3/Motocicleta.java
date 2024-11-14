
package guia4ejer3;

import javax.swing.JOptionPane;


public class Motocicleta extends Vehiculo{
    private int cilindrada;

    public Motocicleta(int cilindrada, String marca, String modelo, int anio_fab, float precio_base, Propietario propietario) {
        super(marca, modelo, anio_fab, precio_base, propietario);
        this.cilindrada = cilindrada;
    }
    
    public Motocicleta(){
        super();
        this.cilindrada=0;
    }
    
    public void registrar(){
        super.registrar();
        do{
            cilindrada=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cilindrada: (150/300/500/650)"));
        }while(cilindrada != 150 && cilindrada != 300 && cilindrada != 500 && cilindrada != 650);
    }
    
    public String mostrarMoto(){
        String mos=super.mostrar();
        mos+="\nCilindrada: " + this.cilindrada;
        mos+="\nPrecio final: " + this.precioFinal();
        return mos;
    }
    
    public float precioFinal(){
        float precio=super.getPrecio_base();
        switch(cilindrada){
            case 150: precio+=5000; break;
            case 300: precio+=10000; break;
            case 500: precio+=15000; break;
            case 650: precio+=20000; break;
        }
        return precio;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    
}
