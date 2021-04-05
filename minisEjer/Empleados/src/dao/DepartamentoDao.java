package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objetos.Departamento;

public class DepartamentoDao {
	
	public static Connection conexion;
	
	
	static public ArrayList<Departamento> consultaDepartamentos(){
		ArrayList<Departamento> aDepartamentos = new ArrayList<Departamento>();
		try{
			//hoja en blanco 
			Statement st=conexion.createStatement();
			//tabla de la hoja "array que no se accede de la pos 0,1,2... si no de los nombres de las columnas"
			ResultSet rs=st.executeQuery("SELECT * FROM depart");
			while(rs.next()){
				Departamento d= new Departamento(rs.getInt("DEPT_NO"),
												rs.getString("DNOMBRE"),
												rs.getString("LOC"));
				//lista agregada en el array
				aDepartamentos.add(d);
			}
			return aDepartamentos;	
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	//documentación
	/**
	 * 
	 * Método para insertar un registro en la table departamento
	 * @param depart
	 * @return <ul>
	 *           <li> -1 : fallo al insertar la linea </li>
	 *           <li>  0 : no ha insertado nada </li>
	 *           <li>  1 : ha insertado un registro</li>
	 */
	static public int insertarDepartamento(Departamento depart){
		try{
			//hoja en blanco preparada para insertar mas cosas                  "tantas interrogaciones como datos metas"
			PreparedStatement stmt =conexion.prepareStatement("insert into depart (dept_no, dnombre, loc)" + "values (?,?,?)");
			//primera interrogacion primer dato...
			stmt.setInt(1, depart.getNumero());
			stmt.setString(2, depart.getNombre());
			stmt.setString(3, depart.getLocalizacion());
			return stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
			
		}
	}
	//documentación
	/**
	 * Método para modificar un registro de la table depart
	 * @param depart
	 * @param no
	 * @return <ul>
	 *           <li> -1 : fallo al insertar la linea </li>
	 *           <li>  0 : no ha insertado nada </li>
	 *           <li>  1 : ha insertado un registro</li>
	 *         <ul>
	 */
	static public int eliminarDepartamento(int id){
		try{
			//datos que el usuario da
			PreparedStatement stmt=conexion.prepareStatement("Delete from depart where dept_no=?");
			stmt.setInt(1, id);
			return stmt.executeUpdate(); 
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	//documentación
	/**
	 * 
	 * @param depart
	 * @return <ul>
	 *           <li> -1 : fallo al insertar la linea </li>
	 *           <li>  0 : no ha insertado nada </li>
	 *           <li>  1 : ha insertado un registro</li>
	 *         <ul>
	 */
	static public int modificarDepartamento(Departamento depart){
		try{
			PreparedStatement stmt=conexion.prepareStatement("update depart set dnombre=? ,loc=? where dept_no=?");
			stmt.setString(1, depart.getNombre());
			stmt.setString(2, depart.getLocalizacion());
			stmt.setInt(3, depart.getNumero());
        return stmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	
	}

