
package guia4ejer1;

import javax.swing.JOptionPane;


public class Electronico extends Producto{
    private String garantia; //falso no
    private String origen; //falso importado

    public Electronico(String garantia, String origen, int id, String nombre, String marca, float precio_base) {
        super(id, nombre, marca, precio_base);
        this.garantia = garantia;
        this.origen = origen;
    }
    
    public Electronico() {
        super();
        this.garantia = "";
        this.origen = "";
    }
    
    public void registrarElectro(int i){
        super.registrarProducto(i);
    }
    
    public float precioFinal(){
        float pre=super.getPrecio_base();
        if(this.garantia.equalsIgnoreCase("Si") && this.origen.equalsIgnoreCase("nacional")) return (float) (pre+(pre+0.15));
        return pre;
    }
    
    public String mostrarElectro(){
        String a=super.mostrarProducto();
        a+="\nGarantia: " + this.garantia;
        a+="\nOrigen: " + this.origen;
        a+="\nPrecio final: " + this.precioFinal();
        return a;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
