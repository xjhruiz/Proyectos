package dao;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Cuenta;

public class CuentaDao {

	Connection con;
	
	
	public CuentaDao() {
		con=AgenteConexion.getConexion();
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/cuentabancaria","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public boolean crearCuenta(Cuenta cu) {
		try {
			PreparedStatement pstmt = con.prepareStatement("Insert into Cuentas (iban,nombre,apellidos,saldo)" + "values (?,?,?,?)");
			pstmt.setString(1,cu.getIban());
			pstmt.setString(2, cu.getNombre());
			pstmt.setString(3, cu.getApellidos());
			pstmt.setDouble(4, cu.getSaldo());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	public boolean ingresarEnCuenta(String iban , double cantidad) {
		try {
				
				PreparedStatement pstmts=con.prepareStatement(" update cuentas set  saldo = saldo+'"+cantidad+"'where iban='"+iban+"'");
				ResultSet rt =pstmts.executeQuery();
				rt.next();
				rt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
		
	}
	public boolean transferir(String iban, String iban1 , double cantidad) {
		
		try {
			PreparedStatement pstmt=con.prepareStatement(" update cuentas set  saldo = saldo-'"+cantidad+"'where iban='"+iban+"'and saldo>="+cantidad);
			ResultSet rt =pstmt.executeQuery();
			rt.next();
			
			PreparedStatement pstmt2=con.prepareStatement(" update cuentas set saldo= saldo+'"+cantidad+"' where iban= '"+iban1+"'");
			ResultSet rt1=pstmt2.executeQuery();
			rt1.next();
			rt1.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
}