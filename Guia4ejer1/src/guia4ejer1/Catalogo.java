
package guia4ejer1;

import javax.swing.JOptionPane;

public class Catalogo {
    private Producto[] vecprod;

    public Producto getVecprod(int pos) {
        return vecprod[pos];
    }
    
    public void setVecprod(Producto v, int pos) {
        this.vecprod[pos]=v;
    }
    
    public Catalogo(){
        int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de prod:"));
        String op="";
        vecprod=new Producto[n];
        for(int i=0;i<n;i++){
            op=JOptionPane.showInputDialog("Ingrese un tipo de producto:");
            switch(op){
                case "ropa":
                    vecprod[i]=new Ropa();
                    ((Ropa)vecprod[i]).registrarProducto(i);
                    JOptionPane.showMessageDialog(null, ((Ropa)vecprod[i]).mostrarRopa());
                    break;
                case "electronico":
                    vecprod[i]=new Electronico();
                    ((Electronico)vecprod[i]).registrarProducto(i);
                    JOptionPane.showMessageDialog(null, ((Electronico)vecprod[i]).mostrarElectro());
                    break;
                case "alimento":
                    vecprod[i]=new Alimento();
                    ((Alimento)vecprod[i]).registrarAlimento(i);
                    JOptionPane.showMessageDialog(null, ((Alimento)vecprod[i]).mostrarAlimento());
                    break;
            }
        }
    }
    
    public int largeVec(){
        return vecprod.length;
    }
    
    public void ordenarProductos(){
        for(int i=0;i<largeVec()-1;i++){
            for(int j=i+1;i<largeVec();j++){
                if(vecprod[i].precioFinal()<vecprod[j].precioFinal()){
                    Producto aux=vecprod[i];
                    vecprod[i]=vecprod[j];
                    vecprod[j]=aux;
                }
            }
        }
    }
    
     public String listadoProductos(int p){
        String a="";
        this.ordenarProductos();
        for(int i=0;i<largeVec();i++){
            if(p==1 && vecprod[i] instanceof Ropa){
                a+=((Ropa) vecprod[i]).mostrarProducto();
            }else if(p==2 && vecprod[i] instanceof Electronico){
                a+=((Electronico) vecprod[i]).mostrarProducto();
            }else if(p==3 && vecprod[i] instanceof Alimento){
                a+=((Alimento) vecprod[i]).mostrarProducto();
        }
        }
        
        return a;
    }
     
     public String ordenarOrigen(String ori){
        String a="";
        for(int i=0;i<largeVec();i++){
            if(vecprod[i] instanceof Electronico){
                if(((Electronico) vecprod[i]).getOrigen().equalsIgnoreCase(ori)) a+=((Electronico) vecprod[i]).mostrarProducto();
            }
        }
        
        return a;
    }
    
    public int busqueda(int p, int id){
        int ban=-1;
        for(int i=0;i<largeVec();i++){
            if(vecprod[i].getId()==id){
                if(p==1 && vecprod[i] instanceof Ropa){
                    ban=i;
                }else if(p==2 && vecprod[i] instanceof Electronico){
                    ban=i;
                }else if(p==3 && vecprod[i] instanceof Alimento){
                    ban=i;
                }
            }
        }
        return ban;
    } 
}
