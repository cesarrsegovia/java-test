
package parcial2;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;


public class Online extends Alumno{
    private String entrega_comp;

    public Online(String entrega_comp, String nombreape, Date fecha_ing, int[] notas) {
        super(nombreape, fecha_ing, notas);
        this.entrega_comp = entrega_comp;
    }

    
    public Online(){
        super();
        this.entrega_comp="";
    }
    
    public void registrar() throws ParseException{
        super.registrar();
        do{
            this.entrega_comp=JOptionPane.showInputDialog("Tiene todos los trabajos completos?");
        }while(!this.entrega_comp.equalsIgnoreCase("si") && !this.entrega_comp.equalsIgnoreCase("no"));
    }
    
    public String mostrar(){
        String mos=super.mostrar();
        mos+="\nTrabajos completados: " + this.entrega_comp;
        mos+="\nPromedio: " + super.promedio();
        mos+="\nEstado: " + this.estado();
        return mos;
    }
    
    public String estado(){
        if(super.promedio()>=4){
            if(super.promedio()>=7 && this.entrega_comp.equalsIgnoreCase("si")) return "Promocionado";
            else return "Regular";
        }else return "Libre";
    }

    public String getEntrega_comp() {
        return entrega_comp;
    }

    public void setEntrega_comp(String entrega_comp) {
        this.entrega_comp = entrega_comp;
    }
    
    
}