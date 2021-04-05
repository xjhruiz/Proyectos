package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConexionDao {

	EntityManager em;
	EntityTransaction et;
	
	public ConexionDao(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Anunciate");
		em= emf.createEntityManager();
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
	
}
