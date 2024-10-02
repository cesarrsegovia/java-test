
package guia3ejer1;

import javax.swing.JOptionPane;


public class Guia3ejer1 {

    
    public static void main(String[] args) {
        String menu="";
        int op=0;
        Catalogo c = new Catalogo();
        //c.mostrarCatalogo();
        
        do{
            menu=JOptionPane.showInputDialog("""
                                          1-Automovil mas caro
                                          2-Autos con 3 puertas
                                          3-Listado de bicicletas en forma decreciente segun cantidad de cambios
                                          4-Importe total de la empresa en concepto de autos
                                          5-Importe total de la empresa en concepto de bicicletas
                                          6-Informar el nombre de los automoviles, de x valor, ingresar por teclado entre 16.30 y 19.30
                                          7-Buscar automovil y permitir modificar sus datos
                                          8-Buscar bicicleta y permitir modificar sus datos
                                          9-Salir   
                                          """);
            op=Integer.parseInt(menu);
            
            switch(op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: 
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    break;
            }
            
        }while(op!=9);
    }
    
}
