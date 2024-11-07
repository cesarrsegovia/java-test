
package practicaparcial2;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Encomienda extends Producto{
    private float peso;
    private float monto_aseg;

    public Encomienda(float peso, float monto_aseg, int codigo, String descrip, String ciudad_ori, String ciudad_des, String emisor, String receptor, Transporte transp) {
        super(codigo, descrip, ciudad_ori, ciudad_des, emisor, receptor, transp);
        this.peso = peso;
        this.monto_aseg = monto_aseg;
    }

    public Encomienda(){
        super();
        this.peso=0;
        this.monto_aseg=0;
    }
    
    public void registrarProducto(int i) throws ParseException{
        super.registrarProducto(i+1);
        do{
            peso=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso de la encomienda:"));
        }while(peso < 0);
        do{
            monto_aseg=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el monto asegurado:"));
        }while(monto_aseg < 0);
    }
    
    public float precioFinal(){
        float precio=monto_aseg+(peso*200);
        if(precio>10){
            precio*=0.95;
        }
        return precio;
    }
    
    public String mostrarEncomienda(){
        String mos=super.mostrarProducto();
        mos+="\nPeso de la encomienda: " + this.peso + " KG.";
        mos+="\nMonto asegurado: " + this.monto_aseg;
        mos+="\nValor total: " + this.precioFinal();
        return mos;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getMonto_aseg() {
        return monto_aseg;
    }

    public void setMonto_aseg(float monto_aseg) {
        this.monto_aseg = monto_aseg;
    }
    
    
}
