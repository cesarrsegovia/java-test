
package herenciaclase;

import javax.swing.JOptionPane;


public class HerenciaClase {

    
    public static void main(String[] args){ 
        String menu="";
        int op=0;
        Personal p = new Personal();
        //p.mostrarPersonal();
        
        do{
            menu=JOptionPane.showInputDialog("""
                                          1-Listar alumno por curso
                                          2-Listar profesores de la ciudad de rio grande
                                          3-Listar profesores de la ciudad de tolhuin
                                          4-Listar profesores de la ciudad de ushuaia
                                          5-Listar profesores por especialidad
                                          6-Buscar alumno y modificar
                                          7-Mostrar profesor con mas horas catedras
                                          8-Salir
                                          """);
            op=Integer.parseInt(menu);
            
            switch(op){
                case 1:
                    //punto 1 listar alumnos por curso
                    p.listarAlumnos();
                    break;
                case 2:
                    //punto 2 listar profesores por ciudad
                    p.listarProfeCiudad("rio grande");
                    break;
                case 3:
                    p.listarProfeCiudad("tolhuin");
                    break;
                case 4:
                    p.listarProfeCiudad("ushuaia");
                    break;
                case 5:
                    //punto 5 listar profesores por especialidad
                    p.listarEspecialidad();
                    break;
                case 6:
                    //punto 6 buscar alumno por legajo y modificarlo
                    p.busquedaModificar();
                    break;
                case 7:
                    //punto 7 mostrar los datos del profesor con mayor horas catedras
                    p.mayorHorasCat();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "saliendo");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "seleccione opcion correcta");
                    break;
            }
        }while(op!=8);
    }
    
}
