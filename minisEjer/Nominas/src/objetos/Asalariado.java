package objetos;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import utilidades.Utilidades;

public class Asalariado {

	private String nombre;
	private String apellido;
	private int dni;
	private Nomina nomina;
	
	public Asalariado(){
		
	}

	public Asalariado(String nombre, String apellido, int dni, Nomina nomina) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		
	}

	public Asalariado(String nombre, String apellido, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nomina = nomina;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Nomina getNomina() {
		return nomina;
	}

	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}
	public String toString(){
		return "Asalariado [Nombre= "+this.nombre + 
				", Apellido= "+this.apellido+ 
				", Dni= "+ this.dni+ 
				", ]";
	}
		public void pedirDatos() throws ParseException{
		    
	    	boolean correcto=false;
	    	 do{
	    		 try{
	    	 
	    	 Scanner sc=new Scanner(System.in);
			 System.out.println("Introduzca el Nombre del Asalariado: ");
			 this.nombre=sc.nextLine();
			 
			 System.out.println("Introduzca el Apellido del Asalariado : ");
			 this.apellido=sc.nextLine();
			 
			 System.out.println("Introduzca el Dni del Asalariado : ");
			 this.dni=sc.nextInt();
			 
			 correcto=true;
			 
	    			 }catch(InputMismatchException es){
	    				 System.out.println("Dato incorrecto, introduzca los datos de nuevo: ");
	    				 }
	    		 }while(!correcto);
	  }
}
	

