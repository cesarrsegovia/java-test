
package practicaparcial2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Transporte {
    private int codigo_trans;
    private Date fecha_rec;
    private String prod_despa;

    public Transporte(int codigo_trans, Date fecha_rec, String prod_despa) {
        this.codigo_trans = codigo_trans;
        this.fecha_rec = fecha_rec;
        this.prod_despa = prod_despa;
    }
    
    public Transporte(){
        codigo_trans=0;
        fecha_rec=null;
        prod_despa="";
    }
    
    public void registrarTransp(int i) throws ParseException{
        String var="";
        this.codigo_trans=i+50;
        Date hoy=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        do{
            do{
                var=JOptionPane.showInputDialog("Ingrese fecha de recepcion:");
            }while(var.isBlank());
        }while(formato.parse(var).compareTo(hoy)>0);
        this.fecha_rec=formato.parse(var);
        do{
            prod_despa=JOptionPane.showInputDialog("ingrese los productos despachados:");
        }while(prod_despa == null || prod_despa.trim().isEmpty());
    }
    
    public int getCodigo_trans() {
        return codigo_trans;
    }

    public void setCodigo_trans(int codigo_trans) {
        this.codigo_trans = codigo_trans;
    }

    public Date getFecha_rec() {
        return fecha_rec;
    }

    public void setFecha_rec(Date fecha_rec) {
        this.fecha_rec = fecha_rec;
    }

    public String getProd_despa() {
        return prod_despa;
    }

    public void setProd_despa(String prod_despa) {
        this.prod_despa = prod_despa;
    }
    
    
}
