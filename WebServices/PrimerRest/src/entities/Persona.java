package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//clase persona

@Entity
public class Persona {
	@Id
	@GeneratedValue
	Integer id;
	String nombre =" Jhonatan ";
	String apellido =" Ruiz";
	//int edad = 20;
	int edad=20;
	double altura = 1.80;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellido, int edad, double altura) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		//this.edad = edad;
		this.altura = altura;
		this.edad = edad;
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
	/*public int getEdad() {
		return edad;
	}*/
	/*public void setEdad(int edad) {
		this.edad = edad;
	}*/
	public int getAnio() {
		return edad;
	}
	public void setAnio(int anio) {
		this.edad = anio;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
}
