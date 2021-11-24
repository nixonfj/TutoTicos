package ac.ucr.tutoticos.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Horario implements Parcelable {

    String dia, horaInicio, horaFinal;

    public Horario(String dia, String horaInicio, String horaFinal) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }//fin con

    public Horario() {
        this.dia = "dd/mm/yy";
        this.horaInicio = "00/00/00";
        this.horaFinal = "00/00/00";
    }//fin sin

    protected Horario(Parcel in) {
        dia = in.readString();
        horaInicio = in.readString();
        horaFinal = in.readString();
    }

    public static final Creator<Horario> CREATOR = new Creator<Horario>() {
        @Override
        public Horario createFromParcel(Parcel in) {
            return new Horario(in);
        }

        @Override
        public Horario[] newArray(int size) {
            return new Horario[size];
        }
    };

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dia);
        parcel.writeString(horaInicio);
        parcel.writeString(horaFinal);
    }
}//fin de la clase
