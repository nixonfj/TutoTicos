package ac.ucr.tutoticos.modelo;

import android.graphics.Bitmap;

public class Estudiante extends Cuenta{

    public Estudiante(String idCuenta, String nombreUsuario, String nombre, String apellido, String correoUsuario, String contrasenna, int tipoCuenta, Bitmap imgUser) {
        super(idCuenta, nombreUsuario, nombre, apellido, correoUsuario, contrasenna, tipoCuenta, imgUser);
    }//fin con

    public Estudiante() {
    }//fin sin



}//fin de la clase

