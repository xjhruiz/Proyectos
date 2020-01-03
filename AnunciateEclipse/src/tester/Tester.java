package tester;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import entities.Anuncio;
import entities.Usuario;
import negocio.GestionAnuncio;
import negocio.GestionUsuario;

public class Tester {

	public static void main(String[] args) {
		
		GestionUsuario gu = new GestionUsuario();
		Usuario u = new Usuario();
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
		
		GestionAnuncio ga = new GestionAnuncio();
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
		
		List<Anuncio> anuncios =ga.getAnuncios();
		
		for(Anuncio anun : anuncios) {
			System.out.println(anun.getDireccion()+ " " +anun.getDetallesoferta());
		}
		
	}

}
