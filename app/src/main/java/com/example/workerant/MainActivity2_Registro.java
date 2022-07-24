package com.example.workerant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MainActivity2_Registro extends AppCompatActivity {

    private EditText txv_correo;
    private EditText txv_celular;
    private EditText txv_password;
    private EditText txv_validarpass;
    private static final Pattern password = Pattern.compile(
            "^"+"(?=.*[0-9])"+ "(?=.*[a-z])"+"(?=.*[A-Z])"+
                    "(?=.*[@#$%^&+=])"+"(?=\\$+$)"+".{8,}"+"$"
    );
    String email, cel, pass, validarpassword;
    RequestQueue request;
    private static final String URL1="http://192.168.0.2/workerants/instrucciones/insertar.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_registro);
        txv_correo = (EditText) findViewById(R.id.editTextTextEmailAddress_corr);
        txv_celular = (EditText) findViewById(R.id.editTextPhone_cel);
        txv_password = (EditText) findViewById(R.id.editTextTextPassword_pass);
        txv_validarpass = (EditText) findViewById(R.id.editTextTextPassword2);
        request = Volley.newRequestQueue(this);
    }

    public void crearCuenta(View view){
        email = txv_correo.getText().toString();
        cel = txv_celular.getText().toString();
        pass = txv_password.getText().toString();
        validarpassword = txv_validarpass.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Correo electronico invalido",Toast.LENGTH_LONG).show();
        } else if(!cel.isEmpty() && Patterns.PHONE.matcher(cel).matches()){
            Toast.makeText(this, "Numero celular invalido",Toast.LENGTH_LONG).show();
        }else if(!pass.isEmpty() && password.matcher(pass).matches()){
            Toast.makeText(this, "Password no valido",Toast.LENGTH_LONG).show();
        }else if(pass.equals(validarpassword)){
            StringRequest requestq = new StringRequest(
                    Request.Method.POST, URL1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(MainActivity2_Registro.this,
                            "Cuenta creada correctamente",Toast.LENGTH_LONG).show();
                    perfil();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity2_Registro.this,
                            "No se pudo crear la cuenta",Toast.LENGTH_LONG).show();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> parametros = new HashMap<>();
                    parametros.put("email",email);
                    parametros.put("movil",cel);
                    parametros.put("passw",pass);
                    return parametros;
                }
            };
            request.add(requestq);
        }else {
            Toast.makeText(this,"Las contraseñas no son iguales",Toast.LENGTH_LONG).show();
        }

        //sentenciasql = "INSER INTO cuentas (email, password, celular) VALUES ('"+email+"','"+pass+"','"+cel+"')";
        //String sentenciasql = "insert into cuentas (email,password,celular) values ('prueba1','contraseña1','56845525')";
        //sentenciasql = "INSER INTO cuentas (email) VALUES ('"+email+"')";
        //sentenciasql = "INSER INTO cuentas (email,password,celular) VALUES (?,?,?)";

        //conexion.mostrar();
        //conexion.mostrar(sentenciasql);
        /*
        try{
            conexion = new ConexionBD();
            conexion.conectar();
            conexion.guardar(email,pass,cel);
            conexion.cerrarBD();
            //conexion.grabarRegistro(sentenciasql);
            //conexion.cerrarBD();
          /*if (conexion.guardar(sentenciasql)==1) {
                Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_LONG).show();
                conexion.cerrarBD();
            } else {
                Toast.makeText(this, "La cuenta no se pudo crear", Toast.LENGTH_LONG).show();
                conexion.cerrarBD();
            }
        } catch (Exception e){
            System.out.println(e);
        }*/
    }

    public void perfil(){
        Intent perfil = new Intent(this, MainActivity2_perfil.class);
        perfil.putExtra("correo", email);
        perfil.putExtra("movil", cel);
        startActivity(perfil);
        finish();
    }
}