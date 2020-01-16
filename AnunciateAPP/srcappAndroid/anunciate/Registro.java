package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    Button btnregistrado, btnCancelar;
    EditText textUsername, textPass, textPassRep,textEmail,textNombre,textTelefono,textCiudad;
    public static final String urlBase ="http://192.168.1.122:8080/Anunciate/registro";
    UrlBase globalUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        prepareUI();
        globalUrl = (UrlBase) getApplicationContext();
        btnregistrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(crearUsuario()){

                }else{
                    Toast.makeText(Registro.this,"No se ha podido registrar. Contacte con el administrador",Toast.LENGTH_LONG).show();

                }


            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public  boolean validacion(String username, String password,String repetirpass, String email,String ciudad ){
        boolean correcto = true;
        if(username.isEmpty() || username.length()<=4){
            Toast.makeText(Registro.this,"Introduzca un usuario con más de cuatro digitos",Toast.LENGTH_SHORT).show();
            correcto = false;
        }if(password.isEmpty() || password.length()<5 || !password.equals(repetirpass) || !repetirpass.equals(password) || repetirpass.isEmpty() || repetirpass.length()<7){
            Toast.makeText(Registro.this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
            correcto = false;
        }if(!validarEmail(email)){
            Toast.makeText(Registro.this,"Introduzca una Email correcto. Recuerde ejemplo@xxx.xxx",Toast.LENGTH_SHORT).show();
            correcto = false;
        }if(ciudad.isEmpty()){
            Toast.makeText(Registro.this,"Introduzca una ciudad",Toast.LENGTH_SHORT).show();
            correcto = false;
        }


        return correcto;
    }
    public boolean validarEmail(String email){
        String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private void prepareUI(){
        textUsername = (EditText) findViewById(R.id.usuariousername);
        textPass = (EditText) findViewById(R.id.usuariopassword);
        textPassRep = (EditText) findViewById(R.id.usuariopasswordrep);
        textEmail = (EditText) findViewById(R.id.usuarioemail);
        textNombre = (EditText) findViewById(R.id.usuarionombreapellido);
        textTelefono = (EditText) findViewById(R.id.usuariotelefono);
        textCiudad = (EditText) findViewById(R.id.usuariociudad);
        btnregistrado = (Button) findViewById(R.id.registrarse);
        btnCancelar = (Button) findViewById(R.id.cancelar);

    }
    public boolean crearUsuario(){
        String datoUsername = textUsername.getText().toString().trim();
        String datoPass = textPass.getText().toString().trim();
        String datoPassRep = textPassRep.getText().toString().trim();
        String datoEmail = textEmail.getText().toString();
        String datoNombre = textNombre.getText().toString();
        String datoTelefono = textTelefono.getText().toString();
        String datoCiudad = textCiudad.getText().toString();
        Usuario user = new Usuario();
        user.setUserName(datoUsername);
        user.setPassword(datoPass);
        user.setEmail(datoEmail);
        user.setNombreApellidos(datoNombre);
        user.setTelefono(datoTelefono);
        user.setCiudad(datoCiudad);

        if(validacion(datoUsername,datoPass,datoPassRep,datoEmail,datoTelefono)){
            RegistrarUsuario gu = new RegistrarUsuario();
            gu.execute(user);
            return true;
        }else{
            Toast toast= Toast.makeText(getApplicationContext(),
                    "No se pudo crear", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            return false;
        }
    }


    class RegistrarUsuario extends AsyncTask<Usuario,Void,Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Boolean doInBackground(Usuario... params) {
            Usuario u = params[0];
            Gson gson = new GsonBuilder().create();
            String usuDatos = gson.toJson(u);
            Log.i("usuDatos tiene", usuDatos);
            //int code = HttpRequest.put("http://192.168.1.105:8080/TwEEPter/usuarios/registrar")
            //        .contentType("application/Json").send(usuDatos).code();
            String url = globalUrl.getUrlBase();
            String servicio ="registro";
            String code = HttpRequest.put(url+servicio)
                    .contentType("application/Json").send(usuDatos).body();
            Log.i("code es ", "" + code);

            if(code.equals("OK")){
                return true;
            }else{
                return false;
            }

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean){
                Toast.makeText(Registro.this,"Se ha registrado correctamente",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Registro.this,MenuActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(Registro.this,"Error ese Usuario ya existe",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
