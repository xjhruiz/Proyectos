package test;

import beans.Cuenta;
import negocio.GestionCuenta;

public class TestCuenta {
	
	public static void main(String[] args) {
		
		GestionCuenta gestion = new GestionCuenta();
		Cuenta cu = new Cuenta();
		cu.setIban("Juanito888");
		cu.setNombre("Juan");
		cu.setApellidos("Perez");
		cu.setSaldo(56000);
		System.out.println("insetado juan");
		gestion.crearCuenta(cu);
		
		cu.setIban("Juanito88");
		gestion.ingresarEnCuenta("Juanito88", 5000);
		
		Cuenta cu1 = new Cuenta();
		cu1.setIban("Perez111");
		cu1.setNombre("Pedro");
		cu1.setApellidos("Jimenez");
		cu1.setSaldo(544444);
		gestion.crearCuenta(cu1);
		
		gestion.transferir("Juanito888", "Perez111", 600);
		
	}

}
