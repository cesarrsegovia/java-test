
package guia4ejer2;

import javax.swing.JOptionPane;


public class Inventario {
    private Dispositivo[] vecelectro;
    private int cantidadDisp;

    public Inventario(Dispositivo[] vecelectro) {
        this.vecelectro = vecelectro;
    }
    
    public Inventario(){
        int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de dispositivos:"));
        String op="";
        vecelectro = new Dispositivo[n];
        for(int i=0;i<n;i++){
            do{
                op=JOptionPane.showInputDialog("Ingrese un tipo de producto:");
                switch(op){
                case "smartphone":
                    vecelectro[i]=new Smartphone();
                    ((Smartphone)vecelectro[i]).registrarProducto();
                    cantidadDisp++;
                    JOptionPane.showMessageDialog(null, ((Smartphone)vecelectro[i]).mostrarSmart());
                    break;
                case "laptop":
                    vecelectro[i]=new Laptop();
                    ((Laptop)vecelectro[i]).registrarProducto();
                    cantidadDisp++;
                    JOptionPane.showMessageDialog(null, ((Laptop)vecelectro[i]).mostrarLaptop());
                    break;
                case "tablet":
                    vecelectro[i]=new Tablet();
                    ((Tablet)vecelectro[i]).registrarProducto();
                    cantidadDisp++;
                    JOptionPane.showMessageDialog(null, ((Tablet)vecelectro[i]).mostrarTablet());
                    break;
            }
            }while(!op.equalsIgnoreCase("smartphone") && !op.equalsIgnoreCase("laptop") && !op.equalsIgnoreCase("tablet"));
        }
    }
    
    public void listaSmartphones(){
        Smartphone[] smartphones = new Smartphone[cantidadDisp];
        int cantSmart = 0;
        //filtrar smart
        for(int i=0;i<cantidadDisp;i++){
            if(vecelectro[i] instanceof Smartphone){
                smartphones[cantSmart] = (Smartphone) vecelectro[i];
                cantSmart++;
            }
        }
        //ordenar
        for(int i=0;i<cantSmart -1;i++){
            for(int j=0;j<cantSmart - i - 1;j++){
                if(smartphones[j].precioFinal()>smartphones[j+1].precioFinal()){
                    Smartphone aux = smartphones[j];
                    smartphones[j] = smartphones[j+1];
                    smartphones[j+1] = aux;
                }
            }
        }
        //mostrar
        for(int i=0;i<cantSmart;i++){
            smartphones[i].mostrarSmart();
        }
    }

    public Dispositivo[] getVecelectro() {
        return vecelectro;
    }

    public void setVecelectro(Dispositivo[] vecelectro) {
        this.vecelectro = vecelectro;
    }
    
    
}
