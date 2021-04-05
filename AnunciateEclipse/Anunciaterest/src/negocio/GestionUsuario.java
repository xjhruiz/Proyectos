package negocio;


import dao.UsuarioDao;
import entities.Usuario;

public class GestionUsuario {

	UsuarioDao usuarioDao;
	
	public GestionUsuario() {
		// TODO Auto-generated constructor stub
		usuarioDao = new UsuarioDao();
	}

	public boolean registroUsuario(Usuario usuario) {
		try {
			usuarioDao.iniciarTransaccion();
			Usuario existente = usuarioDao.find(usuario.getUserName());
			if(usuario!=existente) {
				usuarioDao.registroUsuario(usuario);
				usuarioDao.cerrarTransaccion();
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			usuarioDao.roolback();
			System.out.println("No se ha podido crear el usuario");
			return false;
		}
		
	}

	public Usuario getUsuarioLogin(String username, String password) {
		try {
			return usuarioDao.getUsuarioLogin(username, password);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("no existe ese usuario");
			return null;
		}
		
	}

	public Usuario find(String username) {
		try {
			return usuarioDao.find(username);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se ha podido encontrar ese usuario");
			return null;
		}
		
	}

	public void modificarUsuario(Usuario entity) {
		usuarioDao.modificarUsuario(entity);
	}
	
	
}
