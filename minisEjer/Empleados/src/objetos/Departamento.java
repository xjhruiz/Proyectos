package objetos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Departamento {

	private  int numero;
	private String nombre;
    private String localizacion;
    private ArrayList<Empleado> empleados;
	
    public Departamento(){
    	this.empleados= new ArrayList<Empleado>();
    	
    }
    public Departamento(int numero, String nombre, String localizacion){
    	this.empleados= new ArrayList<Empleado>();
    	this.numero=numero;
    	this.nombre=nombre;
    	this.localizacion=localizacion;
    	
    }
    
    public Departamento(int numero, String nombre, String localizacion,
    	ArrayList<Empleado> empleados){
    	this.empleados=empleados;
    	this.numero=numero;
    	this.nombre=nombre;
    	this.localizacion=localizacion;
    	
    }
    
    public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
    public String toString(){
    	return "Departamento [numero=" + this.numero + ", nombre=" + this.nombre + ", localizacion=" + this.localizacion  + "]";
    }
    
    public void peditDatos(){
    
    	boolean correcto=false;
    	 do{
    	 Scanner sc=new Scanner(System.in);
    	 try{
    		 System.out.println("Introduzca el numero de departamento: ");
    		 this.numero=sc.nextInt();
    		 System.out.println("Introduzca el numero de departamento: ");
    		 this.nombre=sc.nextLine();
    		 System.out.println("Introduce la localizacion del departamento: ");
    		 this.localizacion=sc.nextLine();
    		 correcto=true;
    	 }catch(InputMismatchException es){
    		 System.out.println("Dato incorrecto, introduzca los datos de nuevo: ");
    	 }
    	 
    }while(!correcto);
  }
}
