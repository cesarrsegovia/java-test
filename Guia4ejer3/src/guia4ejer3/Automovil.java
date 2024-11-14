
package guia4ejer3;

import javax.swing.JOptionPane;


public class Automovil extends Vehiculo{
    private int puertas;

    public Automovil(int puertas, String marca, String modelo, int anio_fab, float precio_base, Propietario propietario) {
        super(marca, modelo, anio_fab, precio_base, propietario);
        this.puertas = puertas;
    }
    
    public Automovil(){
        super();
        this.puertas=0;
    }
    
    public void registrar(){
        super.registrar();
        do{
            puertas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de puertas: 3 o 5"));
        }while(puertas != 3 && puertas != 5);
    }
    
    public String mostrarAuto(){
        String mos=super.mostrar();
        mos+="\nCantidad de puertas: " + this.puertas;
        mos+="\nPrecio final: " + this.precioFinal();
        return mos;
    }
    
    public float precioFinal(){
        float precio=super.getPrecio_base();
        if(puertas == 3) precio *= 0.95;
        if(puertas == 5) precio *= 1.10;
        return precio;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }
    
    
}
