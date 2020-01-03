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
			usuarioDao.registroUsuario(usuario);
			usuarioDao.cerrarTransaccion();
			return true;
			
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
	
}
