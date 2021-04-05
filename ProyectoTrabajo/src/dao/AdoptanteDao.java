package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objetos.Adoptante;

public class AdoptanteDao {
	
public static Connection conexion;

static public ArrayList<Adoptante> mostrarAdoptantes(){
	ArrayList<Adoptante> aAdoptantes = new ArrayList<Adoptante>();
	try{
		Statement st=conexion.createStatement();
		ResultSet rs=st.executeQuery("Select * from Adoptantes");
		while(rs.next()){
			Adoptante adopt= new Adoptante( rs.getInt("CLAVE_ADOPTANTE"),
											rs.getString("NOMBRE"),
											rs.getString("APELLIDO"),
											rs.getInt("TELEFONO"),
											rs.getInt("CLAVE_ANIMAL"));
			aAdoptantes.add(adopt);
		}
		return aAdoptantes;
	}catch(SQLException e){
		e.printStackTrace();
		return null;
		}
	}
}
