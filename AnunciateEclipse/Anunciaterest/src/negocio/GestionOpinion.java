package negocio;

import java.util.List;

import dao.OpinionDao;
import entities.Opinion;
import entities.Usuario;

public class GestionOpinion {

	OpinionDao opinionDao;
	
	public GestionOpinion() {
		opinionDao = new OpinionDao();
	}

	public boolean persist(Opinion o) {
		try {
			opinionDao.iniciarTransaccion();
			opinionDao.persist(o);
			opinionDao.cerrarTransaccion();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			opinionDao.roolback();
			return false;
		}
		
	}

	public List<Opinion> getOpinionUsuario(String u) {
		return opinionDao.getOpinionUsuario(u);
	}
	
	
	
}
