package com.example.workerant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {

   private TextView TV_email, TV_password;
   String email, password;
    StringRequest requestq;
    RequestQueue request;
    private static final String URL1="http://192.168.0.3/workerants/instrucciones/login.php";
    Intent perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV_email = findViewById(R.id.editTextText_User);
        TV_password = findViewById(R.id.editText_Pass);
        perfil = new Intent(this, MainActivity2_perfil.class);
    }

    public void Registrar(View view){
        Intent registrar = new Intent(this, MainActivity2_Registro.class);
        startActivity(registrar);
        finish();
    }

    public void Login(View view){
        email = TV_email.getText().toString();
        password = TV_password.getText().toString();
        if(email.isEmpty() /*&& Patterns.EMAIL_ADDRESS.matcher(email).matches()*/){
            Toast.makeText(this, "Introdusca un correo valido",Toast.LENGTH_SHORT).show();
        }else if(password.isEmpty()){
            Toast.makeText(this, "Contraseña no valida para el usuario",Toast.LENGTH_SHORT).show();
        }else{
            requestq = new StringRequest(Request.Method.POST, URL1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(MainActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                    startActivity(perfil);
                    finish();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "No se pudo iniciar la sesion", Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                   Map<String,String> parametros = new HashMap<>();
                   parametros.put("email", email);
                   parametros.put("password", password);
                    return super.getParams();
                }
            };
            request = Volley.newRequestQueue(MainActivity.this);
            request.add(requestq);
        }
    }
}