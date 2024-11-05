
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
                    JOptionPane.showMessageDialog(null, vecelectro[i].mostrarProducto()+"\nPrecio total: " + vecelectro[i].precioFinal());
                }
            }
        }
    }
    
    public void listaLaptop(){
        Dispositivo aux=null;
        for(int i=0;i<vecelectro.length-1;i++){
            for(int j=i+1;j<vecelectro.length;j++){
                if(vecelectro[i] instanceof Laptop && vecelectro[j] instanceof Laptop){
                    if(vecelectro[i].precioFinal()<vecelectro[j].precioFinal()){
                        aux=vecelectro[i];
                        vecelectro[i]=vecelectro[j];
                        vecelectro[j]=aux;
                    }
                }
            }
        }
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] instanceof Laptop){
                if(vecelectro[i].getPrecio_base()!=0){
                    JOptionPane.showMessageDialog(null, vecelectro[i].mostrarProducto()+"\nPrecio total: " + vecelectro[i].precioFinal());
                }
            }
        }
    }
    
    public void listaTablet(){
        Dispositivo aux=null;
        for(int i=0;i<vecelectro.length-1;i++){
            for(int j=i+1;j<vecelectro.length;j++){
                if(vecelectro[i] instanceof Tablet && vecelectro[j] instanceof Tablet){
                    if(vecelectro[i].precioFinal()<vecelectro[j].precioFinal()){
                        aux=vecelectro[i];
                        vecelectro[i]=vecelectro[j];
                        vecelectro[j]=aux;
                    }
                }
            }
        }
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] instanceof Tablet){
                if(vecelectro[i].getPrecio_base()!=0){
                    JOptionPane.showMessageDialog(null, vecelectro[i].mostrarProducto()+"\nPrecio total: " + vecelectro[i].precioFinal());
                }
            }
        }
    }
    
    public void cantidadCamaras(){
        int cf=0, ct=0;
        for(int i=0; i<vecelectro.length;i++){
            if(vecelectro[i] instanceof Smartphone){
                Smartphone s=(Smartphone) vecelectro[i];
                if(s.getCamara_frontal().equalsIgnoreCase("si")) cf++;
                if(s.getCamara_to().equalsIgnoreCase("si")) ct++;
            }
        }
        JOptionPane.showMessageDialog(null, "Smartphones con camara frontal: " + cf + "\nSmartphones con camara teleobjetivo " + ct);
    }
    
    public void laptopPantallaGrandeBarata(){
        Laptop lapeco=null;
        float precioMinimo = Float.MAX_VALUE;
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] instanceof Laptop){
                Laptop aux=(Laptop) vecelectro[i];
                if(aux.getTamanio_pant().equalsIgnoreCase("grande")){
                    float precioActual=aux.precioFinal();
                    if(precioActual<precioMinimo){
                        precioMinimo=precioActual;
                        lapeco=aux;
                    }
                }
            }
        }
        if(lapeco!=null){
            JOptionPane.showMessageDialog(null, "Laptop de menor precio con pantalla grande: " + lapeco.mostrarLaptop() + "\nPrecio final: " + lapeco.precioFinal());
        }else{
            JOptionPane.showMessageDialog(null, "No se encontraron laptops con pantalla grande.");
        }
    }
    
    //6.Cantidad de laptops por cada tipo de memoria ram.
    public void laptopXRam(){
        int cantidades[]=new int[4];
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] instanceof Laptop){
                Laptop aux=(Laptop) vecelectro[i];
                switch(aux.getRam()){
                    case 4: cantidades[0]++; break;
                    case 8: cantidades[1]++; break;
                    case 16: cantidades[2]++; break;
                    case 32: cantidades[3]++; break;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Laptops por RAM:\n" + 
                "4GB: " + cantidades[0] + "\n8GB: " + cantidades[1] + "\n16GB: " + cantidades[2] + "\n32GB: " + cantidades[3]);
    }
    
    //7.Mostrar datos de todas las tablets con conectividad 4g. incluir datos del cargador.
    public void tablets4g(){
        String mensaje = "Tablets 4G:\n";
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] instanceof Tablet){
                Tablet tab=(Tablet) vecelectro[i];
                if(tab.getConectividad().equalsIgnoreCase("4g")){
                    mensaje += tab.mostrarTablet();
                }
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public Dispositivo[] getVecelectro() {
        return vecelectro;
    }

    public void setVecelectro(Dispositivo[] vecelectro) {
        this.vecelectro = vecelectro;
    }
    
    
}
