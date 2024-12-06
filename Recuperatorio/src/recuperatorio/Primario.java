
package recuperatorio;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Primario extends Alumno{
    private String tiene_her;
    private int cant_herm;

    public Primario(String tiene_her, int cant_herm, String nombreape, Date ingreso, int[] notas) {
        super(nombreape, ingreso, notas);
        this.tiene_her = tiene_her;
        this.cant_herm = cant_herm;
    }
    
    public Primario(){
        super();
        this.tiene_her="";
        this.cant_herm=0;
    }
    
    public void registrar() throws ParseException{
        super.registrar();
        do{
            tiene_her=JOptionPane.showInputDialog("Tiene hermanos?(si/no)");
            if(tiene_her.equalsIgnoreCase("si")){
            do{
                cant_herm=Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
            }while(cant_herm < 0);
        }
        }while(tiene_her != null && tiene_her.trim().isEmpty());
        
    }
    
    public String mostrarPrimario(){
        String mos=super.mostrar();
        mos+="\nHermanos: " + this.tiene_her;
        if(cant_herm>0){
            mos+="\nCantidad: " + this.cant_herm;
        }
        mos+="\nPromedio: " + super.promedio();
        mos+="\nEstado de beca: " + this.estadoBeca() + "\n";
        return mos;
    }
    
    public void modificarPrimario() throws ParseException{
        super.registrar();
        do{
            tiene_her=JOptionPane.showInputDialog("Tiene hermanos?(si/no)");
            if(tiene_her.equalsIgnoreCase("si")){
            do{
                cant_herm=Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
            }while(cant_herm < 0);
        }
        }while(tiene_her != null && tiene_her.trim().isEmpty());
    }
    
    public String estadoBeca(){
        String estado="";
        if(cant_herm > 3){
            estado="Beca asignada";
        }else{
            estado="No cumple los requisitos para la beca.";
        }
        return estado;
    }

    public String getTiene_her() {
        return tiene_her;
    }

    public void setTiene_her(String tiene_her) {
        this.tiene_her = tiene_her;
    }

    public int getCant_herm() {
        return cant_herm;
    }

    public void setCant_herm(int cant_herm) {
        this.cant_herm = cant_herm;
    }
    
    
}
