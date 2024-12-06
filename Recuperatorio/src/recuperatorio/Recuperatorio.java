
package recuperatorio;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Recuperatorio {

   
    public static void main(String[] args) throws ParseException {
        Sistema listado = new Sistema();
        int op=0;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                                                            1.listado de alumnos por nivel academico
                                                            2.buscar por nombre y modificar
                                                            3.salir
                                                            """));
            switch(op){
                case 1: listado.listadoAcademicoPrimario();
                        listado.listadoAcademicoSecu();
                break;
                case 2: listado.busqModif(); break;
                default: JOptionPane.showMessageDialog(null, "ingrese una opcion correcta");
                    break;
            }
        }while(op!=3);
    }
    
}
