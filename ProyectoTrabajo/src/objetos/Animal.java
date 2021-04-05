package objetos;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase para la coger los datos de Animales
 * @author Jhonatan
 * 
 *
 */
public class Animal {

	private int clave;
	private String tipo;
	private String edad;
	private String nombre;
	
	public Animal(){
		
	}

	public Animal(int clave, String tipo, String edad, String nombre) {
		super();
		this.clave = clave;
		this.tipo = tipo;
		this.edad = edad;
		this.nombre = nombre;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString(){
		return "Animal [ Clave=" +this.clave+
				",Tipo = "+this.tipo+
				", Edad =" +this.edad+
				", Nombre=" +this.nombre +",]";
				
	}
	public void pedirDatos(){
		boolean correcto=false;
		do{
			try{
				Scanner sc= new Scanner(System.in);
				System.out.println("Introducza la id del animal: ");
				this.clave=sc.nextInt();
				
				System.out.println("Introduzca el tipo de animal: ");
				this.tipo=sc.nextLine();
				
				System.out.println("Introduzca la edad del animal ");
				System.out.println("[Cachorro, Joven, Adulto]");
				this.tipo=sc.nextLine();
				//intentar hacer un do while para que sólo introduzca
				//los anteriores datos.
				System.out.println("Introduzca el nombre del animal: ");
				this.nombre=sc.nextLine();
				correcto=true;
			}catch (InputMismatchException es){
				System.out.println("Dato incorrecto, introduzca los datos de nuevo:");
			}
			
		}while(!correcto);	
	}
		
	
	
	
	
}
