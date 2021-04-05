package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objetos.Adopcion;

public class AdopcionDao {

	public static Connection conexion;
	
	static public ArrayList<Adopcion> mostrarAdopciones(){
		ArrayList<Adopcion> aAdopciones = new ArrayList<Adopcion>();
		try{
			Statement st= conexion.createStatement();
			ResultSet rs=st.executeQuery("Select * from Adopciones");
			while(rs.next()){
				Adopcion adopc= new Adopcion (rs.getInt("CLAVE_ADOPCION"),
											  rs.getDate("FECHA"),
											  rs.getInt("CLAVE_ANIMAL"),
											  rs.getInt("CLAVE_ADOPTANTE"));
				aAdopciones.add(adopc);
				
			}return aAdopciones;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}	
}
