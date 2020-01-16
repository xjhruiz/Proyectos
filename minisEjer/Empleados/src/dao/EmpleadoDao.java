package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import objetos.Departamento;
import objetos.Empleado;
import utilidades.Utilidades;
/**
 * Clase para la gestion de la tabla DEPART
 * @author Jhonatan
 * @see objetos.Departamento
 *
 */
public class EmpleadoDao {
	
	public static Connection conexion;
	/**
	 * Método para consultar todos los departamentos de la base de datos
	 * 
	 * @return ArrayList <Departamento>
	 */
	
	static public ArrayList<Empleado> consultarEmpleados(){
		ArrayList<Empleado> aEmpleados = new ArrayList<Empleado>();
		try{
			Statement st=conexion.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM emple");
			while(rs.next()){
				Empleado em= new Empleado(
						rs.getInt("EMP_NO"),
						rs.getString("APELLIDO"),
						rs.getString("OFICIO"),
						rs.getInt("DIR"),
						rs.getTimestamp("fecha_alt"),
						rs.getInt("SALARIO"),
						rs.getInt("COMISION"));
				aEmpleados.add(em);
			}
			return aEmpleados;	
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	static public int insertarEmpleado(Empleado emple){
		try{
			PreparedStatement stmt =conexion.prepareStatement("insert into emple (emp_no , apellido, oficio" + ", dir, fecha_alt, salario, comision)" + "values (?,?,?,?,?,?,?)");
			stmt.setInt(1, emple.getNumero());
			stmt.setString(2, emple.getNombre());
			stmt.setString(3,emple.getOficio());
			stmt.setInt(4, emple.getDireccion());
			//pasar fecha formato dato a formato java :
			//parsearfechasql de la clase utilidades
			stmt.setTimestamp(5, Utilidades.parsearFechaSQL(emple.getFechaAlta()));
			stmt.setInt(6, emple.getSalario());
			stmt.setInt(7, emple.getComision());
			
			return stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
			
		}
	}
	
	static public int eliminarEmpleado(int id){
		try{
			PreparedStatement stmt=conexion.prepareStatement("Delete from emple where dnombre=?");
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	public static int alterarEmpleado(Empleado emple, int no){
		try{
			PreparedStatement stmt=conexion.prepareStatement("Update emple set  apellido=?, oficio=?, dir=?, fecha_alt=?, salario=?, comision=? where emp_no=?");
			stmt.setString(1, emple.getNombre());
			stmt.setString(2, emple.getOficio());
			stmt.setInt(3, emple.getDireccion());
			stmt.setTimestamp(4, Utilidades.parsearFechaSQL(emple.getFechaAlta()));
			stmt.setInt(5, emple.getSalario());
			stmt.setInt(6, emple.getComision());
			stmt.setInt(7, no);
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	// para modificar los datos de una tabla update depart (tabla) set loc = (?) 'Sevilla' where dept_no=(?) '10';
	
	public static Empleado consultaEmpleadoPorNumero (int numero){
		try{
			PreparedStatement stmt=conexion.prepareStatement
					("Select * from emple natural join depart where emp_no=?");
			stmt.setInt(1, numero);
			
			ResultSet rs=stmt.executeQuery();
			Empleado em=null;
			while(rs.next()){
				
				int dept_no =rs.getInt("dept_no");
				String dnombre=rs.getString("dnombre");
				String loc=rs.getString("loc");
				Departamento dep= new Departamento (dept_no,dnombre,loc);
				em= new Empleado(
						rs.getInt("EMP_NO"),
						rs.getString("APELLIDO"),
						rs.getString("OFICIO"),
						rs.getInt("DIR"),
						rs.getTimestamp("fecha_alt"),
						rs.getInt("SALARIO"),
						rs.getInt("COMISION"));
				em.setDepartamento(dep);
			}
			return em;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
