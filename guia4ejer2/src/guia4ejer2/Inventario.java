
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
                    JOptionPane.showMessageDialog(null, vecelectro[i].mostrarProducto() + "\nPrecio total: " + vecelectro[i].precioFinal());
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
    
    //8.Buscar dispositivo electronico por su marca y modelo y modificar.
    public void modificarDispo(){
        String marca="", modelo="";
        do{
            marca=JOptionPane.showInputDialog("Ingrese marca a buscar:");
        }while(marca == null || marca.trim().isEmpty());
        do{
            modelo=JOptionPane.showInputDialog("Ingrese el modelo a buscar:");
        }while(modelo == null || modelo.trim().isEmpty());
        boolean ban=false;
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] != null && vecelectro[i].getMarca().equalsIgnoreCase(marca) && vecelectro[i].getModelo().equalsIgnoreCase(modelo)){
                int opcion = JOptionPane.showConfirmDialog(null, 
                    "¿Desea modificar este dispositivo?", 
                    "Confirmar modificación", 
                    javax.swing.JOptionPane.YES_NO_OPTION);
                if (opcion == javax.swing.JOptionPane.YES_OPTION) {
                    if(vecelectro[i] instanceof Smartphone){
                        Smartphone smbus=(Smartphone) vecelectro[i];
                        smbus.modificarSmart();
                        JOptionPane.showMessageDialog(null, "Dispositivo modificado correctamente.\n" + smbus.mostrarSmart());
                    }
                    else if(vecelectro[i] instanceof Laptop){
                        Laptop lapbus=(Laptop) vecelectro[i];
                        lapbus.modificarLaptop();
                        JOptionPane.showMessageDialog(null, "Dispositivo modificado correctamente.\n" + lapbus.mostrarLaptop());
                    }
                    else if(vecelectro[i] instanceof Tablet){
                        Tablet tabus=(Tablet) vecelectro[i];
                        tabus.modificarTablet();
                        JOptionPane.showMessageDialog(null, "Dispositivo modificado correctamente.\n" + tabus.mostrarTablet());
                    }
                }
                ban=true;
                break;
            }
        }
        if(!ban){
            JOptionPane.showMessageDialog(null, "Dispositivo no encontrado");
        }
    }
    
    //9.Buscar un dispositivo electronico por su marca y modelo y eliminarlo
    public void eliminarDispo(){
        String marca="", modelo="";
        do{
            marca=JOptionPane.showInputDialog("Ingrese marca a buscar:");
        }while(marca == null || marca.trim().isEmpty());
        do{
            modelo=JOptionPane.showInputDialog("Ingrese el modelo a buscar:");
        }while(modelo == null || modelo.trim().isEmpty());
        boolean ban=false;
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] != null && vecelectro[i].getMarca().equalsIgnoreCase(marca) && vecelectro[i].getModelo().equalsIgnoreCase(modelo)){
                JOptionPane.showMessageDialog(null, "Dispositivo encontrado:\n" + vecelectro[i].mostrarProducto());
                
                int opcion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea eliminar este dispositivo?",
                "Confirmar eliminacion",
                javax.swing.JOptionPane.YES_NO_OPTION);
                
                if (opcion == javax.swing.JOptionPane.YES_OPTION) {
                vecelectro[i] = null; // Eliminar el dispositivo
                JOptionPane.showMessageDialog(null, "Dispositivo eliminado correctamente.");
            }
                ban = true;
                break;
            }
        }
        if (!ban) {
        JOptionPane.showMessageDialog(null, "Dispositivo no encontrado");
    }
    }
    
    //10.Emitir un listado de todos los dispositivos electronicos que usen cargador rapido
    public void listadoDispCargaRapida(){
        boolean ban=false;
        String resultado="Dispositivos con cargador rapido:\n";
        for(int i=0;i<vecelectro.length;i++){
            if(vecelectro[i] != null && vecelectro[i].getCargador() != null){
                if(vecelectro[i].getCargador().getTipo_car().equalsIgnoreCase("rapido")){
                    resultado += vecelectro[i].getMarca() + " " +
                            vecelectro[i].getModelo() + " - Precio: $" + vecelectro[i].precioFinal() + "\n";
                    //resultado += vecelectro[i].mostrarProducto() + "\n";
                    //ban=true;
                }
                //if(ban){
                    //JOptionPane.showMessageDialog(null, resultado, "Listado con caragador rapido", JOptionPane.INFORMATION_MESSAGE);
                //}else{
                    //JOptionPane.showMessageDialog(null, "No se encontraron dispositivos con cargador rapido", "Resultado", JOptionPane.WARNING_MESSAGE);
                //}
            }
            JOptionPane.showMessageDialog(null, resultado);
        }
    }
    
    //11.Determinar la cantidad de productos electronicos con cargadores de cada potencia (6 cantidades)
    public void cantidadDispPotCarga(){
        int[] cantidades = new int[6]; // 5W, 10W, 15W, 25W, 45W, 100W
        for (int i = 0; i < vecelectro.length; i++) {
            if(vecelectro[i] != null){
            switch (vecelectro[i].getCargador().getPotencia_car()) {
                case 5: cantidades[0]++; break;
                case 10: cantidades[1]++; break;
                case 15: cantidades[2]++; break;
                case 25: cantidades[3]++; break;
                case 45: cantidades[4]++; break;
                case 100: cantidades[5]++; break;
            }
            }
        }
        
        JOptionPane.showMessageDialog(null,
            "Dispositivos por potencia de cargador:\n" +
            "5W: " + cantidades[0] + "\n" +
            "10W: " + cantidades[1] + "\n" +
            "15W: " + cantidades[2] + "\n" +
            "25W: " + cantidades[3] + "\n" +
            "45W: " + cantidades[4] + "\n" +
            "100W: " + cantidades[5]);
    }
    

    public Dispositivo[] getVecelectro() {
        return vecelectro;
    }

    public void setVecelectro(Dispositivo[] vecelectro) {
        this.vecelectro = vecelectro;
    }
    
    
}
