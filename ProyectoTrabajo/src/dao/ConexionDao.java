package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase para la gestion de la cenexion con la base de datos
 * @author Jhonatan
 * @see objetos.AnimalDao
 *
 */
public class ConexionDao {
public static Connection conexion;
	
	public ConexionDao(){
		this.conexion=conexion();
	}
	
	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		ConexionDao.conexion = conexion;
	}
	/**
	 * metodo para conectarme con la base de datos sql
	 *
	 */
	public static Connection conexion(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con  = 
	        		DriverManager.getConnection
	        		("jdbc:oracle:thin:@localhost:1521:","usuario2","password2");
	        System.out.println("Conexion con base de datos realizada.");
			return con;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
