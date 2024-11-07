
package practicaparcial2;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class Sobre extends Producto{
    private String servicio;

    public Sobre(String servicio, int codigo, String descrip, String ciudad_ori, String ciudad_des, String emisor, String receptor, Transporte transp) {
        super(codigo, descrip, ciudad_ori, ciudad_des, emisor, receptor, transp);
        this.servicio = servicio;
    }
    

    public Sobre(){
        super();
        this.servicio="";
    }
    
    public void registrarProducto(int i) throws ParseException{
        super.registrarProducto(i+1);
        do{
            servicio=JOptionPane.showInputDialog("Ingrese el tipo de servicio: (simple/postal/posta24)");
        }while(!servicio.equalsIgnoreCase("postal") && !servicio.equalsIgnoreCase("simple") && !servicio.equalsIgnoreCase("postal24"));
    }
    
    public String mostrarSobre(){
        String mos=super.mostrarProducto();
        mos+="\nTipo de servicio: " + this.servicio;
        mos+="\nValor total: " + this.precioFinal();
        return mos;
    }
    
    public float precioFinal(){
        float precio=0;
        switch(servicio){
            case "simple": precio+=150; break;
            case "postal": precio+=220; break;
            case "postal24": precio+=400; break;
        }
        return precio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    
}
