package ac.ucr.tutoticos.modelo;

import java.util.Date;

public class Horario {

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

}//fin de la clase
