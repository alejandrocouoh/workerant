package entidades;

public class Proveedor extends Persona{
    private int Id_proveedor;
    private String[] Oficios;
    private String[] Servicios;
    private String RFC;
    private String Razon_social;
    private String[] Habilidades;
    private String Formacion;
    private String Experiencia;

    public Proveedor(){

    }

    public Proveedor(int id, String oficios[],String servicios[], String rfc, String razon_social,
                     String habilidades[], String formacion, String experiencia){
            this.setId_proveedor(id);
            this.setOficios(oficios);
            this.setServicios(servicios);
            this.setRFC(rfc);
            this.setHabilidades(habilidades);
            this.setFormacion(formacion);
            this.setExperiencia(experiencia);
    }

    public int getId_proveedor() {
        return Id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        Id_proveedor = id_proveedor;
    }

    public String[] getOficios() {
        return Oficios;
    }

    public void setOficios(String[] oficios) {
        Oficios = oficios;
    }

    public String[] getServicios() {
        return Servicios;
    }

    public void setServicios(String[] servicios) {
        Servicios = servicios;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getRazon_social() {
        return Razon_social;
    }

    public void setRazon_social(String razon_social) {
        Razon_social = razon_social;
    }

    public String[] getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        Habilidades = habilidades;
    }

    public String getFormacion() {
        return Formacion;
    }

    public void setFormacion(String formacion) {
        Formacion = formacion;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String experiencia) {
        Experiencia = experiencia;
    }
}
