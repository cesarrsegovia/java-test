
package guia4ejer3;

import javax.swing.JOptionPane;


public class Propietario {
    private int dni;
    private String nombreape;

    public Propietario(int dni, String nombreape) {
        this.dni = dni;
        this.nombreape = nombreape;
    }
    
    public Propietario(){
        this.dni=0;
        this.nombreape="";
    }
    
    public void registrarPropietario(){
        do{
            this.dni=Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de dni:"));
        }while(this.dni < 0);
        do{
            this.nombreape=JOptionPane.showInputDialog("Ingrese nombre y apellido:");
        }while(this.nombreape != null && this.nombreape.trim().isEmpty());
    }
    

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreape() {
        return nombreape;
    }

    public void setNombreape(String nombreape) {
        this.nombreape = nombreape;
    }
    
    
}
