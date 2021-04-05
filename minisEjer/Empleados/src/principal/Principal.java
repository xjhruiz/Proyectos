package principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.ConexionDao;
import dao.DepartamentoDao;
import dao.EmpleadoDao;
import objetos.Departamento;
import objetos.Empleado;
import utilidades.Utilidades;

public class Principal {
	
	static ConexionDao conexion= new ConexionDao();
	static DepartamentoDao deptDao= new DepartamentoDao();
	static EmpleadoDao empleDao = new EmpleadoDao();

	public static void main(String [] args){
		
		ConexionDao conexion = new ConexionDao();
		DepartamentoDao deptDao= new DepartamentoDao();
		deptDao.conexion=conexion.getConexion();
		EmpleadoDao empleDao= new EmpleadoDao();
		empleDao.conexion=conexion.getConexion();
		
		ArrayList<Departamento> aDepartamentos= deptDao.consultaDepartamentos();
		ArrayList<Empleado> aEmpleados = empleDao.consultarEmpleados();
		System.out.println("Bienvenido al gestor de la base de datos");
		boolean correcto=false;
		int opcion;
		boolean salir=false;
		do{
			System.out.println("0-Salir.");
			System.out.println("1-Gestion departmentos.");
			System.out.println("2-Gestion empleados.");
			try{
				System.out.println("Selecciona una opcion:");
				Scanner sc= new Scanner (System.in);
				opcion=sc.nextInt();
				switch(opcion){
					case 0:
						System.out.println("Adios");
						salir=true;
						break;
					case 1:
						menuGestionDepartamento(aEmpleados);
						break;
					case 2:
						menuGestionEmpleados();
						break;
					default: 
						System.out.println("Opcion incorrecta.");	
				}
			}catch(InputMismatchException e){
				System.out.println("Introduzca un numero.");
			}
		}while(!salir);
		
		}
	public static void menuGestionEmpleados(){
		Utilidades.clear();
		boolean atras = false;
		do{
			System.out.println("Bienvenido al gestor de empleados");
			System.out.println("0. Atras");
			System.out.println("1. Introducir empleados ");
			System.out.println("2. Borrar empleados");
			System.out.println("3. Mostrar empleados");
			System.out.println("4. Modificar empleados");
			try{
			Scanner sc = new Scanner(System.in);
			int opcion = sc.nextInt();
			switch(opcion){
			case 0: 
			atras = true;
			break;
			case 1: 
			introducirEmpleados(aEmpleados);
			break;
			case 2:
			borrarEmpleados(aEmpleados);
			break;
			case 3: 
			mostrarEmpleados(aEmpleados);
			break;
			case 4: modificarEmpleados(aEmpleados);
			break;
			default:System.out.println("Opcion incorrecta");
			break;
				}
			}catch(InputMismatchException e){
				System.out.println("Introduzca un numero");
				}
			}	while(!atras);
	}
	private static void introducirEmpleados(ArrayList <Empleado> aEmpleados){
		try{
		int numEmple = 0;
		System.out.println("Cuantos empleados desea introducir? ");
		Scanner sc = new Scanner(System.in);
		numEmple = sc.nextInt();
		for(int i = 0; i < numEmple; i++){
			Empleado e = new Empleado();
			System.out.println("-- Empleado numero " + (i+1) +" --");
			e.peditDatos();
			aEmpleados.add(e);
			EmpleadoDao.insertarEmpleado(e);
			}
		}catch(InputMismatchException e){
			System.out.println("Intoduzca un numero");
			introducirEmpleados(aEmpleados);
		} catch(NullPointerException ex){
			System.out.println("Ha introducido mal la fecha, intentelo de nuevo");
			introducirEmpleados(aEmpleados);
		}
		System.out.println("Fin Introducir Empleados");
	}
	private static void mostrarEmpleados(ArrayList <Empleado> aEmpleados){
		for(int i=0; i<aEmpleados.size();i++){
			System.out.println(aEmpleados.get(i));
		}
		System.out.println(" -- FIN MUESTRA EMPLEADOS --");
	}
	private static void borrarEmpleados(ArrayList <Empleado> aEmpleados){
		System.out.println();
		System.out.println();
		System.out.println("Bienvenido a Borrar Empleado");
		System.out.println("Que empleado desea borrar?");
		boolean correcto = false;
		int number = 0;
		int intro = 0;
		String emple = null;
		do{
			for(int i = 0; i < aEmpleados.size(); i++){
				System.out.println((i+1) +". "+ aEmpleados.get(i).getNombre());
			}
			try{
				Scanner sc = new Scanner(System.in);
				number = sc.nextInt();
				number--;
				correcto = true;
			}
			catch(InputMismatchException e){
				System.out.println("Error 404");
				System.out.println("Introduzca un numero");
				correcto = false;
				}
		}while(!correcto);
		emple = aEmpleados.get(number).getNombre();
		System.out.println("Se borrara " + aEmpleados.get(number).getNombre() + " esta usted seguro?");
		System.out.println("1. Si");
		System.out.println("2. No");
		try{
			Scanner sc = new Scanner(System.in);
			intro = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Error 404");
			System.out.println("Introduzca un numero");
			borrarEmpleados(aEmpleados);
			}
		switch(intro){
		case 1: EmpleadoDao.eliminarEmpleado(aEmpleados.get(number).getNumero()); 
		System.out.println("Se ha borrado " +emple+" de la lista de empleados" );
		break;
		case 2: borrarEmpleados(aEmpleados);
		break;
		default: System.out.println("wrooong input ");borrarEmpleados(aEmpleados);
		break;
		}
		Utilidades.clear();
	}
	public static void modificarEmpleados(ArrayList<Empleado> aEmpleados){
		
		System.out.println();
		System.out.println();
		System.out.println("Bienvenido a modificar Empleado");
		System.out.println("Que empleado desea modificar?");
		boolean correcto = false;
		int number = 0;
		int intro = 0;
		String emple = null;
		do{
			for(int i = 0; i < aEmpleados.size(); i++){
				System.out.println((i+1) +". "+ aEmpleados.get(i).getNombre());
			}
			try{
				Scanner sc = new Scanner(System.in);
				number = sc.nextInt();
				number--;
				correcto = true;
			}
			catch(InputMismatchException e){
				System.out.println("Error 404");
				System.out.println("Introduzca un numero");
				correcto = false;
				}
		}while(!correcto);
		emple = aEmpleados.get(number).getNombre();
		System.out.println("Se modificara " + aEmpleados.get(number).getNombre() + " esta usted seguro?");
		System.out.println("1. Si");
		System.out.println("2. No");
		try{
			Scanner sc = new Scanner(System.in);
			intro = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Error 404");
			System.out.println("Introduzca un numero");
			modificarEmpleados(aEmpleados);
			}
		aEmpleados.get(number).peditDatos();
		switch(intro){
		case 1: EmpleadoDao.alterarEmpleado(aEmpleados.get(number), aEmpleados.get(number).getNumero()); 
		System.out.println("Se ha alterado " +emple+" de la lista de empleados" );
		break;
		case 2: modificarEmpleados(aEmpleados);
		break;
		default: System.out.println("wrooong input ");modificarEmpleados(aEmpleados);
		break;
		}
		Utilidades.clear();
	}
	//Emple section END
	public static void menuGestionDepartamento(ArrayList<Departamento> aDepartamentos){
		
		Utilidades.clear();
		boolean salir=false;
		do{
			Scanner sc= new Scanner(System.in);
			System.out.println("****MENU GESTION DEPARTAMENTOS****");
			System.out.println("*0 - Volver.");
			System.out.println("1 - Nuevo Departamento.");
			System.out.println("2 - Baja Departamento.");
			System.out.println("3 - Listado Departamento.");
			System.out.println("4 - Modifica empleados.");
			System.out.println("5 - Consulta empleados por codigo");
			try{
				int opcion=sc.nextInt();
				switch (opcion){
				case 1:
					insertarDepartamento(); break;
					
				case 2:
					menuBajaDepartameto(); break;
				case 3: 
					consultaDepartamentos(); break;
				case 4:
					modificarEmpleado(); break;
				case 5: consultaEmpleadoPorCodigo(); break;
				case 0: salir= true; break;
				default:
				System.out.println("Opcion incorrecta");
				}
			}catch(InputMismatchException e){
				System.out.println("Ha introducido un valor incorrecto. ");
			}
		}while(!salir);
	}
	
	private static void consultaEmpleadoPorCodigo(){
		boolean correcto=false;
		int codigo =0;
		do{
			System.out.println("¿Qué empleado quiere consultar: ?");
			Scanner sc= new Scanner(System.in);
			try{
				codigo=sc.nextInt();
				correcto=true;
			}catch(InputMismatchException e){
				System.out.println("formato de codigo incorrecto");
			}
		}while(!correcto);
		Empleado emple=EmpleadoDao.consultaEmpleadoPorNumero(codigo);
		System.out.println("Datos del Empleado: ");
		System.out.println(emple);
		System.out.println("Datos de su departamento");
		System.out.println(emple.getDepartamento());
	}
	
}
