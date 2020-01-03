package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Anuncio;

public class AnuncioDao extends ConexionDao{

	public void persist(Anuncio anuncio) {
		em.persist(anuncio);
	}
	public List<Anuncio> getAnuncios(){
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		String  jpql= "Select a from Anuncio a ";
		//String  jpql="Select a from anuncio a order by a.fechaAnuncio desc";
		Query query = em.createQuery(jpql);
		
		return anuncios=query.getResultList();
		
	}
	/* ver anuncios por etiqueta
	 * borrar anuncio 
	 */
}
