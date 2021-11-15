package ac.ucr.tutoticos.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Materia implements Parcelable {
    String nombre;

    public Materia(String nombre) {
        this.nombre = nombre;
    }//fin con

    public Materia() {
        this.nombre = "Ninguna agregada";
    }//fin sin

    protected Materia(Parcel in) {
        nombre = in.readString();
    }

    public static final Creator<Materia> CREATOR = new Creator<Materia>() {
        @Override
        public Materia createFromParcel(Parcel in) {
            return new Materia(in);
        }

        @Override
        public Materia[] newArray(int size) {
            return new Materia[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
    }
}//fin  de la clase materia
