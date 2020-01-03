package negocio;

import java.util.List;

import dao.AnuncioDao;
import entities.Anuncio;

public class GestionAnuncio {

	AnuncioDao anuncioDao;
	
	public GestionAnuncio() {
		// TODO Auto-generated constructor stub
		anuncioDao = new AnuncioDao();
	}
	public boolean persist(Anuncio anuncio) {
		try {
			anuncioDao.iniciarTransaccion();
			anuncioDao.persist(anuncio);
			anuncioDao.cerrarTransaccion();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			anuncioDao.roolback();
			System.out.println("No se ha podido crear el anuncio");
			return false;
		}
	}
	public List<Anuncio> getAnuncios() {
		return anuncioDao.getAnuncios();
	}
	
}
