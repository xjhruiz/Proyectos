package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Usuario;

public class UsuarioDao extends ConexionDao {
	
	//Registro Usuario
	public void registroUsuario(Usuario usuario) {
		em.persist(usuario);
	}
	
	//Login Usuario
	public Usuario getUsuarioLogin(String username ,String password) {
		String jqpl="Select u from Usuario u where u.userName =:username and u.password=:password";
		Query query = em.createQuery(jqpl);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		return (Usuario) query.getSingleResult();
	}
	/* ampliar ver perfil del usuario mediante un click
	public Usuario find(String nombre) {
		return em.find(Usuario.class, nombre);
	}*/
	
	/*//Modificar perfil Usuario (ampliar )
	public void modificarUsuario(Usuario entity) {
		 em.merge(entity);
	}*/
	
}
