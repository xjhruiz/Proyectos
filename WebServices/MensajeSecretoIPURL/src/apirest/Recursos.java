package apirest;

import java.awt.Window.Type;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Recursos {

	String mensaje ="Hola Persona, estas lleyendo el mensaje secreto ;) ";
	//"{\"mensaje\":\""+this.mensaje+ "\"}"
	@Path("/mensaje")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String mensaje() {
		return "<h1> " + this.mensaje + "</h1>"; 
		
	}
}
