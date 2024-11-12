
package parcial2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


abstract public class Alumno {
    private String nombreape;
    private Date fecha_ing;
    private int[] notas;

    public Alumno(String nombreape, Date fecha_ing, int[] notas) {
        this.nombreape = nombreape;
        this.fecha_ing = fecha_ing;
        this.notas = notas;
    }
    
    public Alumno(){
        this.nombreape="";
        this.fecha_ing=null;
        int[] aux = new int[3];
        for(int i=0;i<3;i++) aux[i]=0;
        this.notas=aux;
    }
    
    public void registrar() throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date hoy=new Date();
        do{
            nombreape=JOptionPane.showInputDialog("Ingrese nombre y apellido:");
        }while(nombreape == null && nombreape.trim().isEmpty());
        do{
            this.fecha_ing=formato.parse(JOptionPane.showInputDialog("Ingrese fecha de ingreso(dd/MM/yyyy)"));
        }while(this.fecha_ing.compareTo(hoy)>0);
        for(int j=0;j<3;j++){
            this.notas[j]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota N "+ (j+1) +" (1-10)"));
        }
    }
    
    public String mostrar(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String mos="";
        mos+="\nNombre y apellido: " + this.nombreape;
        mos+="\nFecha de ingreso: " + formato.format(this.fecha_ing);
        for(int j=0;j<3;j++){
        mos+="\nNotas: " + (j+1) + " : " + this.notas[j];
        }
        return mos;
    }
   
    abstract String estado();
    
    public int promedio(){
        return((notas[0]+notas[1]+notas[2])/3);
    }

    public String getNombreape() {
        return nombreape;
    }

    public void setNombreape(String nombreape) {
        this.nombreape = nombreape;
    }

    public Date getFecha_ing() {
        return fecha_ing;
    }

    public void setFecha_ing(Date fecha_ing) {
        this.fecha_ing = fecha_ing;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    
    
    }
    
    