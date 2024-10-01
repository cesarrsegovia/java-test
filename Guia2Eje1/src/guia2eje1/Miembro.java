
package guia2eje1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Miembro {
    private int id;
    private String nombreape;
    private String rol;
    private Date falta;
    private Date fbaja;

    public Miembro(int id, String nombreape, String rol, Date falta, Date fbaja) {
        this.id = id;
        this.nombreape = nombreape;
        this.rol = rol;
        this.falta = falta;
        this.fbaja = fbaja;
    }
    
    public Miembro(){
        id=0;
        nombreape="";
        rol="";
        falta=null;
        fbaja=null;
    }
    
    public void registrarMiembro(int i) throws ParseException{
        this.id = i + 1;
        String var;
        do{
            var=JOptionPane.showInputDialog("Ingrese nombre y apellido:");
        }while(var.isBlank());
        this.nombreape=var;
        
        do{
            var=JOptionPane.showInputDialog("Ingrese su rol: 1-lider 2-analista 3-desarrollador 4-tester");
        }while(var.isBlank());
        this.rol=var;
        
        Date hoy = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        do{
            do{
                var=JOptionPane.showInputDialog("Ingrese fecha de alta:");
            }while(var.isBlank());
        }while(formato.parse(var).compareTo(hoy)>0);
        this.falta=formato.parse(var);
    }
    
    public void mostrarMiembros(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        JOptionPane.showMessageDialog(null, "id: " + id + "\nnombre y apellido: " + nombreape + "\nrol: " + rol + "\nfecha de alta: " + formato.format(falta));
    }
    public void modificarMiembro() throws ParseException{
        this.nombreape = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
        this.rol = JOptionPane.showInputDialog("Ingrese el nuevo rol: ");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.falta = formato.parse(JOptionPane.showInputDialog("Ingrese nueva fecha de alta: "));
        JOptionPane.showMessageDialog(null, "Miembro modificado correctamente");
    }

    public Date getFbaja() {
        return fbaja;
    }

    public void setFbaja(Date fbaja) {
        this.fbaja = fbaja;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreape() {
        return nombreape;
    }

    public void setNombreape(String nombreape) {
        this.nombreape = nombreape;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFalta() {
        return falta;
    }

    public void setFalta(Date falta) {
        this.falta = falta;
    }
    
    
}
