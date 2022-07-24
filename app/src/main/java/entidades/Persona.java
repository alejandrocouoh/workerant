package entidades;

public class Persona {
    private String Nombres;
    private String Apellidos;
    private String Direccion;
    private int Edad;
    private String Genero;

    public Persona(String nombres, String apellidos, String direccion, int edad, String genero){
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setDireccion(direccion);
        this.setEdad(edad);
        this.setGenero(genero);
    }

    public Persona() {

    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }
}
