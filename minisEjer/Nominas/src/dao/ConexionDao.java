package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	public static Connection conexion(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=
						DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:", "usuario2","password2");
			System.out.println("Conexion con base de datos realizada.");
			return con;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
