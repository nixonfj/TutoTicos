package ac.ucr.tutoticos.modelo;

public class Tutor extends Cuenta{

    int idTutor, idEspecialidad, edad;
    String sexo, descripcion, modalidad;
    double precio, calificacion;

    public Tutor(int idCuenta, String nombreUsuario, String nombreCompleto, String correoUsuario, String contrasenna, int tipoCuenta, int idTutor, int idEspecialidad, int edad, String sexo, String descripcion, String modalidad, double precio, double calificacion) {
        super(idCuenta, nombreUsuario, nombreCompleto, correoUsuario, contrasenna, tipoCuenta);
        this.idTutor = idTutor;
        this.idEspecialidad = idEspecialidad;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    public Tutor() {
        this.idTutor = 0;
        this.idEspecialidad = 0;
        this.edad = 0;
        this.sexo = "";
        this.descripcion = "";
        this.modalidad = "";
        this.precio = 0;
        this.calificacion = 0;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "idTutor=" + idTutor +
                ", idEspecialidad=" + idEspecialidad +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", precio=" + precio +
                ", calificacion=" + calificacion;
    }



}//fin de la clase
