
package herenciaclase;


import java.util.Date;
import javax.swing.JOptionPane;

public class Persona {
    private int legajo;
    private String nombreape;
    private String ciudad;
    //Date fnac;
    private String correo;

    /*public Persona(int legajo, String nombreape, String ciudad, String correo) {
        this.legajo = legajo;
        this.nombreape = nombreape;
        this.ciudad = ciudad;
        this.correo = correo;
    }*/
    
    Persona(){
        legajo=0;
        nombreape="";
        ciudad="";
        correo="";
    }
    
    public void registrarPersona(){
        legajo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de legajo:"));
        nombreape=JOptionPane.showInputDialog("Ingrese nombre y apellido:");
        ciudad=JOptionPane.showInputDialog("Ingrese su ciudad:");
        correo=JOptionPane.showInputDialog("Ingrese su correo");
    }
    
    public void mostrarPersona(){
        JOptionPane.showMessageDialog(null, "\nLegajo: " + this.getLegajo() 
        + "\nNombre y apellido: " + this.getNombreape() + "\nCiudad: " + this.getCiudad()
        + "\nCorreo: " + this.getCorreo());
    }
    

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombreape() {
        return nombreape;
    }

    public void setNombreape(String nombreape) {
        this.nombreape = nombreape;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}