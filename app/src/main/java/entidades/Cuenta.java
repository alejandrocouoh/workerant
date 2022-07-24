package entidades;

public class Cuenta {

    private String correo;
    private String movil;
    private String password;

    public Cuenta(String correo, String movil, String password) {
        this.correo = correo;
        this.movil = movil;
        this.password = password;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMovil() {
        return movil;
    }

    public String getPassword() {
        return password;
    }
}
