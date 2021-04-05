package Test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

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
		Response response =
		target.path("apirest") //indicamos el PATH   
		//target.path("apirest")
		.path("mensaje").//Se pueden concatenar llamadas al metodo PATH
		request().// Creamos el request al path definido (devuelve un constructor (builder) de requests)
		accept(MediaType.TEXT_HTML).// Al builder le indicamos el tipo de la respuesta que aceptamos(opcional)
		//como quiero que me muestre la respuesta
		get(Response.class);//al builder le decimos que construya un get request y le indicamos en que tipo de objeto queremos que nos empaquete la respuesta

		//Convertimos la respuesta en un String para poder visualizar sus atributos
		String respuesta = response.toString();
		System.out.println(respuesta);//cabecera del http
		//Misma solicitud esperando un html y empaquetandolo en un String
		String htmlAnswer= target.path("apirest") 
				//target.path("apirest")
				//.path("yojson")mensaje
				.path("mensaje")
				.request()
				.accept(MediaType.TEXT_HTML)
				.get(String.class);
		System.out.println(htmlAnswer);
		
		
}
	
	private static URI getBaseURI() {
		//Construimos un Objeto URI(que representa una URL) con //dirección a nuestro proyecto
		return UriBuilder.fromUri("http://localhost:8080/MensajeSecretoIPURL").build();
				//UriBuilder.fromUri("http://localhost:8080/PrimerRest").build();
		
	}
}
