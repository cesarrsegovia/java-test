
package guia3ejer1;

import javax.swing.JOptionPane;


public class Bicicleta extends Vehiculo{
    private int cambios;
    
    Bicicleta(){
        super();
        cambios=0;
    }
    
    public void registrarBicicleta(){
        super.registrarVehiculo();
        cambios=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de cambios:"));
    }
    
    public void mostrarBicicleta(){
        super.mostrarVehiculo();
        JOptionPane.showMessageDialog(null, "Cantidad de cambios: " + this.getCambios());
    }

    public int getCambios() {
        return cambios;
    }

    public void setCambios(int cambios) {
        this.cambios = cambios;
    }
    
    
}
