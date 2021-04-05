package negocio;

import beans.Cuenta;
import dao.CuentaDao;

public class GestionCuenta {

	CuentaDao gestionCuenta;
	
	public GestionCuenta() {
		
		gestionCuenta = new CuentaDao();
	}
	
	public boolean crearCuenta(Cuenta cu) {
		return gestionCuenta.crearCuenta(cu);
	}

	public boolean ingresarEnCuenta(String iban, double cantidad) {
		return gestionCuenta.ingresarEnCuenta(iban, cantidad);
	}

	public boolean transferir(String iban, String iban1, double cantidad) {
		return gestionCuenta.transferir(iban, iban1, cantidad);
	}

	
}
