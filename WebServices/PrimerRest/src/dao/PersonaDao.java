package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apirest.HolaJSON;
import entities.Persona;

public class PersonaDao {
		
	EntityManager em;
	EntityTransaction et;
	EntityManagerFactory emt;
	
	public PersonaDao() {
		// TODO Auto-generated constructor stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PrimerRest");
		em=emf.createEntityManager();
	}
	
	public void iniciarTransaccion(){
		et=em.getTransaction();
		et.begin();
		
	}
	public void roolback(){
		et.rollback();
	}
	public void cerrarTransaccion(){
		et.commit();
	}
	
	public void cerrarConexion() {
		em.close();
		emt.close();
	}
	
	public void crearPersona(Persona p) {
		
		em.persist(p);
	}
	public List<Persona> getPersonas(){
		String jpql="Select p from Persona p";
		Query query = em.createQuery(jpql);
		return (List<Persona>) query.getResultList();
		
	}
	public void modificarPersona(Persona p) {
		em.merge(p);
	}
	public void eliminarPersona(int id) {
		
		String jqpl ="Delete p from Persona p Where p.id =:id";
		Query query =em.createQuery(jqpl);
		query.setParameter(" id " , id);
		query.executeUpdate();
		
	}

	public Persona buscarPersona(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Persona.class, id);
	}
}
