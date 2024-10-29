
package guia4ejer1;

import javax.swing.JOptionPane;


public class Guia4ejer1 {

    public static void main(String[] args) {
        Catalogo cat=new Catalogo();
        int op=0;
        String a="";
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                                                            1-Listar ropa
                                                            2-Listar electronico
                                                            3-Listar alimento
                                                            4-Electronico x origen
                                                            5-Mod ropa
                                                            6-Mod electronico
                                                            7-Mod Alimento
                                                            8-Salir
                                                            """));
            
            switch(op){
                case 1:
                    a=cat.listadoProductos(1);
                    JOptionPane.showMessageDialog(null, a);
                    break;
                case 2:
                    a=cat.listadoProductos(2);
                    JOptionPane.showMessageDialog(null, a);
                    break;
                case 3:
                    a=cat.listadoProductos(3);
                    JOptionPane.showMessageDialog(null, a);
                    break;
                case 4:
                    a=JOptionPane.showInputDialog("Ingrese origen:");
                    a=cat.ordenarOrigen(a);
                    JOptionPane.showMessageDialog(null, a);
                    break;
                case 5:
                    op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese id de la ropa"));
                    op=cat.busqueda(1, op);
                    if(op!=-1){
                        Ropa aux=new Ropa();
                        aux.registrarRopa(cat.getVecprod(op).getId()-1);
                        cat.setVecprod(aux, op);
                    }else JOptionPane.showMessageDialog(null, "Error");
                    break;
                case 6:
                    op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del prod electro"));
                    op=cat.busqueda(2, op);
                    if(op!=-1){
                        Electronico aux = new Electronico();
                        aux.registrarElectro(cat.getVecprod(op).getId()-1);
                        cat.setVecprod(aux, op);
                    }else JOptionPane.showMessageDialog(null, "Error");
                    break;
                case 7:
                    op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del alimento"));
                    op=cat.busqueda(3, op);
                    if(op!=-1){
                        Alimento aux=new Alimento();
                        aux.registrarAlimento(cat.getVecprod(op).getId()-1);
                        cat.setVecprod(aux, op);
                    }else JOptionPane.showMessageDialog(null, "Error");
                    break;
                    
            }
        }while(op!=8);
    }
    
}
