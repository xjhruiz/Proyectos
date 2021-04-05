package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Opinion;
import entities.Usuario;

public class OpinionDao extends ConexionDao{

	
	public void persist(Opinion o) {
		em.persist(o);
	}
	
	public List<Opinion> getOpinionUsuario(String criticado){
		List<Opinion> opiniones = new ArrayList<Opinion>();
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usercriticado =usuarioDao.find(criticado);
		String jpql ="Select o from Opinion o where o.criticado =:criticado";
		Query query =em.createQuery(jpql);
		query.setParameter("criticado", usercriticado);
		opiniones=query.getResultList();
		return opiniones;
		
	}
	
	
}
