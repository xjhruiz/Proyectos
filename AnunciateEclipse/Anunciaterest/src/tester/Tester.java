package tester;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dao.AnuncioDao;
import entities.Anuncio;
import entities.Opinion;
import entities.Usuario;
import negocio.GestionAnuncio;
import negocio.GestionOpinion;
import negocio.GestionUsuario;

public class Tester {

	public static void main(String[] args) {
		
		
		/*Usuario u = new Usuario();
		u.setUserName("pedro1");
		u.setPassword("root");
		u.setNombreApellidos("Pepe Gomez");
		u.setTelefono("+35677677677");
		u.setCiudad("Madrid");
		if(gu.registroUsuario(u)) {
			System.out.println("Correctamente");
		}else {
			System.out.println("error");
		}
		/*if(gu.getUsuarioLogin("Juan", "root") != null) {
			System.out.println("Existe");
			System.out.println(u.getUserName());
			System.out.println(u.getNombreApellidos());
		}else {
			System.out.println("No existe");
		}*/
		/*Usuario uuser = new Usuario();
		uuser= gu.find("pedro1");
		System.out.println(uuser.getTelefono());
		/*GestionAnuncio ga = new GestionAnuncio();
		Anuncio a = new Anuncio();
		a.setAutor(u);
		a.setFechaAnuncio(LocalDateTime.now());
		a.setDireccion("IndraHijaputa");
		a.setDetallesoferta("Lamierdadelcentro");
		a.setCiudad("Madrid");
		if(ga.persist(a)) {
			System.out.println("Correcto");
		}else {
			System.out.println("error");
		}
		
		/*List<Anuncio> anuncios =ga.getAnuncios();
		
		for(Anuncio anun : anuncios) {
			System.out.println(anun.getDireccion()+ " " +anun.getDetallesoferta());
		}*/
		/*GestionUsuario gu = new GestionUsuario();
		GestionOpinion go = new GestionOpinion();
		
		Usuario u = new Usuario();
		u.setUserName("pedrito122");
		u.setPassword("root");
		u.setNombreApellidos("Pepe Gomez");
		u.setTelefono("+35677677677");
		u.setEmail("pedrito@hotmail.com");
		u.setCiudad("Madrid");
		if(gu.registroUsuario(u)) {
			System.out.println("Correctamente");
		}else {
			System.out.println("error");
		}
		
		Opinion o = new Opinion();
		o.setPuntuacion(4);
		o.setMensaje("Me ha hecho un excelente trabajo");
		Usuario logado = new Usuario();
		logado = gu.getUsuarioLogin("pedrito122","root");
		o.setCritico(logado);
		Usuario  criticado = new Usuario();
		criticado =gu.find("pedro1");
		o.setCriticado(criticado);
		if(go.persist(o)){
			System.out.println("Correctamente");
		}else {
			System.out.println("error");
		}*/
		/*GestionAnuncio ga = new GestionAnuncio();
		ga.modificarEstadoAnuncio(24);*/
		GestionOpinion go = new GestionOpinion();
		List<Opinion> opiniones = go.getOpinionUsuario("pedrito122");
		for(Opinion o : opiniones) {
			System.out.println(o.getMensaje()+" "+o.getPuntuacion());
		}
		
		GestionAnuncio ga = new GestionAnuncio();
		/*Anuncio a =ga.getAnuncioPorId(30);
		a.setPago("PAGO 10 EUROS LA HORA");
		if(ga.modificarAnuncio(a)) {
			System.out.println("Modificado");
		}else{
			System.out.println("Error");
		}
		*/
		Anuncio a1 = ga.getAnuncioPorId(40);
		if(ga.remove(a1)) {
			System.out.println("Eliminado");
		}else
			System.out.println("Error al aliminar");
		
	}

}
