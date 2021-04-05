package servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.annotations.ParamDef;

import entities.Anuncio;
import entities.Opinion;
import entities.Usuario;
import negocio.GestionAnuncio;
import negocio.GestionOpinion;
import negocio.GestionUsuario;

@Path("/")
public class Rest {

	GestionUsuario gu;
	GestionAnuncio ga;
	GestionOpinion go;
	
	public Rest() {
		// TODO Auto-generated constructor stub
		gu = new GestionUsuario();
		ga = new GestionAnuncio();
		go = new GestionOpinion();
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
			a.setEstado("pendiente");
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
	
	@Path("/getMisAnuncios/{username}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> getTweepPorUsuario(@PathParam("username") String a){
		Usuario u = gu.find(a);
		System.out.println(u);
		List<Anuncio> lista =ga.getAnuncioPorUsuario(u);
		if(u==null) {
			return lista= new ArrayList<Anuncio>(); 
		}else {
			return lista;
		}	
	}
	
	@Path("/opinar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String opinar(@QueryParam("username")String username,@QueryParam("password")String password,@QueryParam("nombre")String nombre,Opinion o) {
		Usuario logado =gu.getUsuarioLogin(username, password);
		Usuario criticado = gu.find(nombre);
		String mensaje ="";
		if(logado ==null || criticado==null ) {
			mensaje ="ERROR";
		}else {
			o.setCritico(logado);
			o.setCriticado(criticado);
			go.persist(o);
			mensaje ="OK";
		}
		return mensaje;
	}
	
	@Path("/opiniones")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Opinion> getOpinion(@QueryParam("nombreCriticado")String username){
		return go.getOpinionUsuario(username);
	}
	
	@Path("/perfilusuario/{idUsername}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuarioPorUsername(@PathParam("idUsername")String idUsername) {
		Usuario u=gu.find(idUsername);
		return u;
	}
	
	@Path("/solicitarAnuncio/{idAnuncio}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String resModificarEstadoAnuncio(@PathParam("idAnuncio")int id,Anuncio a) {
		String mensaje="";
		//System.out.println(a.getDetallesoferta()+" " + a.getFuncionlaboral());
		Anuncio a2= ga.getAnuncioPorId(id);
		a2.setEstado(a.getEstado());
		if(ga.modificarAnuncio(a2)) {
			mensaje="OK";
			return mensaje;
		}else {
			mensaje="ERROR";
			return mensaje;
		}
	}
	
	@Path("/eliminarAnuncio/{ideliminar}")
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	public String eliminarAnuncio(@PathParam("ideliminar") int idAnuncio) {
		Anuncio anuncionAEliminar = ga.getAnuncioPorId(idAnuncio);
		String mensaje =" ";
		if(ga.remove(anuncionAEliminar)) {
			mensaje ="OK";
			return mensaje;
		}else {
			mensaje="ERROR";
			return mensaje;
		}
		
	}
	
}
