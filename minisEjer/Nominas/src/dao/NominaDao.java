package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objetos.Asalariado;
import objetos.Empresa;
import objetos.Nomina;

public class NominaDao {
	
	public static Connection conexion;
	
	static public ArrayList <Nomina> consultarNomina(){
		ArrayList<Nomina> aNomina=new ArrayList<Nomina>();
		try{
			Statement st=conexion.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM NOMINA");
			
			while(rs.next()){
				Nomina d=new Nomina( 
						rs.getInt("MES"),
						rs.getInt("ANIO"),
						rs.getInt("DNI"),
						rs.getInt("CIF"),
						rs.getInt("SALARIOBASE"),
						rs.getInt("COMPLSALARIO"),
						rs.getInt("HORASEXT"),
						rs.getInt("SALARIO_BRUTO"),
						rs.getInt("IMPUESTO"));
				aNomina.add(d);
			}
			return aNomina;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		
	}
	}
	
	public static int eliminarNomina(int id){
		try{
			PreparedStatement stmt=conexion.prepareStatement("Delete from Nomina where dni=?");
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}

	public static int alterarNomina(Nomina nomi, int no){
		try{
			PreparedStatement stmt=conexion.prepareStatement("Update Nomina set mes=?, anio=?, dni=?"
					+ "                                                          cif=?, salarioBase=?, complsalario=?"
					+ "                                                          horasext=?, salariobruto=?, impuestos=?  where dni =?");
            stmt.setInt(1, nomi.getMes());
            stmt.setInt(2, nomi.getAnio());
            stmt.setInt(3, nomi.getDni());
            stmt.setInt(4, nomi.getCif());
            stmt.setInt(5, nomi.getSalariobase());
            stmt.setInt(6, nomi.getComplsalario());
            stmt.setInt(7, nomi.getHorasext());
            stmt.setInt(8, nomi.getSalariobase());
            stmt.setInt(9, nomi.getImpuestos());
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int insertarNomina(Nomina nomi){
		try{
			PreparedStatement stmt = conexion.prepareStatement
					("insert into Nomina (mes, anio, dni, cif, salarioBase, complsalario, horasext, salario_bruto, impuestos) "+ "values(?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, nomi.getMes());
            stmt.setInt(2, nomi.getAnio());
            stmt.setInt(3, nomi.getDni());
            stmt.setInt(4, nomi.getCif());
            stmt.setInt(5, nomi.getSalariobase());
            stmt.setInt(6, nomi.getComplsalario());
            stmt.setInt(7, nomi.getHorasext());
            stmt.setInt(8, nomi.getSalariobase());
            stmt.setInt(9, nomi.getImpuestos());
			return stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
}
