package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objetos.Empresa;
import utilidades.Utilidades;

public class EmpresaDao {

	public static Connection conexion;

	static public ArrayList <Empresa> consultarEmpresa(){
		ArrayList<Empresa> aEmpresa=new ArrayList<Empresa>();
		try{
			Statement st=conexion.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM empresa");
			
			while(rs.next()){
				Empresa d=new Empresa(rs.getInt("CIF"), rs.getString("NOMBRE"));
				aEmpresa.add(d);
			}
			return aEmpresa;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static int eliminarEmpresa(int id){
		try{
			PreparedStatement stmt=conexion.prepareStatement("Delete from empresa where cif=?");
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}

	public static int alterarEmpresa(Empresa empre, int no){
		try{
			PreparedStatement stmt=conexion.prepareStatement("Update empresa set nombre=?, cif=? where cif=?");
            stmt.setInt(1, empre.getCif());
            stmt.setString(2, empre.getNombre());
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	public static int insertarEmpresa(Empresa empre){
		try{
			PreparedStatement stmt = conexion.prepareStatement
					("insert into empresa (cif, nombre)" + "values(?,?)");
            stmt.setInt(1, empre.getCif());
            stmt.setString(2, empre.getNombre());
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
}

