package negocio;

import java.util.List;

import dao.AnuncioDao;
import entities.Anuncio;
import entities.Usuario;

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
	
	public Anuncio getAnuncioPorId(int id) {
		return anuncioDao.getAnuncioPorId(id);
	}
	public boolean modificarAnuncio (Anuncio a) {
		try {
			anuncioDao.iniciarTransaccion();
			anuncioDao.modificarAnuncio(a);
			anuncioDao.cerrarTransaccion();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			anuncioDao.roolback();
			System.out.println("No se ha podido modificar el anuncio");
			return false;
		}
		
	}
	public List<Anuncio> getAnuncioPorUsuario(Usuario u) {
		return anuncioDao.getAnuncioPorUsuario(u);
	}
	public boolean remove(Anuncio a) {
		try {
			anuncioDao.iniciarTransaccion();
			anuncioDao.remove(a);
			anuncioDao.cerrarTransaccion();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			anuncioDao.roolback();
			return false;
		}
	}
	
	
}
