package objetos;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import utilidades.Utilidades;

public class Empleado {

	private int numero;
	private String nombre;
	private String oficio;
	private int direccion;
	private Date fechaAlta;
	private int salario;
	private int comision;
	private Departamento departamento;
	
	public Empleado(){
		
	}
	
	public Empleado(int numero, String nombre, String oficio, int direccion, Date fechaAlta, int salario,
			int comision) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.oficio = oficio;
		this.direccion = direccion;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.comision = comision;
	}

	public Empleado(int numero, String nombre, String oficio, int direccion, Date fechaAlta, int salario,
			int comision, Departamento departamento) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.oficio = oficio;
		this.direccion = direccion;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.comision = comision;
		this.departamento = departamento;
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
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public String toString(){
		return "Empleado [numero="+this.numero+ ", nombre="+this.nombre+ ", oficio="+this.oficio+", direccion="+ this.direccion+
				", fechaAlta="+this.fechaAlta+", Salario="+this.salario+" Comision="+ this.comision+"]";
	
	}
	
	public void peditDatos(){
	    
    	boolean correcto=false;
    	 do{
    		 try{
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Introduzca el numero del empleado: ");
		 this.numero=sc.nextInt();
		 
		 System.out.println("Introduzca el nombre del empleado: ");
		 this.nombre=sc.nextLine();
		 
		 System.out.println("Introduzca el oficio del empleado: " );
		 this.oficio=sc.nextLine();
		
		 System.out.println("Introduzca la direccio del empleado: ");
		 this.direccion=sc.nextInt();
		 
		 System.out.println("Introduzca la fecha de alta en el formato dd/mm/aaaa: ");
		 String fechaString=sc.nextLine();
		 this.fechaAlta=Utilidades.parsearFechaString(fechaString);
 	     sc=new Scanner(System.in);
 	     
 	    System.out.println("Introduzca el salario del empleado: ");
		 this.salario=sc.nextInt();
		 
		 System.out.println("Introduzca la comision del empleado: ");
		 this.comision=sc.nextInt();
		 
		
    			 correcto=true;
    			 }catch (ParseException e){
    			 System.out.println("Fortmano no válido. ");
    			 }catch(InputMismatchException es){
    				 System.out.println("Dato incorrecto, introduzca los datos de nuevo: ");
    				 }
    		 }while(!correcto);
  }
	
}
