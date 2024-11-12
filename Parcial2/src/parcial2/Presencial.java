
package parcial2;


import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Presencial extends Alumno{
    int regis_asis;

    public Presencial(int regis_asis, String nombreape, Date fecha_ing, int[] notas) {
        super(nombreape, fecha_ing, notas);
        this.regis_asis = regis_asis;
    }

    
    public Presencial(){
        super();
        this.regis_asis=0;
    }
    
    public void registrar() throws ParseException{
        super.registrar();
        do{
            this.regis_asis=Integer.parseInt(JOptionPane.showInputDialog("Ingrese porcentaje de asistencia:"));
        }while(regis_asis < 0 || regis_asis >100);
    }
    
    public String mostrar(){
        String mos=super.mostrar();
        mos+="\nPorcentaje de asistencia: " + this.regis_asis + "%";
        mos+="\nPromedio: " + super.promedio();
        mos+="\nEstado: " + this.estado();
        return mos;
    }
    
    public String estado(){
        if(regis_asis>=75){
            if(super.promedio()>=4){
                if(super.promedio()>=7) return "Promocionado";
                else return "Regular";
            }else return "Libre";
        }else return "Libre";
    }

    public int getRegis_asis() {
        return regis_asis;
    }

    public void setRegis_asis(int regis_asis) {
        this.regis_asis = regis_asis;
    }
    
    
}
