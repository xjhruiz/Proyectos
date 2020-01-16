package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Anuncio;
import entities.Usuario;

public class AnuncioDao extends ConexionDao {
	
	

	public void persist(Anuncio anuncio) {
		em.persist(anuncio);
	}

	public List<Anuncio> getAnuncios() {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		// String jpql= "Select a from Anuncio a ";
		String jpql = "Select a from Anuncio a order by a.fechaAnuncio desc";
		Query query = em.createQuery(jpql);

		return anuncios = query.getResultList();

	}

	/*
	 * ver anuncios por etiqueta borrar anuncio
	 */
	public void remove(Anuncio a) {
		em.remove(a);
	}
	
	public Anuncio getAnuncioPorId(int id) {
		return em.find(Anuncio.class, id);

	}
	/*
	 * public void modificarEstadoAnuncio(int id) {
	 * 
	 * //String jpql ="Update Anuncio a SET a.estado= 'solicitado' "+" Where a.id = :id"; Query
	 * query = em.createQuery(jpql); query.setParameter("id", id);
	 * query.executeUpdate(); }
	 */

	public void modificarAnuncio(Anuncio a) {
		em.merge(a);
	}
	
	public List<Anuncio> getAnuncioPorUsuario(Usuario u ){
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		String  jpql= "Select a from Anuncio a where a.autor = :u  order by a.fechaAnuncio desc";
		Query query = em.createQuery(jpql);
		query.setParameter("u", u);
		anuncios=query.getResultList();
		return anuncios;
	}
}
