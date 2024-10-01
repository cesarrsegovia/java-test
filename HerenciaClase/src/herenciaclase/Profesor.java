
package herenciaclase;

import javax.swing.JOptionPane;

public class Profesor extends Persona{
    private String titulouni;
    private int horascat;
    private String especialidad;
    
    Profesor(){
        super();
       horascat=0;
       especialidad="";
    }
    
    public void registrarProfesor(){
        super.registrarPersona();
        horascat=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de horas catedras"));
        especialidad=JOptionPane.showInputDialog("Ingrese su especialidad:");
    }
    
    public void mostrarProfesor(){
        super.mostrarPersona();
        JOptionPane.showMessageDialog(null, "\nCantidad horas catedras: " + this.getHorascat()
         + "\nEspecialidad: " + this.getEspecialidad());
    }

    public String getTitulouni() {
        return titulouni;
    }

    public void setTitulouni(String titulouni) {
        this.titulouni = titulouni;
    }

    public int getHorascat() {
        return horascat;
    }

    public void setHorascat(int horascat) {
        this.horascat = horascat;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
