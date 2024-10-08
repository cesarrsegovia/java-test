
package guia3ejer1;

import javax.swing.JOptionPane;

public class Automovil extends Vehiculo{
    private int cantpuertas;
    
    Automovil(){
        super();
        cantpuertas=0;
    }
    
    public void registrarAutomovil(){
        super.registrarVehiculo();
        cantpuertas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de puertas:"));
    }
    
    public void mostrarAutomovil(){
        super.mostrarVehiculo();
        JOptionPane.showMessageDialog(null, "Cantidad de puertas: " + this.getCantpuertas());
    }
    
    public void modificarAutomovil(){
        super.modificarVehiculo();
        cantpuertas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de puertas:"));
    }

    public int getCantpuertas() {
        return cantpuertas;
    }

    public void setCantpuertas(int cantpuertas) {
        this.cantpuertas = cantpuertas;
    }
    
    
}
