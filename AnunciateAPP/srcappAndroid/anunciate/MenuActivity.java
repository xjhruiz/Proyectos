package com.example.jhonatan.anunciate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class MenuActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar2;
    Button btnanuncio;
    private ListView listView;
    //final static String url ="http://192.168.1.122:8080/Anunciate/anuncios";
    UrlBase globalUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        globalUrl  = (UrlBase)getApplicationContext();

        CargarAnuncios ca = new CargarAnuncios();
        ca.execute();

        Intent intent = getIntent();
        final String usuarioName= intent.getStringExtra("nombre1");
        final String usuarioPassword= intent.getStringExtra("password1");
        final String usuarioName2= intent.getStringExtra("publicadonombre");
        final String usuarioPassword2= intent.getStringExtra("publicadopass");

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.escribiranuncioItem:
                        Intent intent = new Intent(MenuActivity.this, PublicarAnuncio.class);
                        intent.putExtra("nombre2",usuarioName);
                        intent.putExtra("password2",usuarioPassword);
                        intent.putExtra("nombre5",usuarioName2);
                        intent.putExtra("password5",usuarioPassword2);
                        startActivity(intent);
                        break;

                    case R.id.misAnuncios:
                        Intent intent2 = new Intent(MenuActivity.this, MisAnuncios.class);
                        intent2.putExtra("nombre2",usuarioName);
                        intent2.putExtra("password2",usuarioPassword);
                        startActivity(intent2);
                        //Toast.makeText(MenuActivity.this,"Se selecciono buscar",Toast.LENGTH_LONG).show();
                        break;

                    case R.id.perfilItem:
                        Intent intent3 = new Intent(MenuActivity.this, PerfilUsuario.class);
                        intent3.putExtra("nombreperfil",usuarioName);
                        startActivity(intent3);
                        break;

                    case R.id.actualizar:
                        CargarAnuncios ca = new CargarAnuncios();
                        ca.execute();
                        break;

                    case R.id.salir:
                        Toast.makeText(MenuActivity.this,"Cerrando sesión.",Toast.LENGTH_LONG).show();
                        finish();
                        break;
                }


                return true;
            }
        });

       /*bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               if(item.getItemId()==R.id.escribiranuncioItem){
                   //llevar a publicar pagina
                   Intent intent = new Intent(Menu.this, PublicarAnuncio.class);
                   intent.putExtra("nombre2",usuarioName);
                   intent.putExtra("password2",usuarioPassword);
                   startActivity(intent);
               }else if(item.getItemId()==R.id.buscarItem){
                   Intent intent = new Intent(MenuActivity.this, PublicarAnuncio.class);
                   startActivity(intent);
                   Toast.makeText(MenuActivity.this,"Se selecciono buscar",Toast.LENGTH_LONG).show();
               }else if(item.getItemId()==R.id.perfilItem){
                   Intent intent = new Intent(MenuActivity.this, PerfilUsuario.class);
                   startActivity(intent);
                   //llevar a perfil de usuario con los datos a modificar (no modificables username)
                   Toast.makeText(MenuActivity.this,"Se selecciono perfil",Toast.LENGTH_LONG).show();
               }else if(item.getItemId()==R.id.salir){
                   Toast.makeText(MenuActivity.this,"Cerrando sesión.",Toast.LENGTH_LONG).show();
                   finish();
               }
               return true;
           }
       });*/


    }

    class CargarAnuncios extends AsyncTask<Void, Void ,List<Anuncio> > {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected List<Anuncio> doInBackground(Void... params) {
            List<Anuncio> lista;
            String url =globalUrl.getUrlBase();
            String servicio = "anuncios";
            String respuesta = HttpRequest.get(url+servicio,true).acceptJson().body();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm ").create();
            
            lista=gson.fromJson(respuesta,new TypeToken<List<Anuncio>>(){}.getType());
            return lista;
        }



        @Override
        protected void onPostExecute(List<Anuncio> anuncios) {
            mostrarAnuncios(anuncios);

        }
    }

    private void mostrarAnuncios(List<Anuncio> anuncios) {
        listView = (ListView) findViewById(R.id.listView);
        ListAdapter adapter = new AdaptadorAnuncios(MenuActivity.this,anuncios);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Anuncio anuncio =(Anuncio)parent.getItemAtPosition(position);
                Intent intent = new Intent(MenuActivity.this,DetallesAnuncios.class);
                intent.putExtra("idAnuncio",anuncio.getId());
                intent.putExtra("funcionlaboral",anuncio.getFuncionLaboral());
                intent.putExtra("fechaAnuncio",anuncio.getFechaAnuncio());
                intent.putExtra("pago",anuncio.getPago());
                intent.putExtra("direccion",anuncio.getDireccion());
                intent.putExtra("ciudad",anuncio.getCiudad());
                intent.putExtra("jornada",anuncio.getJornada());
                intent.putExtra("detalles",anuncio.getDetalles());
                intent.putExtra("estado",anuncio.getEstado());
                intent.putExtra("autor",anuncio.getAutor().getUserName());
                Intent intent2 = getIntent();
                //Detalles Notica Inscribirse
               String usuarioName = intent2.getStringExtra("nombre1");
               String usuarioPassword= intent2.getStringExtra("password1");
                intent.putExtra("nombre3",usuarioName);
                intent.putExtra("password3",usuarioPassword);
                Log.i("NOmbre User",usuarioName);
                Log.i("Passowor User", usuarioPassword);
                startActivity(intent);

            }
        });
    }
/*
    public void desaparecerLista(){
        listView = (ListView) findViewById(R.id.listView);
        listView.setVisibility(View.INVISIBLE);
    }
*/
}
