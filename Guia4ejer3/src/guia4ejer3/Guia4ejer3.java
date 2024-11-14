
package guia4ejer3;

import javax.swing.JOptionPane;


public class Guia4ejer3 {

   
    public static void main(String[] args) {
        Listado listado = new Listado();
        int op=0;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                                                            1.listado de autos ordenado por precio
                                                            2.listado de motos ordenado por precio
                                                            3.ingresar marca y cant puertas. mostrar los datos 
                                                            4.infnormar los datos de la motocicleta mas cara.
                                                            5.informar los datos del auto mas barato
                                                            6.emitir un listado de motos ordenado por cantidad de cilindradas.
                                                            7.ingresar nombre y apellido y listar los datos del vehiculo vendido.
                                                            8.ingresar marca y modelo y eliminar todos los autos con esas caracteristicas.
                                                            9.salir.
                                                            """));
            switch(op){
                case 1: listado.listadoAutos(); break;
                case 2: listado.listadoMotos(); break;
                case 3: listado.mostrarXmarcaYmodelo(); break;
                case 4: listado.motoCara(); break;
                case 5: listado.autoBarato(); break;
                case 7: listado.mostrarVehVend(); break;
                case 8: listado.eliminarAuto(); break;
            }
        }while(op!=9);
    }
    
}
