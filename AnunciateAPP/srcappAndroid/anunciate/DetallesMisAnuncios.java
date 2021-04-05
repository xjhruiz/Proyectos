package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DetallesMisAnuncios extends AppCompatActivity implements DialogoOpinar.OpinarListener {
    private TextView tvFuncion, tvDetalles,tvJornada,tvDireccion,tvCiudad,tvPago,tvFecha;
    Button btnCancelar,btnRealizado;
    EditText etAcriticar;
    Integer idAnuncio;
    //String urlbase = "http://192.168.1.122:8080/Anunciate/";
    UrlBase globalUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_mis_anuncios);
        prepareUI();
        globalUrl  = (UrlBase)getApplicationContext();
        Intent intent = getIntent();
        String stFuncion = intent.getStringExtra("mifuncionlaboral");
        tvFuncion.setText(stFuncion);
        String stDetalles = intent.getStringExtra("midetalles");
        tvDetalles.setText(stDetalles);
        String stJornada = intent.getStringExtra("mijornada");
        tvJornada.setText(stJornada);
        String stDireccion = intent.getStringExtra("midireccion");
        tvDireccion.setText(stDireccion);
        String stCiudad = intent.getStringExtra("miciudad");
        tvCiudad.setText(stCiudad);
        String stPago = intent.getStringExtra("mipago");
        tvPago.setText(stPago);
        String stFecha = intent.getStringExtra("mifechaAnuncio");
        tvFecha.setText("Publicado el "+stFecha);

        //Datos Necesarios para opinar
        final String username = intent.getStringExtra("nombre3");
        String password = intent.getStringExtra("password3");
        idAnuncio = intent.getIntExtra("miidAnuncio",0);

        btnRealizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* FragmentManager fm =getSupportFragmentManager();
                DialogoOpinar dialogoOpinar = new DialogoOpinar();
                dialogoOpinar.show(fm,"Alerta 1");*/
               if(etAcriticar.getText().toString().isEmpty()){
                   FragmentManager fm =getSupportFragmentManager();
                   Alerta2 alerta2 = new Alerta2();
                   alerta2.show(fm,"Alerta 1");
               }else{
                   LogBuscarUsuario lbu = new LogBuscarUsuario();
                   String usuario =etAcriticar.getText().toString();
                   Log.i("usuarioacriticar",usuario);
                   lbu.execute(usuario);
               }

            }
        });

    }

    @Override
    public void opinar() {
        Intent intent2 = getIntent();
        String username = intent2.getStringExtra("nombre3");
        String password = intent2.getStringExtra("password3");
        Intent intent = new Intent(DetallesMisAnuncios.this,Opinar.class);
        intent.putExtra("nombre4",username);
        intent.putExtra("passoword4",password);
        String usuarioCriticado = etAcriticar.getText().toString();
        intent.putExtra("usuarioCriticado",usuarioCriticado);
        Log.i("usuarioCriticado",usuarioCriticado);
        Log.i("password4",password);
        Log.i("nombre4",username);
        startActivity(intent);
    }

    @Override
    public void cerrar() {
        finish();
    }

    @Override
    public void eliminar() {
        EliminarAnuncio eliminarAnuncio = new EliminarAnuncio();
        eliminarAnuncio.execute();
    }


    class EliminarAnuncio extends AsyncTask<Void,Void,Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            Intent intent = getIntent();
            Integer integeridAnuncio = intent.getIntExtra("miidAnuncio",0);
            String url =globalUrl.getUrlBase();
            String servicio ="eliminarAnuncio/"+integeridAnuncio;
            String code = HttpRequest.delete(url+servicio).body();

            if(code.equals("OK")){
               // Toast.makeText(DetallesMisAnuncios.this,"Se ha eliminado",Toast.LENGTH_LONG).show();
                return true;
            }else{
                //Toast.makeText(DetallesMisAnuncios.this," No Se ha eliminado",Toast.LENGTH_LONG).show();

                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
    class LogBuscarUsuario extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... strings) {
            String username = strings[0];
            String url = globalUrl.getUrlBase();
            String servicio = "perfilusuario/" + username;
            return HttpRequest.get(url+servicio, true).accept("application/json").body();
        }

        @Override
        protected void onPostExecute(String usuario) {
            Gson gson = new GsonBuilder().create();
            if(!usuario.isEmpty()){
                Usuario u = gson.fromJson(usuario, Usuario.class);
                Log.i("Usuario" ,u.getUserName());
                FragmentManager fm =getSupportFragmentManager();
                DialogoOpinar dialogoOpinar = new DialogoOpinar();
                dialogoOpinar.show(fm,"Alerta 1");
            }else{
                Toast.makeText(DetallesMisAnuncios.this, "No se ha encontrado este usuario", Toast.LENGTH_LONG).show();

            }
        }

    }


    public void prepareUI(){
        tvFuncion = (TextView) findViewById(R.id.miaFuncion);
        tvDetalles = (TextView) findViewById(R.id.miaDetalles);
        tvJornada = (TextView) findViewById(R.id.miaJornada);
        tvDireccion = (TextView) findViewById(R.id.miaDireccion);
        tvCiudad = (TextView) findViewById(R.id.miaCiudad);
        tvPago = (TextView) findViewById(R.id.miaPago);
        tvFecha = (TextView) findViewById(R.id.miaFecha);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnRealizado = (Button) findViewById(R.id.btnOpinar);
        etAcriticar = (EditText) findViewById(R.id.usernameRealizado);
    }
}
