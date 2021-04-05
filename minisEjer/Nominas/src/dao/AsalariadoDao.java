package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objetos.Asalariado;
import objetos.Empresa;

public class AsalariadoDao {
	
	public static Connection conexion;
	
	static public ArrayList <Asalariado> consultarAsalariado(){
		ArrayList<Asalariado> aAsalariado=new ArrayList<Asalariado>();
		try{
			Statement st=conexion.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM ASALARIADO");
			
			while(rs.next()){
				Asalariado d=new Asalariado( rs.getString("NOMBRE"),
						                     rs.getString("APELLIDO"),
						                     rs.getInt("DNI"));
				aAsalariado.add(d);
			}
			return aAsalariado;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static int eliminarAsalariado(int id){
		try{
			PreparedStatement stmt=conexion.prepareStatement("Delete from Asalariado where dni=?");
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}

	public static int alterarAsalariado(Asalariado asal, int no){
		try{
			PreparedStatement stmt=conexion.prepareStatement("Update Asalariado set nombre=?, Apellido=?, dni=? where dni=?");
			stmt.setString(1,asal.getNombre());
            stmt.setString(2, asal.getApellido());		
            stmt.setInt(3, asal.getDni());
            
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	public static int insertarAsalariado(Asalariado asal){
		try{
			PreparedStatement stmt = conexion.prepareStatement
					("insert into Asalariado ( nombre, apellido, dni)" + "values(?,?,?)");
			stmt.setString(1,asal.getNombre());
            stmt.setString(2, asal.getApellido());		
            stmt.setInt(3, asal.getDni());
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
}
