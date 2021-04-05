package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.graphics.Path;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfilUsuarioAnunciante extends AppCompatActivity {
    TextView tvaNombre,tvaCiudad,tvaTelefono,tvaEmail;
    //final static String urlBase ="http://192.168.1.122:8080/Anunciate/";
    ListView listView;
    RecyclerView.LayoutManager layoutManager;
    UrlBase globalUrl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario_anunciante);
        globalUrl =(UrlBase)getApplicationContext();
        Intent intent = getIntent();
        String username = intent.getStringExtra("usernameAnunciante");
        PerfilAnunciante pu = new PerfilAnunciante();
        pu.execute(username);
        VerOpiniones verOpiniones = new VerOpiniones();
        verOpiniones.execute(username);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbperfilAnunciante);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class PerfilAnunciante extends AsyncTask<String, Void, String> {

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
            tvaNombre = (TextView) findViewById(R.id.anombre);
            tvaNombre.setText(u.getNombreApellidos());
            tvaCiudad = (TextView) findViewById(R.id.aciudad);
            tvaCiudad.setText(u.getCiudad());
            tvaTelefono =(TextView) findViewById(R.id.atelefono);
            tvaTelefono.setText(u.getTelefono());
            tvaEmail = (TextView) findViewById(R.id.aEmail);
            tvaEmail.setText(u.getEmail());
        }

    }

    class VerOpiniones extends AsyncTask<String, Void ,List<Opinion>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Opinion> doInBackground(String... params) {

            String username = params[0];
            String servicio="opiniones";
            Map<String, String> parametros = new HashMap<>();
            String url = globalUrl.getUrlBase();
            parametros.put("nombreCriticado",username);
            String respuesta = HttpRequest.get(url+servicio,parametros, true).acceptJson().body();
            Gson gson = new GsonBuilder().create();

            List<Opinion> listaOpiniones = gson.fromJson(respuesta, new TypeToken<List<Opinion>>() {
            }.getType());


            return listaOpiniones;
        }

        @Override
        protected void onPostExecute(List<Opinion> opiniones) {
            if(!opiniones.isEmpty()){
                mostrarOpiniones(opiniones);
            }else{
                Toast.makeText(PerfilUsuarioAnunciante.this,"Este usuario no tiene ninguna opinion",Toast.LENGTH_LONG).show();
            }

        }
    }
    public void mostrarOpiniones(List<Opinion> opiniones){

        listView = (ListView) findViewById(R.id.listaopiniones);
        ListAdapter adapter = new AdaptadorOpiniones(PerfilUsuarioAnunciante.this,opiniones);
        listView.setAdapter(adapter);
    }
}
