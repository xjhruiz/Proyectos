package servicios;

import java.time.LocalDate;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.PeliculaEclipse;
import negocio.GestionPelicula;

@Path("/")
public class Rest {

	@Path("/peli")
	@GET
	//@Produces(MediaType.APPLICATION_ATOM_XML)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
	public PeliculaEclipse getPersona() {
		PeliculaEclipse p = new PeliculaEclipse(1,"Matrix " ,"Ficción",LocalDate.now(),"Duró 120 minutos " ,8,"Una pelicula muy buena" );
		return p;
	}
	
	@Path("/pelipost")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String crearPeliculaPost(PeliculaEclipse pelicula) {
		GestionPelicula gt = new GestionPelicula();
		gt.crearPelicula(pelicula);
		return "Ok";
	}
}
