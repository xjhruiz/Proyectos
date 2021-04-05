package apirest;

import java.time.LocalDate;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entities.Persona;
import negocio.GestionPersona;

@Path("/")
public class HolaJSON {
	static GestionPersona gestionPersona;
	
	public HolaJSON() {
		// TODO Auto-generated constructor stub
		 gestionPersona =  new GestionPersona();
	}
	
	
//	Persona persona;
	Persona e = new Persona();
	@Path("/yo")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getNombre() {
		return "<h1> Yo soy "+e.getNombre() +" "+e.getApellido()+ "</h1>";
	}
	
	@Path("/yojson")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public String getNombreJSON() {
		return "{\"nombre\":\""+e.getNombre()+ "\","
				+"\"apellido\":\""+e.getApellido()+"\","
				+"\"edad\":\""+e.getAnio()+"\","
				+ "\"altura\":\""+e.getAltura() + "\"}";
	}
	// se pone la edad en la url
	@Path("/yojson/{edad}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public  String getFecha(@PathParam("edad") int año) {
		LocalDate a= LocalDate.now();
		año=a.getYear()-año;
		int edad=e.getAnio()-año;
		return "{\"nombre\":\""+e.getNombre()+ "\","
		+"\"apellido\":\""+e.getApellido()+"\","
		//+"\"edad\":\""+(año -e.getAnio)+"\","
		+"\"edad\":\""+(edad)+"\","
		+ "\"altura\":\""+e.getAltura()+ "\"}";
		
	}
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.TEXT_HTML)
	public String comoquiera(@QueryParam("nombre")String n, @QueryParam("apellido") String a,@QueryParam("edad") int b,@QueryParam("altura") double c) {
	Persona persona=new Persona(n, a, b, c);
	
		return "<h1> hola "+ n+ " " + a + " como estas ? </h1>"
				+ "<br>"
				+ "<h1>  "+ b +" " + c + " "; 
	}
	@GET
	@Path("/crearPersona")
	@Produces(MediaType.TEXT_HTML)
	public static String crearPersona( @QueryParam("nombre")String n, @QueryParam("apellido") String a,@QueryParam("edad") int b,@QueryParam("altura") double c) {
		Persona persona = new Persona(n,a,b,c);
		
		gestionPersona.crearPersona(persona);
		
		return "<h1> Bienvenido  "+ n + " " + a + " "+ b+" " + c+" </h1>" ; 
	}
	
	@POST
	@Path("/crearPersonaPost")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public static String crearPersonaPOSTHTML(@FormParam("nombre")String n, @FormParam("apellido") String a,@FormParam("edad") int b,@FormParam("altura") double c) {
		Persona persona = new Persona(n,a,b,c);
		System.out.println(persona.getNombre());
		gestionPersona.crearPersona(persona);
		
		return "<h1> Bienvenido ulytukyt "+ n + " " + a + " "+ b+" " + c+" </h1>" ; 
	}
}
