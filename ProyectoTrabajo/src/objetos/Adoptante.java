package objetos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Adoptante {

	private int claveAdopt;
	private String nombre;
	private String apellido;
	private int telefono;
	private int claveani;
	private ArrayList<Animal> animales;
	
	public Adoptante(){
		this.animales= new ArrayList<Animal>();
	}
	public Adoptante(int claveAdopt, String nombre, String apellido,
			int telefono, int claveani){
		this.animales= new ArrayList<Animal>();
	}
	public Adoptante(int claveAdopt, String nombre, String apellido,
			int telefono, int claveani, ArrayList<Animal> animales){
		this.animales=animales;
		this.claveAdopt=claveAdopt;
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
		this.claveani=claveani;
	}
	public int getClaveani() {
		return claveani;
	}
	public void setClaveani(int claveani) {
		this.claveani = claveani;
	}
	public int getClaveAdopt() {
		return claveAdopt;
	}
	public void setClaveAdopt(int claveAdopt) {
		this.claveAdopt = claveAdopt;
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public ArrayList<Animal> getAnimales() {
		return animales;
	}
	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}
	public String toString(){
		return "Adoptantes [clave = "+this.claveAdopt+
				", Nombre= "+ this.nombre+
				", Apellido= " +this.apellido+
				", Telefono= " +this.telefono+" ]";
	}
	public void peditDatos(){
	    
    	boolean correcto=false;
    	 do{
    	 Scanner sc=new Scanner(System.in);
    	 try{
    		 System.out.println("Introduzca la clave del adoptante: ");
    		 this.claveAdopt=sc.nextInt();
    		 System.out.println("Introduzca el nombre del adoptante: ");
    		 this.nombre=sc.nextLine();
    		 System.out.println("Introduzca el apellido del adoptante: ");
    		 this.apellido=sc.nextLine();
    		 System.out.println("Introduzca el teléfono del adoptante: ");
    		 this.telefono=sc.nextInt();
    		 System.out.println("Introduzca la clave del animal");
    		 this.claveani=sc.nextInt();
    		 correcto=true;
    	 }catch(InputMismatchException es){
    		 System.out.println("Datos incorrectos, introduzca los datos de nuevo: ");
    	 }
    	 
    }while(!correcto);
  }
}
