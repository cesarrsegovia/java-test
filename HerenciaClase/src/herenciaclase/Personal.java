
package herenciaclase;

import javax.swing.JOptionPane;

public class Personal {
    Persona vecpersona[];
    
    Personal(){
        int n;
        n=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de personas:"));
        vecpersona=new Persona[n];
        for(int i=0;i<vecpersona.length;i++){
            vecpersona[i]=null;//inicializamos vector
        }        
        for(int i=0;i<vecpersona.length;i++){
            int op=0;
            op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese: 1-Alumno 2-Profesor"));
            if(op==1){
                //primero creamos instancia de alumno para llamar sus metodos de clase
                Alumno a=new Alumno();
                //llamamos el metodo registrar
                a.registrarAlumno();
                //guardamos A en la posicion i del arreglo
                vecpersona[i]=a;
            } else{
                Profesor p=new Profesor();
                p.registrarProfesor();
                vecpersona[i]=p;
            }
        }
    }
    public void mostrarPersonal(){
        Alumno auxa=null;
        Profesor auxp=null;
        for(int i=0;i<vecpersona.length;i++){
            if(vecpersona[i] instanceof Alumno){
                auxa =(Alumno) vecpersona[i];
                auxa.mostrarAlumno();
            }
            if(vecpersona[i] instanceof Profesor){
                auxp = (Profesor) vecpersona[i];
                auxp.mostrarProfesor();
            }
        }
    }
}
