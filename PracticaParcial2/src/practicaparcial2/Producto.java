
package practicaparcial2;

import java.text.ParseException;
import javax.swing.JOptionPane;


abstract public class Producto {
    private int codigo;
    private String descrip;
    private String ciudad_ori;
    private String ciudad_des;
    private String emisor;
    private String receptor;
    private Transporte transp;

    public Producto(int codigo, String descrip, String ciudad_ori, String ciudad_des, String emisor, String receptor, Transporte transp) {
        this.codigo = codigo;
        this.descrip = descrip;
        this.ciudad_ori = ciudad_ori;
        this.ciudad_des = ciudad_des;
        this.emisor = emisor;
        this.receptor = receptor;
        this.transp = transp;
    }
    
    public Producto(){
        this.codigo=0;
        this.descrip="";
        this.ciudad_ori="";
        this.ciudad_des="";
        this.emisor="";
        this.receptor="";
        this.transp=transp;
    }
    
    public void registrarProducto(int i) throws ParseException{
        this.codigo=i+100;
        do{
            descrip=JOptionPane.showInputDialog("Ingrese la descripcion del producto:");
        }while(descrip !=null && descrip.trim().isEmpty());
        do{
            ciudad_ori=JOptionPane.showInputDialog("Ingrese la ciudad de origen del producto:");
        }while(ciudad_ori !=null && ciudad_ori.trim().isEmpty());
        do{
            ciudad_des=JOptionPane.showInputDialog("Ingrese el destino del producto:");
        }while(ciudad_des !=null && ciudad_des.trim().isEmpty());
        do{
            emisor=JOptionPane.showInputDialog("Ingrese nombre y apellido del emisor:");
        }while(emisor !=null && emisor.trim().isEmpty());
        do{
            receptor=JOptionPane.showInputDialog("Ingrese nombre y apellido del receptor:");
        }while(receptor !=null && receptor.trim().isEmpty());
        transp=new Transporte();
        transp.registrarTransp(i);
    }
    
    public String mostrarProducto(){
        String mos="";
        mos+="Datos del envio: ";
        mos+="\nCodigo: " + this.codigo;
        mos+="\nDescripcion: " + this.descrip;
        mos+="\nOrigen: " + this.ciudad_ori;
        mos+="\nDestino: " + this.ciudad_des;
        mos+="\nEmisor: " + this.emisor;
        mos+="\nReceptor: " + this.receptor;
        mos+="\nCodigo de transporte: " + transp.getCodigo_trans();
        mos+="\nFecha de recepcion: " + transp.getFecha_rec();
        mos+="\nProducto despachado: " + transp.getProd_despa();
        return mos;
    }
    
    abstract float precioFinal();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCiudad_ori() {
        return ciudad_ori;
    }

    public void setCiudad_ori(String ciudad_ori) {
        this.ciudad_ori = ciudad_ori;
    }

    public String getCiudad_des() {
        return ciudad_des;
    }

    public void setCiudad_des(String ciudad_des) {
        this.ciudad_des = ciudad_des;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public Transporte getTransp() {
        return transp;
    }

    public void setTransp(Transporte transp) {
        this.transp = transp;
    }
    
    
}
