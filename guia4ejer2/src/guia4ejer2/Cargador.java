
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
    
    public static Cargador registrarCargador(){
        String tipo_car=JOptionPane.showInputDialog("indique tipo de cargador:");
        int potencia_car=Integer.parseInt(JOptionPane.showInputDialog("indique la potencia en watts:"));
        return new Cargador(tipo_car,potencia_car);
    }
    
    public void mostrarCargador(){
        JOptionPane.showMessageDialog(null, "Tipo cargador: " + this.tipo_car + "\nPotencia: " + this.potencia_car + " W.");
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
