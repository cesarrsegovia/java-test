
package guia4ejer3;

import javax.swing.JOptionPane;


public class Listado {
    private Vehiculo[] vecveh;

    public Listado(Vehiculo[] vecveh) {
        this.vecveh = vecveh;
    }
    
    public Listado(){
        int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de vehiculos:"));
        String op="";
        vecveh = new Vehiculo[n];
        for(int i=0;i<vecveh.length;i++){
            do{
                op=JOptionPane.showInputDialog("Ingrese un tipo de vehiculo:");
                switch(op){
                    case "automovil":
                        vecveh[i]=new Automovil();
                        ((Automovil) vecveh[i]).registrar();
                        if(vecveh[i] != null){
                            JOptionPane.showMessageDialog(null, ((Automovil)vecveh[i]).mostrarAuto());
                        }
                        break;
                    case "motocicleta":
                        vecveh[i]=new Motocicleta();
                        ((Motocicleta)vecveh[i]).registrar();
                        if(vecveh[i] != null){
                            JOptionPane.showMessageDialog(null, ((Motocicleta)vecveh[i]).mostrarMoto());
                        }
                        break;
                }
            }while(!op.equalsIgnoreCase("automovil") && !op.equalsIgnoreCase("motocicleta"));
        }
    }
    
    public void listadoAutos(){
        Vehiculo aux=null;
        for(int i=0;i<vecveh.length;i++){
            for(int j=i+1;j<vecveh.length;j++){
                if(vecveh[i] instanceof Automovil && vecveh[j] instanceof Automovil){
                    if(vecveh[i].precioFinal()<vecveh[j].precioFinal()){
                        aux=vecveh[i];
                        vecveh[i]=vecveh[j];
                        vecveh[j]=aux;
                    }
                }
            }
        }
        for(int i=0;i<vecveh.length;i++){
            if(vecveh[i] instanceof Automovil){
                if(vecveh[i].getPrecio_base()!=0){
                    JOptionPane.showMessageDialog(null, vecveh[i].mostrar() + "\nPrecio final: " + vecveh[i].precioFinal());
                }
            }
        }
    }
    
    public void mostrarXmarcaYmodelo(){
        boolean ban=false;
        String busmarca="";
        int buspuertas=0;
        busmarca=JOptionPane.showInputDialog("Ingerse la marca a buscar:");
        buspuertas=Integer.parseInt(JOptionPane.showInputDialog("Ingerse cantidad de puertas:"));
        for(int i=0;i<vecveh.length;i++){
            if(vecveh[i] instanceof Automovil){
                Automovil aux=((Automovil)vecveh[i]);
                if(aux.getMarca().equalsIgnoreCase(busmarca) && aux.getPuertas()==buspuertas){
                    ban=true;
                    JOptionPane.showMessageDialog(null, aux.mostrarAuto());
                }
            }
        }
        if(!ban){
            JOptionPane.showMessageDialog(null, "No se encontraron vehiculos con esos datos.");
        }
    }
    
    public void listadoMotos(){
        Vehiculo aux=null;
        for(int i=0;i<vecveh.length;i++){
            for(int j=i+1;j<vecveh.length;j++){
                if(vecveh[i] instanceof Motocicleta && vecveh[j] instanceof Motocicleta){
                    if(vecveh[i].precioFinal()<vecveh[j].precioFinal()){
                        aux=vecveh[i];
                        vecveh[i]=vecveh[j];
                        vecveh[j]=aux;
                    }
                }
            }
        }
        for(int i=0;i<vecveh.length;i++){
            if(vecveh[i] instanceof Motocicleta){
                if(vecveh[i].getPrecio_base()!=0){
                    JOptionPane.showMessageDialog(null, vecveh[i].mostrar() + "\nPrecio final: " + vecveh[i].precioFinal());
                }
            }
        }
    }
    
    //4.infnormar los datos de la motobicicleta mas cara.
    public void motoCara(){
        Motocicleta motocara=null;
        float precioMaximo=Float.MIN_VALUE;
        for(int i=0;i<vecveh.length;i++){
            if(vecveh[i] instanceof Motocicleta){
                Motocicleta aux=(Motocicleta) vecveh[i];
                float precioActual=aux.precioFinal();
                if(precioActual > precioMaximo){
                    precioMaximo=precioActual;
                    motocara=aux;
                }
            }
        }
        if(motocara!=null){
            JOptionPane.showMessageDialog(null, "Moto mas cara: " + motocara.mostrarMoto() + "\nPrecio final: " + motocara.precioFinal());
        }else{
            JOptionPane.showMessageDialog(null, "No se encontraron motos.");
        }
    }
    
    public void autoBarato(){
        Automovil autoeco=null;
        float precioMinimo=Float.MAX_VALUE;
        for(int i=0;i<vecveh.length;i++){
            if(vecveh[i] instanceof Automovil){
                Automovil aux=(Automovil)vecveh[i];
                float precioActual=aux.precioFinal();
                if(precioActual < precioMinimo){
                    precioMinimo=precioActual;
                    autoeco=aux;
                }
            }
        }
        if(autoeco!=null){
            JOptionPane.showMessageDialog(null, "Auto mas barato: " + autoeco.mostrarAuto() + "\nPrecio final: " + autoeco.precioFinal());
        }else{
            JOptionPane.showMessageDialog(null, "No se encontraron autos.");
        }
    }
    
    //6.emitir un listado de motos ordenado por cantidad de cilindradas.
    public void cantCilindradas(){
        
    }
    
    //7.ingresar nombre y apellido y listar los datos del vehiculo vendido.
    public void mostrarVehVend(){
        boolean ban=false;
        String buscnom=JOptionPane.showInputDialog("Ingrese nombre y apellido a buscar:");
        for(int i=0;i<vecveh.length;i++){
                if(vecveh[i] != null){
                    String nombreProp=vecveh[i].getPropietario().getNombreape();
                    if(nombreProp.equalsIgnoreCase(buscnom)){
                        ban=true;
                        if(vecveh[i] instanceof Automovil){
                            JOptionPane.showMessageDialog(null, ((Automovil) vecveh[i]).mostrarAuto());
                        } else if( vecveh[i] instanceof Motocicleta){
                            JOptionPane.showMessageDialog(null, ((Motocicleta) vecveh[i]).mostrarMoto());
                        }
                    }
                }
            }
        
        if(!ban){
            JOptionPane.showMessageDialog(null, "Error.");
        }
    }
    
    //8.ingresar marca y modelo y eliminar todos los autos con esas caracteristicas.
    public void eliminarAuto(){
        boolean ban=false;
        String buscmarca="", buscmodelo="";
        do{
            buscmarca=JOptionPane.showInputDialog("Ingrese el modelo buscado:");
        }while(buscmarca == null || buscmarca.trim().isEmpty());
        do{
            buscmodelo=JOptionPane.showInputDialog("Ingrese el modelo:");
        }while(buscmodelo == null || buscmodelo.trim().isEmpty());
        for(int i=0;i<vecveh.length;i++){
            if(vecveh[i] != null){
                if(vecveh[i] instanceof Automovil){
                    Automovil auxa=((Automovil)vecveh[i]);
                    if(auxa.getMarca().equalsIgnoreCase(buscmarca) && auxa.getModelo().equalsIgnoreCase(buscmodelo)){
                        ban=true;
                        JOptionPane.showMessageDialog(null, "Automovil encontrado:\n" + auxa.mostrarAuto());
                
                        int opcion = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea eliminar este Automovil?",
                        "Confirmar eliminacion",
                        javax.swing.JOptionPane.YES_NO_OPTION);

                        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
                        vecveh[i] = null; // Eliminar el dispositivo
                        JOptionPane.showMessageDialog(null, "Automovil eliminado correctamente.");
                    }
                }
            }
        }
    }
        if (!ban) {
        JOptionPane.showMessageDialog(null, "Automovil no encontrado");
        }
    }
    public Vehiculo[] getVecveh() {
        return vecveh;
    }

    public void setVecveh(Vehiculo[] vecveh) {
        this.vecveh = vecveh;
    }
    
    
}
