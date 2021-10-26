package ac.ucr.tutoticos.modelo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Cuenta implements Parcelable {

    int idCuenta;
    String nombreUsuario, nombreCompleto, correoUsuario, contrasenna;
    int tipoCuenta;
    //Parcelable imgUser;

    public Cuenta(int idCuenta, String nombreUsuario, String nombreCompleto, String correoUsuario, String contrasenna, int tipoCuenta/*, Uri imgUser*/) {
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correoUsuario = correoUsuario;
        this.contrasenna = contrasenna;
        this.tipoCuenta = tipoCuenta;
        //this.imgUser = imgUser;
    }

    public Cuenta() {
        this.idCuenta = 0;
        this.nombreUsuario = "";
        this.nombreCompleto = "";
        this.correoUsuario = "";
        this.contrasenna = "";
        this.tipoCuenta = 0;
        //this.imgUser = null;
    }//fin constructor sin

    protected Cuenta(Parcel in) {
        idCuenta = in.readInt();
        nombreUsuario = in.readString();
        nombreCompleto = in.readString();
        correoUsuario = in.readString();
        contrasenna = in.readString();
        tipoCuenta = in.readInt();
        //imgUser = in.readParcelable(Uri.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idCuenta);
        dest.writeString(nombreUsuario);
        dest.writeString(nombreCompleto);
        dest.writeString(correoUsuario);
        dest.writeString(contrasenna);
        dest.writeInt(tipoCuenta);
        //dest.writeParcelable(imgUser, flags);
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

    /*public byte[] getImgUser() {
        return imgUser;
    }

    public void setImgUser(byte[] imgUser) {
        this.imgUser = imgUser;
    }*/

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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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

    @Override
    public int describeContents() {
        return 0;
    }

}//fin de la clase
