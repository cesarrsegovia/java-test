
package guia4ejer1;

import javax.swing.JOptionPane;

public class Ropa extends Producto{
    private String tamanio;

    public Ropa(int id, String nombre, String marca, float precio_base,String tamanio) {
        super(id, nombre, marca, precio_base);
        this.tamanio=tamanio;
    }
    
    public Ropa() {
        super();
        this.tamanio = tamanio;
    }
    
    public void registrarRopa(int i){
        super.registrarProducto(i+1);
        this.tamanio=JOptionPane.showInputDialog("Ingrese el tamaño: pequenio/mediano/grande");
    }
    
    public float precioFinal(){
        float pre=super.getPrecio_base();
        if(this.tamanio.equalsIgnoreCase("Pequeño")) return (float) (pre+(pre+0.05));
        if(this.tamanio.equalsIgnoreCase("Mediano")) return (float) (pre+(pre+0.07));
        else return (float) (pre+(pre+0.1));
    }
    
    public String mostrarRopa(){
        String a=super.mostrarProducto();
        a+="\nTamaño: " + this.tamanio;
        a+="\nPrecio final: " + this.precioFinal();
        return a;
    }
    
    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}
