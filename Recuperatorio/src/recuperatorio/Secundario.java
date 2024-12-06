
package recuperatorio;


import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Secundario extends Alumno{
    private String adeuda_mat;
    private String repite;

    public Secundario(String adeuda_mat, String repite, String nombreape, Date ingreso, int[] notas) {
        super(nombreape, ingreso, notas);
        this.adeuda_mat = adeuda_mat;
        this.repite = repite;
    }
    
    public Secundario(){
        super();
        this.adeuda_mat="";
        this.repite="";
    }
    
    public void registrarSecu() throws ParseException{
        super.registrar();
        do{
            adeuda_mat=JOptionPane.showInputDialog("Adeuda materias?(si/no)");
        }while(adeuda_mat != null && adeuda_mat.trim().isEmpty());
        do{
            repite=JOptionPane.showInputDialog("Repite?(si/no)");
        }while(repite != null && repite.trim().isEmpty());
    }
    
    public String mostrarSecu(){
        String mos=super.mostrar();
        mos+="\nAdeuda materias: " + this.adeuda_mat;
        mos+="\nRepite: " + this.repite;
        mos+="\nPromedio: " + super.promedio();
        mos+="\nEstado beca: " + this.estadoBeca() + "\n";
        return mos;
    }
    
    public void modificarSecu() throws ParseException{
        super.registrar();
        do{
            adeuda_mat=JOptionPane.showInputDialog("Adeuda materias?(si/no)");
        }while(adeuda_mat != null && adeuda_mat.trim().isEmpty());
        do{
            repite=JOptionPane.showInputDialog("Repite?(si/no)");
        }while(repite != null && repite.trim().isEmpty());
    }
    
    public String estadoBeca(){
        String estado="";
        Boolean notaValida=true;
        int[] notas=getNotas();
        for(int j=0;j<notas.length;j++){
            if(notas[j]<6){
                notaValida=false;
                break;
            }
        }
        if(super.promedio()>=8 && this.adeuda_mat.equalsIgnoreCase("no") && this.repite.equalsIgnoreCase("no") && notaValida){
            estado="Beca otorgada";
        }else{
            estado="No cumple los requisitos.";
        }
        
        return estado;
    }

    public String getAdeuda_mat() {
        return adeuda_mat;
    }

    public void setAdeuda_mat(String adeuda_mat) {
        this.adeuda_mat = adeuda_mat;
    }

    public String getRepite() {
        return repite;
    }

    public void setRepite(String repite) {
        this.repite = repite;
    }
    
    
}