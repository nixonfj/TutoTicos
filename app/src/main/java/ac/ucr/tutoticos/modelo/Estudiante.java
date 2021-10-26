package ac.ucr.tutoticos.modelo;

import android.net.Uri;

public class Estudiante extends Cuenta{

    public Estudiante(int idCuenta, String nombreUsuario, String nombreCompleto, String correoUsuario, String contrasenna, int tipoCuenta, Uri imgUser) {
        super(idCuenta, nombreUsuario, nombreCompleto, correoUsuario, contrasenna, tipoCuenta/*, imgUser*/);
    }

}//fin de la clase

