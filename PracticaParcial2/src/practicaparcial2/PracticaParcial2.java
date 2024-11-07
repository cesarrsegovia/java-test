
package practicaparcial2;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class PracticaParcial2 {

    
    public static void main(String[] args) throws ParseException {
        Servicio correo = new Servicio();
        int op=0;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                                                            1.Listar los sobres que se recibieron durante el primer semestre y su precio
                                                            2.Emitir listado de todos los destinos de encomienda con peso mayor o igual a 15kg(sin duplicados)
                                                            3.eliminar todos los sobres enviados con el servicio "simple"
                                                            4.mes aniversario, bonificacion de 10% sobre el precio final a aquellos paquetes mayores a 2000. Emitir listado de datos de los paquetes beneficiados.
                                                            5.Salir.
                                                            """));
            switch(op){
                case 1: correo.listadoSobresPrimerSem(); break;
                case 2: correo.listadoDestinosPeso(); break;
                case 3: correo.eliminarSobreSimple(); break;
                case 4: correo.bonificacionAniv(); break;
            }
        }while(op!=5);
    }
    
}
