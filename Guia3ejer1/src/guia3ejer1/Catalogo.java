
package guia3ejer1;

import javax.swing.JOptionPane;

public class Catalogo {
    Vehiculo vecvehiculo[];
    
    Catalogo(){
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de vehiculos:"));
        vecvehiculo=new Vehiculo[n];
        //inicializamos vector
        for(int i=0;i<vecvehiculo.length;i++){
            vecvehiculo[i]=null;
        }
        for(int i=0;i<vecvehiculo.length;i++){
            int op=0;
            op=Integer.parseInt(JOptionPane.showInputDialog("Que vehiculo desea registrar? 1-Automovil 2-Bicicleta"));
            if(op==1){
                //creamos instancia de automovil
                Automovil a = new Automovil();
                //llamamos al metodo registrar
                a.registrarAutomovil();
                //guardamos en la posicion i del vector
                vecvehiculo[i]=a;
            }
            else{
                Bicicleta b = new Bicicleta();
                b.registrarBicicleta();
                vecvehiculo[i]=b;
            }
        }
    }
    
    public void mostrarCatalogo(){
        Automovil auxa=null;
        Bicicleta auxb=null;
        for(int i=0;i<vecvehiculo.length;i++){
            if(vecvehiculo[i] instanceof Automovil){
                auxa=(Automovil)vecvehiculo[i];
                auxa.mostrarAutomovil();
            }
            if(vecvehiculo[i] instanceof Bicicleta){
                auxb=(Bicicleta)vecvehiculo[i];
                auxb.mostrarBicicleta();
            }
        }
    }
}
