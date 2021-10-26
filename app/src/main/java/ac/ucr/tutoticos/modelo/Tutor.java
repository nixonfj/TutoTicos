package ac.ucr.tutoticos.modelo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Tutor extends Cuenta implements Parcelable {

    int idEspecialidad, edad;
    String sexo, descripcion, modalidad;
    double precio, calificacion;

    public Tutor(int idCuenta, String nombreUsuario, String nombreCompleto, String correoUsuario, String contrasenna, int tipoCuenta, Uri imgUser, int idEspecialidad, int edad, String sexo, String descripcion, String modalidad, double precio, double calificacion) {
        super(idCuenta, nombreUsuario, nombreCompleto, correoUsuario, contrasenna, tipoCuenta/*, imgUser*/);

        this.idEspecialidad = idEspecialidad;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    public Tutor() {
        this.idEspecialidad = 0;
        this.edad = 0;
        this.sexo = "";
        this.descripcion = "";
        this.modalidad = "";
        this.precio = 0;
        this.calificacion = 0;
    }

    protected Tutor(Parcel in) {
        idCuenta = in.readInt();
        nombreUsuario = in.readString();
        nombreCompleto = in.readString();
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
        //imgUser = in.readParcelable(Uri.class.getClassLoader());
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

    @Override
    public String toString() {
        return "Tutor{" +
                ", idEspecialidad=" + idEspecialidad +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", precio=" + precio +
                ", calificacion=" + calificacion;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(idCuenta);
        parcel.writeString(nombreUsuario);
        parcel.writeString(nombreCompleto);
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
        //parcel.writeParcelable(imgUser,i);

    }
}//fin de la clase
