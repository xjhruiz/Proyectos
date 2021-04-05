package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Pelicula;
import entities.PeliculaEclipse;



public class PeliculaDaoAndroid {

	EntityManager em;
	EntityTransaction et;
	EntityManagerFactory emt;
	
	public PeliculaDaoAndroid() {
		// TODO Auto-generated constructor stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CineRest");
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
	
	public void crearPelicula(Pelicula p) {
		
		em.persist(p);
	}
	public List<Pelicula> getPelicula(){
		String jpql="Select p from Pelicula p";
		Query query = em.createQuery(jpql);
		return (List<Pelicula>) query.getResultList();
		
	}
	public void modificarPelicula(Pelicula p) {
		em.merge(p);
	}
	public void eliminarPelicula(int id) {
		
		String jqpl ="Delete p from Pelicula p Where p.id =:id";
		Query query =em.createQuery(jqpl);
		query.setParameter(" id " , id);
		query.executeUpdate();
	}
	public Pelicula buscarPelicula(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Pelicula.class, id);
	}

}
