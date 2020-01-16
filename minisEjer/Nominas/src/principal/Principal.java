package principal;

import java.util.ArrayList;

import dao.AsalariadoDao;
import dao.ConexionDao;
import dao.EmpresaDao;
import dao.NominaDao;
import objetos.Asalariado;
import objetos.Empresa;
import objetos.Nomina;

public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConexionDao conexion= new ConexionDao();
		
		EmpresaDao empDao= new EmpresaDao();
		empDao.conexion=conexion.getConexion();
		
		ArrayList<Empresa> aEmpresas=empDao.consultarEmpresa();
	
		for(Empresa d: aEmpresas){
			System.out.println(d);
		}		
		
		AsalariadoDao asaDao= new AsalariadoDao();
		asaDao.conexion=conexion.getConexion();
		
		ArrayList<Asalariado> aAsalariados=asaDao.consultarAsalariado();
	
		for(Asalariado d: aAsalariados){
			System.out.println(d);
		}		
		
		
		NominaDao nomDao= new NominaDao();
		nomDao.conexion=conexion.getConexion();
		
		ArrayList<Nomina> aNominas=nomDao.consultarNomina();
	
		for(Nomina d: aNominas){
			System.out.println(d);
		}		
		
	}
}
