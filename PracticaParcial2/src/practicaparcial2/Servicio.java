
package practicaparcial2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Servicio {
    private Producto[] vecorreo;

    public Servicio(Producto[] vecorreo) {
        this.vecorreo = vecorreo;
    }
    
    public Servicio() throws ParseException{
        int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de paquetes:"));
        String op="";
        vecorreo = new Producto[n];
        for(int i=0;i<n;i++){
            do{
                op=JOptionPane.showInputDialog("Ingrese un tipo de producto:");
                switch(op){
                    case "sobre":
                        vecorreo[i] = new Sobre();
                        ((Sobre)vecorreo[i]).registrarProducto(i);
                        if (vecorreo == null || vecorreo.length == 0) {
                        JOptionPane.showMessageDialog(null,((Sobre)vecorreo[i]).mostrarSobre());
                        }
                        break;
                    case "encomienda":
                        vecorreo[i] = new Encomienda();
                        ((Encomienda)vecorreo[i]).registrarProducto(i);
                        JOptionPane.showMessageDialog(null,((Encomienda)vecorreo[i]).mostrarEncomienda());
                        break;
                }
            }while(!op.equalsIgnoreCase("sobre") && !op.equalsIgnoreCase("encomienda"));
        }
    }
    
    public void listadoSobresPrimerSem(){
        if (vecorreo == null || vecorreo.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados en el sistema.");
            return;
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //definir fechas del primer semestre
        Date primerDiaSemestre=new Date(124,0,1); //1 de enero de 2024
        Date ultimoDiaSemestre=new Date(124,5,30); //30 de junio de 2024
        String resultado="Sobre recibidos en el primer semestre:\n";
        
        for(int i=0;i<vecorreo.length;i++){
            if(vecorreo[i] != null && vecorreo[i] instanceof Sobre){
                Transporte transp=((Sobre)vecorreo[i]).getTransp();
                if(transp != null){
                Date fechaRecepcion=transp.getFecha_rec();
                if(fechaRecepcion.compareTo(primerDiaSemestre) >= 0 && fechaRecepcion.compareTo(ultimoDiaSemestre) <= 0){
                    resultado += "\nCodigo: " + vecorreo[i].getCodigo();
                    resultado += "\nFecha: " + formato.format(fechaRecepcion);
                    resultado += "\nImporte a pagar: " + ((Sobre) vecorreo[i]).precioFinal() + "\n";
                }
                }
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    //2.Emitir listado de todos los destinos de encomienda con peso mayor o igual a 15kg(sin duplicados)
    public void listadoDestinosPeso(){
        String resultado="Listado de encomiendas mayores a 15kg: \n";
        boolean ban=false;
        for(int i=0;i<vecorreo.length;i++){
            if(vecorreo[i] instanceof Encomienda){
                Encomienda encomienda=(Encomienda)vecorreo[i];
                if(encomienda.getPeso()>15){
                    ban=true;
                    resultado+=encomienda.mostrarEncomienda()+"\n";
                }
            }
        }
        if(!ban){
            JOptionPane.showMessageDialog(null, "No hay encomiendas mayores a 15kg.");
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    //3.eliminar todos los sobres enviados con el servicio "simple"
    public void eliminarSobreSimple(){
        boolean ban=false;
        for(int i=0;i<vecorreo.length;i++){
            if(vecorreo[i] instanceof Sobre && ((Sobre)vecorreo[i]).getServicio().equalsIgnoreCase("simple")){
                ban=true;
                ((Sobre) vecorreo[i]).setCodigo(0);
                ((Sobre) vecorreo[i]).setDescrip("");
                ((Sobre) vecorreo[i]).setCiudad_ori("");
                ((Sobre) vecorreo[i]).setCiudad_des("");
                ((Sobre) vecorreo[i]).setEmisor("");
                ((Sobre) vecorreo[i]).setReceptor("");
                ((Sobre) vecorreo[i]).setServicio("");
                ((Sobre) vecorreo[i]).setTransp(null);
            }
        }
        if (ban) {
            JOptionPane.showMessageDialog(null, "Todos los sobres de servicio 'simple' han sido eliminados.");
        } else {
            JOptionPane.showMessageDialog(null, "No hay sobres de servicio 'simple' para eliminar.");
        }
    }
    
    //4.mes aniversario, bonificacion de 10% sobre el precio final a aquellos paquetes mayores a 2000. Emitir listado de datos de los paquetes beneficiados.
    public void bonificacionAniv(){
        String resultado="Enconmiendas con bonificacion por aniversario:\n";
        boolean beneficio=false;
        for(int i=0;i<vecorreo.length;i++){
            if(vecorreo[i] instanceof Encomienda){
                Encomienda enco=(Encomienda)vecorreo[i];
                
                if(enco.getMonto_aseg()>2000){
                    float precioOriginal=enco.precioFinal();
                    float nuevoPrecio=(float) (precioOriginal*0.90);
                    
                    resultado+="\nCodigo: " + enco.getCodigo();
                    resultado+="\nMonto asegurado: " + enco.getMonto_aseg();
                    resultado+="\nImporte origial: " + precioOriginal + " con el descuento: " + nuevoPrecio;
                    beneficio=true;
                }
            }
        }
        if (!beneficio) {
        resultado += "No hay encomiendas con monto asegurado mayor a 2000 en el mes actual.";
    }

        JOptionPane.showMessageDialog(null, resultado);
    }

    public Producto[] getVecorreo() {
        return vecorreo;
    }

    public void setVecorreo(Producto[] vecorreo) {
        this.vecorreo = vecorreo;
    }
    
    
}
