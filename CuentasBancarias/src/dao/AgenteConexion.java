package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AgenteConexion {

	private Connection con;
	private static AgenteConexion agente;
	
	private AgenteConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/cuentabancaria","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static Connection getConexion() {
		if(agente!=null)
			return agente.con;
		else
			agente = new AgenteConexion();
		return agente.con;
		
	}
}
