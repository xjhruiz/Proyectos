package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class DetallesAnuncios extends AppCompatActivity {

    private TextView tvFuncion, tvDetalles,tvJornada,tvDireccion,tvCiudad,tvPago,tvFecha;
    String estadoAnuncio;
    Integer idAnuncio;
    Button btnCancelar,btnVerPerfilde,btnInscribirse;
    String usernameABuscar;
    UrlBase globalUrl;
    //public static final String urlBase ="http://192.168.1.122:8080/Anunciate/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_anuncios);
        prepareUI();
        globalUrl  = (UrlBase)getApplicationContext();
        Intent intent = getIntent();
        String stFuncion = intent.getStringExtra("funcionlaboral");
        tvFuncion.setText(stFuncion);
        String stDetalles = intent.getStringExtra("detalles");
        tvDetalles.setText(stDetalles);
        String stJornada = intent.getStringExtra("jornada");
        tvJornada.setText(stJornada);
        String stDireccion = intent.getStringExtra("direccion");
        tvDireccion.setText(stDireccion);
        String stCiudad = intent.getStringExtra("ciudad");
        tvCiudad.setText(stCiudad);
        String stPago = intent.getStringExtra("pago");
        tvPago.setText(stPago);
        String stFecha = intent.getStringExtra("fechaAnuncio");
        tvFecha.setText("Publicado el "+stFecha);
        //tvUsername.setText(stUsername);
        idAnuncio = intent.getIntExtra("idAnuncio",0);
        estadoAnuncio = intent.getStringExtra("estado");
        //Toast.makeText(this," "+idAnuncio+" "+estadoAnuncio.toString(),Toast.LENGTH_LONG).show();
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final String stUsername = intent.getStringExtra("autor");
        btnVerPerfilde.setHint("Escrito por "+stUsername+" Ver perfil");
        btnVerPerfilde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent1 = new Intent(DetallesAnuncios.this,PerfilUsuarioAnunciante.class);
                intent1.putExtra("usernameAnunciante",stUsername);
                startActivity(intent1);
            }
        });
        btnInscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarEstado();
                finish();
            }
        });
    }

    public void prepareUI(){
        tvFuncion = (TextView) findViewById(R.id.textView10);
        tvDetalles = (TextView) findViewById(R.id.textView11);
        tvJornada = (TextView) findViewById(R.id.textView13);
        tvDireccion = (TextView) findViewById(R.id.textView12);
        tvCiudad = (TextView) findViewById(R.id.textView14);
        tvPago = (TextView) findViewById(R.id.textView15);
        tvFecha = (TextView) findViewById(R.id.textView17);
        //tvUsername = (TextView) findViewById(R.id.textView18);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnVerPerfilde = (Button) findViewById(R.id.btnVerPerfil);
        btnInscribirse = (Button) findViewById(R.id.btninscribirse);
    }

    class SoliciarAnuncio extends AsyncTask<Anuncio , Void,Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Anuncio... params) {
            Anuncio a = params[0];
            Gson gson = new GsonBuilder().create();
            String anuncioDatos= gson.toJson(a);
            Intent intent = getIntent();
            String url=globalUrl.getUrlBase();
            Integer idAnuncio = intent.getIntExtra("idAnuncio",0);
            String servicio = "solicitarAnuncio/"+idAnuncio;
            String code = HttpRequest.put(url+servicio).contentType("application/Json").send(anuncioDatos).body();

            if(code.equals("OK")){
                return true;
            }else{
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Intent intent = getIntent();
            //String username =intent.getStringExtra("nombre3");
            //String password = intent.getStringExtra("password3");

            //Intent intent2 = new Intent(DetallesAnuncios.this,MenuActivity.class);
            //intent2.putExtra("nombre4",username);
           // intent2.putExtra("password4",password);
            //Log.i("Nombre Username" , username.toString());
            //Log.i("Password User", password.toString());
            //startActivity(intent2);


        }
    }
    public void modificarEstado(){
        String datoEstado ="solicitado";
        Anuncio a = new Anuncio();
        a.setEstado(datoEstado);
        SoliciarAnuncio soliciarAnuncio = new SoliciarAnuncio();
        soliciarAnuncio.execute(a);
    }

}
