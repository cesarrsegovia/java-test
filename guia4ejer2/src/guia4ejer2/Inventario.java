
package guia4ejer2;

import javax.swing.JOptionPane;


public class Inventario {
    private Dispositivo[] vecelectro;

    public Inventario(Dispositivo[] vecelectro) {
        this.vecelectro = vecelectro;
    }
    
    public Inventario(){
        int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de dispositivos:"));
        String op="";
        vecelectro = new Dispositivo[n];
        for(int i=0;i<n;i++){
            op=JOptionPane.showInputDialog("Ingrese un tipo de producto:");
            switch(op){
                case "smartphone":
                    vecelectro[i]=new Smartphone();
                    ((Smartphone)vecelectro[i]).registrarProducto();
                    JOptionPane.showMessageDialog(null, ((Smartphone)vecelectro[i]).mostrarSmart());
                    break;
                
            }
        }
    }

    public Dispositivo[] getVecelectro() {
        return vecelectro;
    }

    public void setVecelectro(Dispositivo[] vecelectro) {
        this.vecelectro = vecelectro;
    }
    
    
}
