package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objetos.Animal;;

/**
 * Clase para la gestion de la tabla Animales
 * @author Jhonatan
 * @see objetos.Animal
 *
 */
public class AnimalDao {
	
	public static Connection conexion;
	
	
	static public ArrayList<Animal> mostrarAnimales(){
		ArrayList<Animal> aAnimales = new ArrayList<Animal>();
		try{
			Statement st=conexion.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM ANIMALES = ?");
		while(rs.next()){
			Animal ani= new Animal(
					rs.getInt("CLAVE_ANIMAL"),
					rs.getString("TIPO"),
					rs.getString("EDAD"),
					rs.getString("NOMBRE"));
			aAnimales.add(ani);
		}
		return aAnimales;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Método para consultar los animales por id de la base de datos
	 * 
	 * @return Animal ani
	 */
	public static Animal consultaAnimalxid(int numero){
		Animal ani= new Animal();
		try{
			PreparedStatement stmt=conexion.prepareStatement
					("Select * from Animales where CLAVE_ANIMAL=?" );
			stmt.setInt(1, numero);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				ani= new Animal(rs.getInt("CLAVE_ANIMAL"),
								rs.getString("TIPO"),
								rs.getString("EDAD"),
								rs.getString("NOMBRE"));
			}
		}catch (SQLException e){
			System.out.println("No existe el animal con codigo " + numero);
			return null;
		}
		return ani;
		
	}
	
}
