
package recuperatorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


abstract public class Alumno {
    private String nombreape;
    private Date ingreso;
    private int [] notas;

    

    public Alumno(String nombreape, Date ingreso, int[] notas) {
        this.nombreape = nombreape;
        this.ingreso = ingreso;
        this.notas = notas;
    }
    
    public Alumno(){
        this.nombreape="";
        this.ingreso=null;
        int[] aux = new int[5];
        for(int i=0;i<5;i++) aux[i]=0;
        this.notas=aux;
    }
    
    public void registrar() throws ParseException{
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        Date hoy=new Date();
        do{
            nombreape=JOptionPane.showInputDialog("Ingrese su nombre y apellido:");
        }while(nombreape != null && nombreape.trim().isEmpty());
        do{
            ingreso=formato.parse(JOptionPane.showInputDialog("Ingrese fecha de ingreso(dd/MM/yyyy)"));
        }while(this.ingreso.compareTo(hoy)>0);
        for(int j=0;j<5;j++){
            do{
                this.notas[j]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota N "+ (j+1) +" (1-10)"));
            }while(notas[j]<0);
        }
    }
    
    public String mostrar(){
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
        String mos="";
        mos+="\nNombre y apellido: " + this.nombreape;
        mos+="\nFecha de ingreso: " + formato.format(this.ingreso);;
        for(int j=0;j<5;j++){
        mos+="\nNotas: " + (j+1) + " : " + this.notas[j];
        }
        return mos;
    }
    
    abstract String estadoBeca();
    
    public int promedio(){
        return((notas[0]+notas[1]+notas[2]+notas[3]+notas[4])/5);
    }

    public String getNombreape() {
        return nombreape;
    }

    public void setNombreape(String nombreape) {
        this.nombreape = nombreape;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }
    
    
}