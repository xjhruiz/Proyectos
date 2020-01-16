package objetos;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import utilidades.Utilidades;

public class Adopcion {

	private int clave;
	private Date fecha;
	private int claveAni;
	private int claveAdopt;
	private Adoptante adoptantes;
	private Animal animales;
	
	public Adopcion() {

	}

	public Adopcion(int clave, Date fecha, int claveAni, int claveAdopt) {
		super();
		this.clave = clave;
		this.fecha = fecha;
		this.claveAni = claveAni;
		this.claveAdopt = claveAdopt;
	}

	public Adopcion(int clave, Date fecha, int claveAni, int claveAdopt, Adoptante adoptantes, Animal animales) {
		super();
		this.clave = clave;
		this.fecha = fecha;
		this.claveAni = claveAni;
		this.claveAdopt = claveAdopt;
		this.adoptantes = adoptantes;
		this.animales = animales;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getClaveAni() {
		return claveAni;
	}

	public void setClaveAni(int claveAni) {
		this.claveAni = claveAni;
	}

	public int getClaveAdopt() {
		return claveAdopt;
	}

	public void setClaveAdopt(int claveAdopt) {
		this.claveAdopt = claveAdopt;
	}

	public Adoptante getAdoptantes() {
		return adoptantes;
	}

	public void setAdoptantes(Adoptante adoptantes) {
		this.adoptantes = adoptantes;
	}

	public Animal getAnimales() {
		return animales;
	}

	public void setAnimales(Animal animales) {
		this.animales = animales;
	}
	public String toString(){
		return "Adopciones[ Clave = "+this.clave+", fecha"+ this.fecha+
				", Clave Animal ="+this.claveAni+", "+this.claveAdopt+", ]";
	}
	public void PedirDatos(){
		boolean correcto=false;
   	 do{
   		 try{
   	 Scanner sc=new Scanner(System.in);
   	 System.out.println("Introduzca la clave de la adopcion: ");
		 this.clave=sc.nextInt();
		 
		 System.out.println("Introduzca la fecha de de la adopcion dd/mm/aaaa: ");
		 String fechaString=sc.nextLine();
		 this.fecha=Utilidades.parsearFechaString(fechaString);
	     sc=new Scanner(System.in);
	     
		 System.out.println("Introduzca la clave del animal: " );
		 this.claveAni=sc.nextInt();
		
		 System.out.println("Introduzca la clave del adoptante: ");
		 this.claveAdopt=sc.nextInt();
		 correcto=true;
   			 }catch (ParseException e){
   			 System.out.println("Fortmano no válido. ");
   			 }catch(InputMismatchException es){
   				 System.out.println("Dato incorrecto, introduzca los datos de nuevo: ");
   				 }
   		 }while(!correcto);
 }
		
	}
	

