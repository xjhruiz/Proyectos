package test;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import entities.PeliculaEclipse;
import entities.PeliculaOMDB;
import negocio.GestionPelicula;

public class Tester {

	public static void main(String[] args) {
		//configuracion 
		//cliente con configuracion
		//objetivo =webTarget representa el servicio webobjetivo
		//creamos la respuesta de la solicitud
		
		//Creamos la configuracion (por defecto)
		ClientConfig config = new ClientConfig();
		//Creamos el cliente rest con la clase ClientBuilder pasandole la config por defecto al metodo newClient
		Client client = ClientBuilder.newClient(config);
		// Creamos el objeto que representa el servicio al que vamos a hacer las solicitudes
		WebTarget target = client.target(getBaseURI());
		//getBaseURI es un método propio que hemos definido más abajo y nos devuelve la url a nuestros servicios.
		
		//para realizar la solicitud:
		/*Pelicula pelidevuelta =
		target.queryParam("t" ,"Guardians of the Galaxy Vol. 2")
		.queryParam("apikey", "6e8adbb8")//indicamos el PATH   
		//target.path("apirest")
		//.path("peli").//Se pueden concatenar llamadas al metodo PATH
		.request().// Creamos el request al path definido (devuelve un constructor (builder) de requests)
		accept(MediaType.APPLICATION_JSON).// Al builder le indicamos el tipo de la respuesta que aceptamos(opcional)
		//como quiero que me muestre la respuesta
		get(Pelicula.class);//al builder le decimos que construya un get request y le indicamos en que tipo de objeto queremos que nos empaquete la respuesta
*/
		
		/*Pelicula peliDevuelta =
		target.path("servicios"). //indicamos el PATH
		path("peli").//Se pueden concatenar llamadas al metodo PATH
		request().// Creamos el request al path definido (devuelve un constructor (builder) de requests)
		accept(MediaType.APPLICATION_JSON).// Al builder le indicamos el tipo de la respuesta que aceptamos(opcional)
		get(Pelicula.class);//al builder le decimos que construya un get request y le indicamos en que tipo de objeto queremos que nos empaquete la respuest atributos
		
		System.out.println(peliDevuelta.getTitulo()+" "+peliDevuelta.getDescripcion());
		*/
		List<PeliculaEclipse>temporadas = new ArrayList<PeliculaEclipse>();
		
		
		/*Pelicula peliDevuelta =
				target.queryParam("i","tt1480055").
				queryParam("apikey", "b5e99b81").
				request().// Creamos el request al path definido (devuelve un constructor (builder) de requests)
				accept(MediaType.APPLICATION_JSON).// Al builder le indicamos el tipo de la respuesta que aceptamos(opcional)
				get(Pelicula.class);//al builder le decimos que construya un get request y le indicamos en que tipo de objeto queremos que nos empaquete la respuest atributos
		*/
		PeliculaEclipse p = new PeliculaEclipse(null,"Intelestellar","Ciencia Ficcion" , LocalDate.now(),"180 min",9.0,"Una rallada!");
		GestionPelicula gestionPelicula = new GestionPelicula();
		//gestionPelicula.crearPelicula(peliDevuelta);
		Response response=target.path("servicios")
				.path("pelipost")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.TEXT_HTML)
				.post(Entity.entity(p,MediaType.APPLICATION_JSON));
		System.out.println(response.toString());
		//System.out.println(peliDevuelta.getTitulo() +" "+ peliDevuelta.getAnio()+" " + peliDevuelta.getLiberado());
		/*//Convertimos la respuesta en un String para poder visualizar sus atributos
		String respuesta = pelidevuelta.toString();
		System.out.println(respuesta);//cabecera del http
		//Misma solicitud esperando un html y empaquetandolo en un String
		/*String htmlAnswer= target.path("api") 
				//target.path("apirest")
				.path("yojson")
				.request()
				.accept(MediaType.APPLICATION_ATOM_XML)
				.get(String.class);
		System.out.println(htmlAnswer);*/		
}
	
	private static URI getBaseURI() {
		//Construimos un Objeto URI(que representa una URL) con //dirección a nuestro proyecto
		//return UriBuilder.fromUri("http://localhost:8080/CineRest/servicios/peli").build();
				//UriBuilder.fromUri("http://localhost:8080/PrimerRest").build();
		return UriBuilder.fromUri("http://localhost:8080/CineRest").build();

	}
}
