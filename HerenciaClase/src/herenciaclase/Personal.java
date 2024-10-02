
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
    
    public void listarAlumnos(){
        String bus="";
        Alumno auxa=null;
        boolean ban=false;
        bus=JOptionPane.showInputDialog("Ingrese un curso:");
        for(int i=0;i<vecpersona.length;i++){
            //verificamos si es un alumno
            if(vecpersona[i] instanceof Alumno){
                auxa=(Alumno)vecpersona[i];
                if(bus.compareToIgnoreCase(auxa.getCurso())==0){
                    auxa.mostrarAlumno();
                    ban=true;
                }
            }   
        }
        if(ban==false){
            JOptionPane.showMessageDialog(null, "no se encontraron alumnos");
        }
        
    }
    
    public void listarProfeCiudad(String c){
        Profesor auxp=null;
        boolean ban=false;
        for(int i=0;i<vecpersona.length;i++){
            if(vecpersona[i] instanceof Profesor){
                auxp=(Profesor)vecpersona[i];
                if(auxp.getCiudad().compareToIgnoreCase(c)==0){
                    auxp.mostrarProfesor();
                    ban=true;
                }
            }
        }
        if(ban==false){
            JOptionPane.showMessageDialog(null, "no hay profesores en la ciudad: " + c);
        }
    }
    
    public void listarEspecialidad(){
        Profesor auxp=null;
        boolean ban=false;
        for(int i=0;i<vecpersona.length;i++){
            if(vecpersona[i] instanceof Profesor){
                auxp=(Profesor)vecpersona[i];
                if(auxp.getEspecialidad().compareToIgnoreCase("si")==0){
                    auxp.mostrarProfesor();
                    ban=true;
                }
            }
        }
        if(ban==false){
            JOptionPane.showMessageDialog(null, "No se encontraron profesores con especialidad");
        }
    }
    
    public void busquedaModificar(){
        int bus=0;
        bus=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el legajo a modificar:"));
        Alumno auxa=null;
        boolean ban=false;
        for(int i=0;i<vecpersona.length;i++){
            if(vecpersona[i] instanceof Alumno){
                auxa=(Alumno)vecpersona[i];
                if(auxa.getLegajo()==bus){
                    auxa.modificarAlumno();
                    JOptionPane.showMessageDialog(null, "Alumno modificado");
                    auxa.mostrarAlumno();
                    ban=true;
                }
            }
        }
        if(ban=false){
            JOptionPane.showMessageDialog(null, "Legajo no encontrado");
        }
    }
    
    public void mayorHorasCat(){
        Profesor auxp=null;
        Profesor p=new Profesor();
        //creamos un profesor auxiliar y le asignamos un valor pequeño de horas catedras para comparar
        p.setHorascat(-999);
        
        for(int i=0;i<vecpersona.length;i++){
            if(vecpersona[i] instanceof Profesor){
                auxp=(Profesor)vecpersona[i];
                if(auxp.getHorascat()>p.getHorascat()){
                    p=auxp;
                }
            }
        }
        p.mostrarProfesor();
    }
}

