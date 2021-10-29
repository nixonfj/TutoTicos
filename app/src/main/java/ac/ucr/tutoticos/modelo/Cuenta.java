package ac.ucr.tutoticos.modelo;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Cuenta implements Parcelable {

    int idCuenta;
    String nombreUsuario, nombre, apellido, correoUsuario, contrasenna;
    int tipoCuenta;
    //Bitmap imgUser;

    public Cuenta(int idCuenta, String nombreUsuario, String nombre, String apellido, String correoUsuario, String contrasenna, int tipoCuenta/*, Bitmap imgUser*/) {
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoUsuario = correoUsuario;
        this.contrasenna = contrasenna;
        this.tipoCuenta = tipoCuenta;
        //this.imgUser = imgUser;
    }
    public Cuenta() {
        this.idCuenta = 0;
        this.nombreUsuario = "nombreUsuario";
        this.nombre = "nombre";
        this.apellido = "apellido";
        this.correoUsuario = "correoUsuario";
        this.contrasenna = "contrasenna";
        this.tipoCuenta = 0;
        //this.imgUser = null;
    }

    protected Cuenta(Parcel in) {
        idCuenta = in.readInt();
        nombreUsuario = in.readString();
        nombre = in.readString();
        apellido = in.readString();
        correoUsuario = in.readString();
        contrasenna = in.readString();
        tipoCuenta = in.readInt();
        //imgUser = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<Cuenta> CREATOR = new Creator<Cuenta>() {
        @Override
        public Cuenta createFromParcel(Parcel in) {
            return new Cuenta(in);
        }

        @Override
        public Cuenta[] newArray(int size) {
            return new Cuenta[size];
        }
    };

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /*public Bitmap getImgUser() {
        return imgUser;
    }

    public void setImgUser(Bitmap imgUser) {
        this.imgUser = imgUser;
    }*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idCuenta);
        parcel.writeString(nombreUsuario);
        parcel.writeString(nombre);
        parcel.writeString(apellido);
        parcel.writeString(correoUsuario);
        parcel.writeString(contrasenna);
        parcel.writeInt(tipoCuenta);
        //parcel.writeParcelable(imgUser, i);
    }
}//fin de la clase
