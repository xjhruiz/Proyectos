package servicios;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entities.Anuncio;

import entities.Usuario;
import negocio.GestionAnuncio;
import negocio.GestionUsuario;

@Path("/")
public class Rest {

	GestionUsuario gu;
	GestionAnuncio ga;
	
	public Rest() {
		// TODO Auto-generated constructor stub
		gu = new GestionUsuario();
		ga = new GestionAnuncio();
	}
	
	@Path("/registro")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String registroUsuario(Usuario u) {
		String mensaje =" ";
		if(gu.registroUsuario(u)) {
			mensaje="OK";
		}else {
			mensaje="ERROR";
		}
		return mensaje;
	}
	
	@Path("/login")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario login(@QueryParam("username") String username, @QueryParam ("password")String password) {
		Usuario u = gu.getUsuarioLogin(username, password);
		if(u==null) {
			return u=null;
		}else {
			return u;
		}
	}
	@Path("/crearAnuncio")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String crearAnuncio (@QueryParam("username")String username , @QueryParam("password") String password,Anuncio a) {
		Usuario logado = gu.getUsuarioLogin(username, password);
		String mensaje="";
		LocalDateTime fecha =LocalDateTime.now();
		if(logado ==null) {
			mensaje ="ERROR";
		}else {
			a.setAutor(logado);
			a.setFechaAnuncio(fecha);
			ga.persist(a);
			mensaje="OK";
		}
		return mensaje;
	}

	@Path("/anuncios")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> verAnuncios(){
		return ga.getAnuncios();
	}
	
}
