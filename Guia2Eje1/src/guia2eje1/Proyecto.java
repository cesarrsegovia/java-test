
package guia2eje1;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Proyecto {
    private String nombreProy;
    private int duracion;
    public int cantidadMiembros;
    public Miembro[] vmiembros;
    
    public Proyecto(){
        this.nombreProy="";
        this.duracion=0;
        this.cantidadMiembros=0;
        this.vmiembros=new Miembro[10];
    }
    
    public void registarProyecto(){
        this.duracion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion del proyecto:"));
        this.nombreProy=JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
        do{
            this.cantidadMiembros=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de miembros:(maximo 10)"));
            if(cantidadMiembros > 10){
                JOptionPane.showMessageDialog(null, "Maximo 10 miembros");
            }
        }while(cantidadMiembros < 1 || cantidadMiembros > 10);
        this.vmiembros=new Miembro[cantidadMiembros];
    }
    
    public void cargarMiembros() throws ParseException{
        for(int i = 0; i<cantidadMiembros;i++){
            vmiembros[i] = new Miembro();
            vmiembros[i].registrarMiembro(i);
        }
    }
    
    public void mostrarProyecto(){
        JOptionPane.showMessageDialog(null,"Nombre del proyecto: " + this.nombreProy
                + "\nDuracion del proyecto: " + this.duracion+ " dias" + "\nCantidad de miembros: " + cantidadMiembros);
    }
    
    public void listaRoles(){
        String rol = JOptionPane.showInputDialog("Ingrese un rol:");
        boolean encontrado = false;
        for(int i=0;i<cantidadMiembros;i++){
            if(vmiembros[i] != null){
                if(vmiembros[i].getRol().equalsIgnoreCase(rol)){
                encontrado = true;
                vmiembros[i].mostrarMiembros();
            }
            } else JOptionPane.showMessageDialog(null, "No hay miembros con este rol");
        }
        if(!encontrado){
            JOptionPane.showMessageDialog(null, "Rol no encontrado");
        }
    }
    
    public int cantidadMiembrosPorRol(String rol){
        int conteo=0;
        for(int i=0;i<cantidadMiembros;i++){
            if(vmiembros[i] != null){
                if(vmiembros[i].getRol().equalsIgnoreCase(rol)){
                conteo++;
                }
            }
        }
        return conteo;
    }
    
    public void buscarYEliminarMiembro(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre a buscar: ");
        boolean bandera = false;
        for(int i=0;i<cantidadMiembros && bandera==false;i++){
            if(vmiembros[i].getNombreape().equalsIgnoreCase(nombre)){
              int confirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar?", "Confirmacion", JOptionPane.YES_NO_OPTION);  
              if(confirmacion == JOptionPane.YES_OPTION){
                  bandera = true;
                  //Mover los miembros hacia la izquierda para llenar el espacio
                  for(int j=i;j<cantidadMiembros - 1;j++){
                      vmiembros[j] = vmiembros[j+1];
                  }
                  //Reducir la cantidad de miembros
                  vmiembros[cantidadMiembros - 1]=null;//Para limpieza
                  cantidadMiembros--;
                  JOptionPane.showMessageDialog(null, "Miembro del proyecto eliminado");
              }
            } break;
        }
        if(!bandera){
            JOptionPane.showMessageDialog(null, "No encontrado");
        }
    }
    
    public void buscarModificar() throws ParseException{
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre a buscar: ");
        boolean bandera = false;
        for(int i=0;i<cantidadMiembros;i++){
            if(vmiembros[i].getNombreape().equalsIgnoreCase(nombre)){
                bandera = true;
                int confirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if(confirmacion == JOptionPane.YES_OPTION){
                    vmiembros[i].modificarMiembro();
                    break;
                }
            }
        }
        
    }
    
    public void listarDesarrolladores(){
        for(int i= 0;i<cantidadMiembros;i++){
            
        }
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Miembro[] getVmiembros() {
        return vmiembros;
    }

    public void setVmiembros(Miembro[] vmiembros) {
        this.vmiembros = vmiembros;
    }
    
    
}
