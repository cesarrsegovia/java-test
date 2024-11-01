
package guia4ejer2;

import javax.swing.JOptionPane;


public class Cargador {
    private String tipo_car;
    private int potencia_car;

    public Cargador(String tipo_car, int potencia_car) {
        this.tipo_car = tipo_car;
        this.potencia_car = potencia_car;
    }
    
    public Cargador(){
        this.tipo_car="";
        this.potencia_car=0;
    }
    
    public void registrarCargador(){
        do{
        tipo_car=JOptionPane.showInputDialog("indique tipo de cargador:");
        }while(!tipo_car.equalsIgnoreCase("rapido") && !tipo_car.equalsIgnoreCase("estandar"));
        do{
            potencia_car=Integer.parseInt(JOptionPane.showInputDialog("Ingrese potencia cargador(5/10/15/25/45/100"));
        }while(potencia_car != 5 && potencia_car != 10 && potencia_car !=15 && potencia_car != 25 && potencia_car !=45 && potencia_car != 100);
    }
    
    

    public String getTipo_car() {
        return tipo_car;
    }

    public void setTipo_car(String tipo_car) {
        this.tipo_car = tipo_car;
    }

    public int getPotencia_car() {
        return potencia_car;
    }

    public void setPotencia_car(int potencia_car) {
        this.potencia_car = potencia_car;
    }
    
    
}
