package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class Opinar extends AppCompatActivity {
    public static final String urlBase ="http://192.168.1.122:8080/Anunciate/";
    EditText mensajeopinion;
    RatingBar puntuacion;
    Button btnCrearOpinion;
    Integer getCal;
    TextView criticado;
    UrlBase globalUrl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinar);
        prepareUI();
        globalUrl =(UrlBase)getApplicationContext();
        Intent intent = getIntent();
        final String usuarioAcriticar = intent.getStringExtra("usuarioCriticado");
        final String username = intent.getStringExtra("nombre4");
        final String userpassword= intent.getStringExtra("passoword4");
        criticado.setText("¿Que le ha parecido "+usuarioAcriticar.toString()+" ?");
       puntuacion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               getCal = (int) rating;
               Log.i("calificacion",""+getCal);
           }
       });
        btnCrearOpinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = mensajeopinion.getText().toString();
                if(valirMensaje(mensaje)){
                    Integer calificacion = (int)puntuacion.getRating();
                    Opinion o = new Opinion();
                    o.setMensaje(mensaje);
                    o.setPuntuacion(calificacion);
                    CrearOpinion crearOpinion = new CrearOpinion();
                    crearOpinion.execute(o);
                    finish();


                }else{
                    Toast.makeText(Opinar.this,"Falta algún dato",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void prepareUI(){
        criticado = (TextView) findViewById(R.id.criticado);
        mensajeopinion = (EditText) findViewById(R.id.etopinion);
        puntuacion = (RatingBar) findViewById(R.id.ratingOpinion);
        btnCrearOpinion = (Button) findViewById(R.id.btncrearOpinion);
    }

    public boolean valirMensaje(String mensaje){
        boolean correcto = true;
        if(mensaje.isEmpty()){
            Toast.makeText(Opinar.this, "Por favor introduzca un mensaje ", Toast.LENGTH_SHORT).show();
            correcto = false;
        }else if(mensaje.length()>200){
            Toast.makeText(Opinar.this, "El mensaje no puede superar los 200 caracteres ", Toast.LENGTH_SHORT).show();
            correcto = false;
        }
        return correcto;
    }
    class CrearOpinion extends AsyncTask<Opinion,Void,Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Opinion... params) {
            Opinion o = params[0];
            Intent intent = getIntent();
            String usuarioAcriticar = intent.getStringExtra("usuarioCriticado");
            String username = intent.getStringExtra("nombre4");
            String userpassword= intent.getStringExtra("passoword4");
            Gson gson = new GsonBuilder().create();
            String datosOpinion = gson.toJson(o);
            Map<String, String> parametros = new HashMap<>();
            parametros.put("username",username.toString());
            parametros.put("password",userpassword.toString());
            parametros.put("nombre",usuarioAcriticar.toString());
            String url = globalUrl.getUrlBase();
            String servicio = "opinar";
            int code = HttpRequest.put(url+servicio,parametros,true).contentType("application/Json").send(datosOpinion).code();

            if(code==200){
                return true;
            }else{
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                Toast.makeText(Opinar.this, "Se ha creado correctamente", Toast.LENGTH_SHORT).show();

                Intent intent = getIntent();
                String usuarioAcriticar = intent.getStringExtra("usuarioCriticado");
                String username = intent.getStringExtra("nombre4");
                String userpassword= intent.getStringExtra("passoword4");
                Intent intent2 = new Intent(Opinar.this,MenuActivity.class);
                intent2.putExtra("nombre1",username);
                intent2.putExtra("password1",userpassword);
                startActivity(intent2);
            }else{
                Toast.makeText(Opinar.this, "Error, Contacte con el administrador ", Toast.LENGTH_SHORT).show();

            }

        }
    }
}
