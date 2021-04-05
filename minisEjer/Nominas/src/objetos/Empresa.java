package objetos;

import java.util.ArrayList;

public class Empresa {
	private int cif;
	private String nombre;
	private ArrayList <Nomina> nominas;
	
	public Empresa(){
		this.nominas=new ArrayList<Nomina>();
	}
	
	public Empresa(int cif, String nombre){
		this.nominas=new ArrayList<Nomina>();
		this.cif=cif;
		this.nombre=nombre;
	}
	
	public Empresa(int cif, String nombre, ArrayList<Nomina>nominas){
		this.nominas=nominas;
		this.cif=cif;
		this.nombre=nombre;
	}
	
	public String toString(){
		return "Empresa [cif="+this.cif+ ", nombre="+ this.nombre+"]";
	}

	public int getCif() {
		return cif;
	}
	public void setCif(int cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Nomina> getNominas() {
		return nominas;
	}
	public void setNominas(ArrayList<Nomina> nominas) {
		this.nominas = nominas;
	}
}
