package negocio;

import java.util.List;

import dao.PersonaDao;
import entities.Persona;

public class GestionPersona {

	PersonaDao personaDao;
	
	public GestionPersona() {
		// TODO Auto-generated constructor stub
		personaDao = new PersonaDao();
	}

	public  boolean crearPersona(Persona p) {
		try {
			personaDao.iniciarTransaccion();
			personaDao.crearPersona(p);
			personaDao.cerrarTransaccion();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		personaDao.roolback();
			return false;
		}
	}

	public List<Persona> getPersonas() {
		return personaDao.getPersonas();
	}

	public boolean modificarPersona(Persona p) {
		try {
		personaDao.iniciarTransaccion();
		personaDao.modificarPersona(p);
		personaDao.cerrarTransaccion();
		return true;
		} catch (Exception e) {
			// TODO: handle exception
			personaDao.roolback();
			return false;
		}
	}

	public boolean eliminarPersona(int id) {
		try {
			personaDao.iniciarTransaccion();
			personaDao.eliminarPersona(id);
			personaDao.cerrarTransaccion();
			return true;
			} catch (Exception e) {
				// TODO: handle exception
				personaDao.roolback();
				return false;
			}
		
	}
	public Persona buscarPersona(Integer id) {
		return personaDao.buscarPersona( id);
	}
	
}
