package recursos;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
public class HelloWordResourse {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHolaMundo() {
	return "{\"saludo\":\"Hello Word\" , }";
	}
	//Direccion
	@Path("/customized/{name}/{apellido}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHolaMundoPersonalizado(@PathParam("name") String nombre, @PathParam("apellido") String apellido) {
		return "<h1>Hola "+nombre +"</h1>";
	}
}
