package ac.ucr.tutoticos.modelo;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Tutor extends Cuenta implements Parcelable {

    Materia materia;
    Horario horario;

    int idEspecialidad, edad;
    String sexo, descripcion, modalidad;
    double precio, calificacion;
    ArrayList<Materia> materias;

    public Tutor(String idCuenta, String nombreUsuario, String nombre, String apellido, String correoUsuario, String contrasenna, int tipoCuenta, Bitmap imgUser, int idEspecialidad, int edad, String sexo, String descripcion, String modalidad, double precio, double calificacion, ArrayList<Materia> materias) {
        super(idCuenta, nombreUsuario, nombre, apellido, correoUsuario, contrasenna, tipoCuenta, imgUser);

        this.idEspecialidad = idEspecialidad;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.precio = precio;
        this.calificacion = calificacion;
        this.materias = materias;
    }

    public Tutor() {

        this.idEspecialidad = 0;
        this.edad = 0;
        this.sexo = "sexo";
        this.descripcion = "descripcion";
        this.modalidad = "Virtual";
        this.precio = 0;
        this.calificacion = 0;
        this.materias = null;
    }
    protected Tutor(Parcel in){
        idCuenta = in.readString();
        nombreUsuario = in.readString();
        nombre = in.readString();
        apellido = in.readString();
        correoUsuario = in.readString();
        contrasenna = in.readString();
        tipoCuenta = in.readInt();
        idEspecialidad = in.readInt();
        edad = in.readInt();
        sexo = in.readString();
        descripcion = in.readString();
        modalidad = in.readString();
        precio = in.readDouble();
        calificacion = in.readDouble();
        imgUser = in.readParcelable(Uri.class.getClassLoader());
        //in.readTypedList(materias, Materia.CREATOR);
        materias = in.createTypedArrayList(Materia.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tutor> CREATOR = new Creator<Tutor>() {
        @Override
        public Tutor createFromParcel(Parcel in) {
            return new Tutor(in);
        }

        @Override
        public Tutor[] newArray(int size) {
            return new Tutor[size];
        }
    };

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

    public ArrayList<Materia> getMateria() {
        return materias;
    }

    public void setMateria(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(idCuenta);
        parcel.writeString(nombreUsuario);
        parcel.writeString(nombre);
        parcel.writeString(apellido);
        parcel.writeString(correoUsuario);
        parcel.writeString(contrasenna);
        parcel.writeInt(tipoCuenta);
        parcel.writeInt(idEspecialidad);
        parcel.writeInt(edad);
        parcel.writeString(sexo);
        parcel.writeString(descripcion);
        parcel.writeString(modalidad);
        parcel.writeDouble(precio);
        parcel.writeDouble(calificacion);
        parcel.writeParcelable(imgUser,i);
        parcel.writeTypedList(materias);
    }

}//fin de la clase
