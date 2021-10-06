package ac.ucr.tutoticos.modelo;

public class Cuenta {

    int idCuenta;
    String nombreUsuario, nombreCompleto, correoUsuario, contrasenna;
    int tipoCuenta;

    public Cuenta(int idCuenta, String nombreUsuario, String nombreCompleto, String correoUsuario, String contrasenna, int tipoCuenta) {
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correoUsuario = correoUsuario;
        this.contrasenna = contrasenna;
        this.tipoCuenta = tipoCuenta;
    }//fin constructor con

    public Cuenta() {
        this.idCuenta = 0;
        this.nombreUsuario = "";
        this.nombreCompleto = "";
        this.correoUsuario = "";
        this.contrasenna = "";
        this.tipoCuenta = 0;
    }//fin constructor sin

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
    public String toString() {
        return "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correoUsuario='" + correoUsuario + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                ", tipoCuenta=" + tipoCuenta;
    }
}//fin de la clase
