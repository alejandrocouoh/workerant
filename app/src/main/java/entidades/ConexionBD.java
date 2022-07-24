package entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    protected Connection con;
    protected Statement stmt;
    protected ResultSet rs;
    String conector, servidor, usuario, pass;
    int retorno = 0;

    public ConexionBD() {
        conector = "com.mysql.cj.jdbc.Driver";
        servidor = "jdbc:mysql://127.0.0.1:3310/workerants";
        usuario = "root";
        pass = "";
        /*try {
            Class.forName(conector);
            con = DriverManager.getConnection(servidor, usuario, pass);
            System.out.println("<-----"+conector+" "+servidor+" "+ usuario+" "+pass+"----->");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }

    public void conectar(){
        System.out.println("Referencia1");
        try {
            System.out.println("Referencia2");
            Class.forName(conector);
            System.out.println("Referencia3");
            con = DriverManager.getConnection(servidor, usuario, pass);
            System.out.println("<-----"+conector+" "+servidor+" "+ usuario+" "+pass+"----->");
            //con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3310/workerants", "root", "");
            System.out.println("Referencia4");
            stmt = con.createStatement();
            System.out.println("Conetada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrar(){
        System.out.println("<-----"+conector+" "+servidor+" "+ usuario+" "+pass+"----->");
    }

    public void mostrar(String cadena){
        System.out.println(cadena);
    }

    public int guardar(String i) {
        try {
            retorno = stmt.executeUpdate(i);
        }catch (Exception exception){
            System.out.println(exception);
        }
        return retorno;
    }

    public void guardar(String correo, String pass, String movil) {
        String sentenciasql = "INSER INTO cuentas (email,password,celular) VALUES (?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sentenciasql);
            p.setString(1,correo);
            p.setString(2,pass);
            p.setString(3,movil);
            p.executeQuery();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ResultSet consulta(String instruccion) throws SQLException{
        return rs = stmt.executeQuery(instruccion);
    }

    public void cerrarBD(){
        try{
            stmt.close();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }

}
