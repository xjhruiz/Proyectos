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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class PublicarAnuncio extends AppCompatActivity {

    EditText txtFuncionLaboral, txtPago,txtDireccion,txtCiudad,txtJornada,txtDetalles,txtEtiquetas;
    Button btnpublicar ;
    Intent intent;
    UrlBase globalUrl;
    //public static final String urlBase ="http://192.168.1.122:8080/Anunciate/crearAnuncio";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_anuncio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tbanucio);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        prepareUI();

        btnpublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(anunciar()){
                    Toast.makeText(PublicarAnuncio.this,"Se ha creado un anuncio",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(PublicarAnuncio.this,"Falta algún dato",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public boolean anunciar(){
        String funcion = txtFuncionLaboral.getText().toString();
        String pago = txtPago.getText().toString();
        String direccion = txtDireccion.getText().toString();
        String ciudad = txtCiudad.getText().toString();
        String jornada = txtJornada.getText().toString();
        String detalles = txtDetalles.getText().toString();
        String etiquetas = txtEtiquetas.getText().toString();
        Anuncio anuncio = new Anuncio();
        anuncio.setFuncionLaboral(funcion);
        anuncio.setPago(pago);
        anuncio.setDireccion(direccion);
        anuncio.setCiudad(ciudad);
        anuncio.setJornada(jornada);
        anuncio.setDetalles(detalles);
        anuncio.setEtiquetas(etiquetas);


        if(validarAnuncio(funcion,pago,direccion,ciudad,jornada,etiquetas)){
            CrearAnuncio ca = new CrearAnuncio();
            ca.execute(anuncio);
            return true;
        }else{
            return false;
        }
    }


    public boolean validarAnuncio(String funcion,String pago,String direccion,String ciudad,String jornada,String etiquetas){
        boolean correcto = true;
        if(funcion.isEmpty()){
            Toast.makeText(PublicarAnuncio.this, "Tiene que especificar que funcion se realizá", Toast.LENGTH_SHORT).show();
            correcto = false;
        }else if(pago.isEmpty()){
            Toast.makeText(PublicarAnuncio.this, "Tiene que especificar el dinero a cambio de hacer esta tarea", Toast.LENGTH_SHORT).show();
            correcto = false;
        }else if(direccion.isEmpty()){
            Toast.makeText(PublicarAnuncio.this, "Por favor, Introduzca una dirección.", Toast.LENGTH_SHORT).show();
            correcto = false;
        }else if(ciudad.isEmpty()){
            Toast.makeText(PublicarAnuncio.this, "Por favor, Introduzca una ciudad.", Toast.LENGTH_SHORT).show();
            correcto = false;
        }else if(jornada.isEmpty()){
            Toast.makeText(PublicarAnuncio.this, "Indique el horario de la tarea , Tarde ,Mañana , Noche ", Toast.LENGTH_SHORT).show();
            correcto = false;
        }else if(etiquetas.isEmpty()) {
            Toast.makeText(PublicarAnuncio.this, "Por favor, Indique el campo asociado a esta tarea.", Toast.LENGTH_SHORT).show();
            correcto = false;
        }
        return  correcto;
    }

    public void prepareUI(){
        txtFuncionLaboral= (EditText) findViewById(R.id.anulabor);
        txtPago = (EditText) findViewById(R.id.anupago);
        txtDireccion = (EditText) findViewById(R.id.anudireccion);
        txtCiudad = (EditText) findViewById(R.id.anuciudad);
        txtJornada = (EditText) findViewById(R.id.anujornada);
        txtDetalles = (EditText) findViewById(R.id.anudetalles);
        txtEtiquetas=(EditText) findViewById(R.id.anuetiquetas);
        btnpublicar = (Button) findViewById(R.id.anunciar);
    }

    class CrearAnuncio extends AsyncTask<Anuncio,Void,Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Anuncio... params) {
            Anuncio anuncio = params[0];
            intent = getIntent();
            String nombre = intent.getStringExtra("nombre2");
            String password = intent.getStringExtra("password2");
            Gson gson = new GsonBuilder().create();
            String datosAnuncios = gson.toJson(anuncio);
            Map<String, String> parametros = new HashMap<>();
            parametros.put("username", "" + nombre);
            parametros.put("password", "" + password);
            Log.i("El twee tiene ", datosAnuncios);
            String url = globalUrl.getUrlBase();
            String servicio = "crearAnuncio";
            int code = HttpRequest.put(url+servicio, parametros, true).contentType("application/Json").send(datosAnuncios).code();

            if (code == 200) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean) {
                Toast.makeText(PublicarAnuncio.this, "Se ha publicado con éxito", Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                String nombre = intent.getStringExtra("nombre2");
                String password = intent.getStringExtra("password2");
                Intent intent1 = new Intent(PublicarAnuncio.this,MenuActivity.class);
                intent1.putExtra("nombre1",nombre);
                intent1.putExtra("password1",password);
                startActivity(intent1);
            } else {
                Toast.makeText(PublicarAnuncio.this, "Error, Contacte con el administrador ", Toast.LENGTH_SHORT).show();

            }
            super.onPostExecute(aBoolean);
        }
    }
}
