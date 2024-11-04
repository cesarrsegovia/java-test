
package guia4ejer2;

import javax.swing.JOptionPane;


public class Inventario {
    private Dispositivo[] vecelectro;
    //private int cantidadDisp;

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
                    //cantidadDisp++;
                    JOptionPane.showMessageDialog(null, ((Smartphone)vecelectro[i]).mostrarSmart());
                    break;
                case "laptop":
                    vecelectro[i]=new Laptop();
                    ((Laptop)vecelectro[i]).registrarProducto();
                    //cantidadDisp++;
                    JOptionPane.showMessageDialog(null, ((Laptop)vecelectro[i]).mostrarLaptop());
                    break;
                case "tablet":
                    vecelectro[i]=new Tablet();
                    ((Tablet)vecelectro[i]).registrarProducto();
                    //cantidadDisp++;
                    JOptionPane.showMessageDialog(null, ((Tablet)vecelectro[i]).mostrarTablet());
                    break;
            }
            }while(!op.equalsIgnoreCase("smartphone") && !op.equalsIgnoreCase("laptop") && !op.equalsIgnoreCase("tablet"));
        }
    }
    
    public void listaSmartphones(){
        Dispositivo aux=null;
        for(int i=0;i<vecelectro.length-1;i++){
            for(int j=i+1;j<vecelectro.length;j++){
                if(vecelectro[i] instanceof Smartphone && vecelectro[j] instanceof Smartphone){
                    if(vecelectro[i].precioFinal()<vecelectro[j].precioFinal()){
                        aux=vecelectro[i];
                        vecelectro[i]=vecelectro[j];
                        vecelectro[j]=aux;
                    }
                }
            }
        }
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] instanceof Smartphone){
                if(vecelectro[i].getPrecio_base()!=0){
                    JOptionPane.showMessageDialog(null, vecelectro[i].mostrarProducto()+"\nprecio total: " + vecelectro[i].precioFinal());
                }
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
