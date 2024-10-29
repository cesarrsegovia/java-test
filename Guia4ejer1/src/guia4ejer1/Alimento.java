
package guia4ejer1;

import javax.swing.JOptionPane;
public class Alimento extends Producto{
    private String perecedero;
    
    public Alimento(String perecedero, int id, String nombre, String marca, float precio_base) {
        super(id, nombre, marca, precio_base);
        this.perecedero = perecedero;
    }

    public Alimento() {
        super();
        this.perecedero = "";
    }
    
    public void registrarAlimento(int i){
        super.registrarProducto(i+1);
        this.perecedero=JOptionPane.showInputDialog("Ingrese si es perecedero:");
    }
    
    public float precioFinal(){
        float pre=super.getPrecio_base();
        if(this.perecedero.equalsIgnoreCase("si")) return (float) (pre+(pre+0.05));
        return (float) (pre-(pre+0.11));
    }
    
    public String mostrarAlimento(){
        String a=super.mostrarProducto();
        a+="Perecedero: " + this.perecedero;
        a+="Precio final: " + this.precioFinal();
        return a;
    }

    public String getPerecedero() {
        return perecedero;
    }

    public void setPerecedero(String perecedero) {
        this.perecedero = perecedero;
    }
}
