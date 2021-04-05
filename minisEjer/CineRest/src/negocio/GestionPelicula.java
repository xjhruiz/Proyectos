package negocio;

import java.util.List;

import dao.PeliculaDao;
import entities.PeliculaEclipse;

public class GestionPelicula {

	PeliculaDao peliculaDao;
	public GestionPelicula() {
		// TODO Auto-generated constructor stub
		 peliculaDao = new PeliculaDao();
	}

	public boolean crearPelicula(PeliculaEclipse p) {
		try{
			peliculaDao.iniciarTransaccion();
			peliculaDao.crearPelicula(p);
			peliculaDao.cerrarTransaccion();
			return true;
		}catch (Exception e) {
			peliculaDao.roolback();
			return false;
		}
		
		
	}

	public List<PeliculaEclipse> getPelicula() {
		return peliculaDao.getPelicula();
	}

	public boolean modificarPelicula(PeliculaEclipse p) {
		try{
		peliculaDao.iniciarTransaccion();
		peliculaDao.modificarPelicula(p);
		peliculaDao.cerrarTransaccion();
		return true;
	}catch (Exception e) {
		peliculaDao.roolback();
		return false;
	}
	}

	public boolean eliminarPelicula(int id) {
		try{
		peliculaDao.iniciarTransaccion();
		peliculaDao.eliminarPelicula(id);
		peliculaDao.cerrarTransaccion();
		return true;
	}catch(Exception e){
		peliculaDao.roolback();
		return false;
	}
	}

	public PeliculaEclipse buscarPelicula(Integer id) {
		return peliculaDao.buscarPelicula(id);
	}
}
