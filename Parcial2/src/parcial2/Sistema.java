
package parcial2;

import java.text.ParseException;
import javax.swing.JOptionPane;

public class Sistema {
    Alumno[] vecsistema;

    public Sistema(Alumno[] vecsistema) {
        this.vecsistema = vecsistema;
    }
    
    public Sistema() throws ParseException{
    int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad alumnos a registrar: "));
    String op="";
    vecsistema=new Alumno[n];
    for(int i=0;i<vecsistema.length;i++){
        do{
            op=JOptionPane.showInputDialog("Ingrese tipo de modalidad;");
            switch(op){
                case "presencial":
                    vecsistema[i]=new Presencial();
                    ((Presencial)vecsistema[i]).registrar();
                    JOptionPane.showMessageDialog(null, ((Presencial)vecsistema[i]).mostrar());
                    break;
                case "online":
                    vecsistema[i]=new Online();
                    ((Online)vecsistema[i]).registrar();
                    JOptionPane.showMessageDialog(null, ((Online)vecsistema[i]).mostrar());
                    break;
            }
        }while(!op.equalsIgnoreCase("presencial") && !op.equalsIgnoreCase("online"));
    }
}
    public void listadoAlumnosModalidad(){
        String resultado="Datos del alumno:\n";
        for(int i=0;i<vecsistema.length;i++){
            if(vecsistema[i] instanceof Presencial){
                Presencial alumnos=((Presencial)vecsistema[i]);
                resultado+="\n" + ((Presencial)vecsistema[i]).mostrar();
            }
            if(vecsistema[i] instanceof Online){
                Online alumnos=((Online)vecsistema[i]);
                resultado+="\n" + ((Online)vecsistema[i]).mostrar();
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    public void busqModificacion() throws ParseException{
        String nom=JOptionPane.showInputDialog("Ingrese el nombre y apellido que desea buscar");
        boolean ban=false;
        int nuevasis=0;
        String tps="";
        for(int i=0;i<vecsistema.length;i++){
            if(vecsistema[i].getNombreape().equalsIgnoreCase(nom)){
                ban=true;
                if(vecsistema[i] instanceof Presencial){
                    Presencial modif = ((Presencial) vecsistema[i]);
                    nuevasis=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo registro de asistencia:"));
                    modif.setRegis_asis(nuevasis);
                    JOptionPane.showMessageDialog(null, "Asistencia modificada:\n" + modif.mostrar());
                }
                if(vecsistema[i] instanceof Online){
                    Online modifOn = ((Online)vecsistema[i]);
                    tps=JOptionPane.showInputDialog("Ingrese si tiene trabajos completos:");
                    modifOn.setEntrega_comp(tps);
                    JOptionPane.showMessageDialog(null, "Asistencia modificada:\n" + modifOn.mostrar());
                }
            }
        }
        if(!ban){
            JOptionPane.showMessageDialog(null, "No se encontraron alumnos con ese nombre.");
        }
    }

    public Alumno[] getVecsistema() {
        return vecsistema;
    }

    public void setVecsistema(Alumno[] vecsistema) {
        this.vecsistema = vecsistema;
    }
}
