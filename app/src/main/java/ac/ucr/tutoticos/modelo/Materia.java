package ac.ucr.tutoticos.modelo;

public class Materia {
    String nombre;

    public Materia(String nombre) {
        this.nombre = nombre;
    }//fin con

    public Materia() {
        this.nombre = "Ninguna agregada";
    }//fin sin

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}//fin  de la clase materia
