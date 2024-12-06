
package recuperatorio;


import java.text.ParseException;
import javax.swing.JOptionPane;


public class Sistema {
    private Alumno[] vecalu;

    public Sistema(Alumno[] vecalu) {
        this.vecalu = vecalu;
    }
    
    public Sistema() throws ParseException{
        int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad alumnos a registrar: "));
        String op="";
        vecalu=new Alumno[n];
        for(int i=0;i<vecalu.length;i++){
            do{
                op=JOptionPane.showInputDialog("Ingrese nivel academico;");
                switch(op){
                    case "primario":
                        vecalu[i]=new Primario();
                        ((Primario)vecalu[i]).registrar();
                        JOptionPane.showMessageDialog(null, ((Primario)vecalu[i]).mostrar());
                        break;
                    case "secundario":
                        vecalu[i]=new Secundario();
                        ((Secundario)vecalu[i]).registrarSecu();
                        JOptionPane.showMessageDialog(null, ((Secundario)vecalu[i]).mostrar());
                        break;
                }
            }while(!op.equalsIgnoreCase("primario") && !op.equalsIgnoreCase("secundario"));
        }
    }
    
    public void listadoAcademicoPrimario(){
        String resultado="Datos alumnos primario: \n";
        for(int i=0;i<vecalu.length;i++){
            if(vecalu[i] instanceof Primario){
                Primario alumnos=((Primario)vecalu[i]);
                resultado+=((Primario)vecalu[i]).mostrarPrimario();
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    public void listadoAcademicoSecu(){
        String resultado="Datos Alumnos Secundario: \n";
        for(int i=0;i<vecalu.length;i++){
            
            if(vecalu[i] instanceof Secundario){
                Secundario alumnosecu=((Secundario)vecalu[i]);
                resultado+=((Secundario)vecalu[i]).mostrarSecu();
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    public void busqModif() throws ParseException{
        String nom=JOptionPane.showInputDialog("Ingrese el nombre y apellido que desea buscar");
        boolean ban=false;
        for(int i=0;i<vecalu.length;i++){
            if(vecalu[i].getNombreape().equalsIgnoreCase(nom)){
                ban=true;
                if(vecalu[i] instanceof Primario){
                    Primario modifalu=((Primario)vecalu[i]);
                    modifalu.modificarPrimario();
                    JOptionPane.showMessageDialog(null, "Alumno modificado correctamente.\n" + modifalu.mostrarPrimario());
                }
                if(vecalu[i] instanceof Secundario){
                    Secundario modifalusec=((Secundario)vecalu[i]);
                    modifalusec.modificarSecu();
                    JOptionPane.showMessageDialog(null, "Alumno modificado correctamente.\n" + modifalusec.mostrarSecu());
                }
            }
        }
        if(!ban){
            JOptionPane.showMessageDialog(null, "No se encontraron alumnos con ese nombre.");
        }
    }

    public Alumno[] getVecalu() {
        return vecalu;
    }

    public void setVecalu(Alumno[] vecalu) {
        this.vecalu = vecalu;
    }
    
    
}
