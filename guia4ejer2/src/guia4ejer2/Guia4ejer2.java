
package guia4ejer2;

import javax.swing.JOptionPane;


public class Guia4ejer2 {

    
    public static void main(String[] args) {
        Inventario invent = new Inventario();
        int op=0;
        String a="";
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                                                            1.Listado de smartphones por precio
                                                            2.Listado de laptops por precio
                                                            3.Listado de tablets por precio
                                                            4.Cantidad de smartphones con camara frontal y camarara TO disponibles (2cantidades)
                                                            5.Datos de la laptop con pantalla grande y que tenga el precio mas economico
                                                            6.Cantidad de laptops por cada tipo de memoria ram.
                                                            7.Mostrar datos de todas las tablets con conectividad 4g. incluir datos del cargador.
                                                            8.Buscar dispositivo electronico por su marca y modelo y modificar.
                                                            9.Buscar un dispositivo electronico por su marca y modelo y eliminarlo
                                                            10.Emitir un listado de todos los dispositivos electronicos que usen cargador rapido
                                                            11.Determinar la cantidad de productos electronicos con cargadores de cada potencia (6 cantidades)
                                                            """));
            
            switch(op){
                case 1: invent.listaSmartphones(); break;
                case 2: invent.listaLaptop(); break;
                case 3: invent.listaTablet(); break;
                case 4: invent.cantidadCamaras(); break;
                case 5: invent.laptopPantallaGrandeBarata(); break;
                case 6: invent.laptopXRam(); break;
                case 7: invent.tablets4g(); break;
                case 8: invent.modificarDispo(); break;
                case 9: invent.eliminarDispo(); break;
                case 10: invent.listadoDispCargaRapida(); break;
                case 11: invent.cantidadDispPotCarga(); break;
            }
        }while(op!=12);
    }
    
}
