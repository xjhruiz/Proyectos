package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btnregistro, btnincio;
    ProgressBar progressBar;
    //public static final String urlBase ="http://192.168.1.122:8080/Anunciate/";
    UrlBase globalUrl ;
    EditText textUsername;
    EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        globalUrl  = (UrlBase)getApplicationContext();
        prepareUI();
        btnregistro = (Button) findViewById(R.id.registro);
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
        });

        btnincio = (Button) findViewById(R.id.inicio);
        btnincio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUsuarios lu = new LoginUsuarios();
                String nombre = textUsername.getText().toString();
                String pass = textPassword.getText().toString();
                lu.execute(nombre,pass);
            }
        });


    }


    class LoginUsuarios extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {
            String username = strings[0];
            String password = strings[1];
            String url = globalUrl.getUrlBase();
            Log.i("La url es",url);
            Map<String, String> parametros = new HashMap<>();
            String servicio ="login";
            parametros.put("username", username);
            parametros.put("password", password);
            return HttpRequest.get(url+servicio, parametros, true).accept("application/json").body();
        }

        @Override
        protected void onPostExecute(String usuario) {
            Gson gson = new GsonBuilder().create();
            if(!usuario.isEmpty()) {
                Usuario u = gson.fromJson(usuario, Usuario.class);
                Toast.makeText(MainActivity.this,"Bienvendio "+ u.getUserName(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("nombre1",u.getUserName().toString());
                intent.putExtra("password1",u.getPassword().toString());
                Log.i("nomb",u.getUserName());
                Log.i("pass",u.getPassword());
                startActivity(intent);

            }else{
                Toast.makeText(MainActivity.this, "Este usuario no existe", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        }
    }
    private void prepareUI() {
        textUsername = (EditText) findViewById(R.id.editText);
        textPassword = (EditText) findViewById(R.id.editText2);
        progressBar =(ProgressBar) findViewById(R.id.progressBar);
    }
}