package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PerfilUsuario extends AppCompatActivity {
    //final static String urlBase ="http://192.168.1.122:8080/Anunciate/";
    Intent intent;
    EditText etPerfilNombre, etCiudad, etTelefono, etEmail,etContraseña;
    UrlBase globalUrl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        globalUrl =(UrlBase)getApplicationContext();
        intent = getIntent();
        String username = intent.getStringExtra("nombreperfil");
        LogPerfilUser logPerfilUser = new LogPerfilUser();
        logPerfilUser.execute(username);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbperfil);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class LogPerfilUser extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected String doInBackground(String... strings) {
            String username = strings[0];
            String url = globalUrl.getUrlBase();
            String servicio = "perfilusuario/" + username.toString();
            return HttpRequest.get(url + servicio, true).accept("application/json").body();
        }

        @Override
        protected void onPostExecute(String usuario) {
            Gson gson = new GsonBuilder().create();
            Usuario u = gson.fromJson(usuario, Usuario.class);
            etPerfilNombre = (EditText)findViewById(R.id.perfilnombre);
            etPerfilNombre.setText(u.getNombreApellidos());
            etCiudad = (EditText) findViewById(R.id.perfilciudad);
            etCiudad.setText(u.getCiudad());
            etTelefono = (EditText) findViewById(R.id.perfiltelefono);
            etTelefono.setText(u.getTelefono());
            etEmail = (EditText) findViewById(R.id.perfilEmail);
            etEmail.setText(u.getEmail());
            etContraseña = (EditText) findViewById(R.id.perfilcontra);
            etContraseña.setText(u.getPassword());



        }

    }

}
