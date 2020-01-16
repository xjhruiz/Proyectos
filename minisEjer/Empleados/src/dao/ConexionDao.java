package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDao {
	
	public static Connection conexion;
	
	public ConexionDao(){
		//this.conexion=conexion();
	}
	
	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		ConexionDao.conexion = conexion;
	}

	// codigo para conectarse a la base de datos
	public static Connection conexion(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con  = 
	        		DriverManager.getConnection
	        		("jdbc:oracle:thin:@localhost:1521:","usuario2","password");
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
