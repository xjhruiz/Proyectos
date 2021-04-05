package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MisAnuncios extends AppCompatActivity {
    ListView listView;
    //final static String url ="http://192.168.1.122:8080/Anunciate/";
    UrlBase globalUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_anuncios);
        globalUrl =(UrlBase)getApplicationContext();
        Intent intent = getIntent();
        String username = intent.getStringExtra("nombre2");
        String password = intent.getStringExtra("password2");
        Toast.makeText(this, " " + username + password, Toast.LENGTH_LONG).show();
        CargarMisAnuncios cargarMisAnuncios = new CargarMisAnuncios();
        cargarMisAnuncios.execute(username);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbmisAnuncios);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class CargarMisAnuncios extends AsyncTask<String, Void, List<Anuncio>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Anuncio> doInBackground(String... params) {
            String username = params[0];
            List<Anuncio> lista;
            String url = globalUrl.getUrlBase();
            String servicio ="getMisAnuncios/"+username.toString();

            String respuesta = HttpRequest.get(url+servicio, true).acceptJson().body();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm ").create();
            lista = gson.fromJson(respuesta, new TypeToken<List<Anuncio>>() {}.getType());
            return lista;
        }


        @Override
        protected void onPostExecute(List<Anuncio> anuncios) {
            if(!anuncios.isEmpty()){
                mostrarMisAnuncios(anuncios);
            }else{
                FragmentManager fm =getSupportFragmentManager();
                DialogoAlerta dialogoAlerta = new DialogoAlerta();
                dialogoAlerta.show(fm, "Alerta 1");
            }


        }
    }

    private void mostrarMisAnuncios(List<Anuncio> anuncios) {
        listView = (ListView) findViewById(R.id.listView2);
        final ListAdapter adapter = new AdaptadorMisAnuncios(MisAnuncios.this, anuncios);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Anuncio anuncio =(Anuncio)parent.getItemAtPosition(position);
                Intent intent = new Intent(MisAnuncios.this,DetallesMisAnuncios.class);
                intent.putExtra("miidAnuncio",anuncio.getId());
                intent.putExtra("mifuncionlaboral",anuncio.getFuncionLaboral());
                intent.putExtra("mifechaAnuncio",anuncio.getFechaAnuncio());
                intent.putExtra("mipago",anuncio.getPago());
                intent.putExtra("midireccion",anuncio.getDireccion());
                intent.putExtra("miciudad",anuncio.getCiudad());
                intent.putExtra("mijornada",anuncio.getJornada());
                intent.putExtra("midetalles",anuncio.getDetalles());
                intent.putExtra("miestado",anuncio.getEstado());
                intent.putExtra("miautor",anuncio.getAutor().getUserName());
                Intent intent2 = getIntent();
                //Detalles Notica Inscribirse
                String username = intent2.getStringExtra("nombre2");
                String password = intent2.getStringExtra("password2");
                intent.putExtra("nombre3",username);
                intent.putExtra("password3",password);
                Log.i("NOmbre User",username);
                Log.i("Passowor User", password);
                startActivity(intent);

            }
        });
    }
}
