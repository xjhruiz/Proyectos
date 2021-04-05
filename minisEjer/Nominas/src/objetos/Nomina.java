package objetos;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Nomina {

	private int mes;
	private int anio;
	private int dni;
	private int cif;
	private int salarioBase;
	private int complsalario;
	private int horasext;
	private int salariobruto;
	private int impuestos;
	private ArrayList<Asalariado> asalariado;
	private Asalariado asalariados;
	private Empresa empresa;
	
	public Nomina(){
		this.asalariado=new ArrayList<Asalariado>();
	}

	public Nomina(int mes, int anio, int dni, int cif, int salariobase, int complsalario, int horasext,
			int salariobruto, int impuestos) {
		super();
		this.asalariado = new ArrayList<Asalariado>();
		this.mes = mes;
		this.anio = anio;
		this.dni = dni;
		this.cif = cif;
		this.salarioBase = salariobase;
		this.complsalario = complsalario;
		this.horasext = horasext;
		this.salariobruto = salariobruto;
		this.impuestos = impuestos;
	}
	
	public Nomina(int mes, int anio, int dni, int cif, int salariobase, int complsalario, int horasext,
			int salariobruto, int impuestos, ArrayList<Asalariado> asalariado) {
		super();
		this.mes = mes;
		this.anio = anio;
		this.dni = dni;
		this.cif = cif;
		salarioBase = salariobase;
		this.complsalario = complsalario;
		this.horasext = horasext;
		this.salariobruto = salariobruto;
		this.impuestos = impuestos;
		this.asalariado = asalariado;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCif() {
		return cif;
	}

	public void setCif(int cif) {
		this.cif = cif;
	}

	public int getSalariobase() {
		return salarioBase;
	}

	public void setSalariobase(int salariobase) {
		salarioBase = salariobase;
	}

	public int getComplsalario() {
		return complsalario;
	}

	public void setComplsalario(int complsalario) {
		this.complsalario = complsalario;
	}

	public int getHorasext() {
		return horasext;
	}

	public void setHorasext(int horasext) {
		this.horasext = horasext;
	}

	public int getSalariobruto() {
		return salariobruto;
	}

	public void setSalariobruto(int salariobruto) {
		this.salariobruto = salariobruto;
	}

	public int getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(int impuestos) {
		this.impuestos = impuestos;
	}

	public ArrayList<Asalariado> getAsalariado() {
		return asalariado;
	}

	public void setAsalariado(ArrayList<Asalariado> asalariado) {
		this.asalariado = asalariado;
	}
	
	public String toString(){
		return "Nómina [mes= " + this.mes + ", año= " + this.anio + ", dni= " + this.dni + ", cif= " + this.cif +
				", Salariobase= " + this.salarioBase + ", complsalario= " + this.complsalario + ", horasext= " +
				this.horasext + ", salariobruto= " + this.salariobruto + ", impuestos= " + this.impuestos + "]";
	}
	public void pedirDatos() throws ParseException{
	    
    	boolean correcto=false;
    	 do{
    		 try{
    	 
    	 Scanner sc=new Scanner(System.in);
		 System.out.println("Introduzca el mes de la nómina: ");
		 this.mes=sc.nextInt();
		 
		 System.out.println("Introduzca el año de la nómina: ");
		 this.anio=sc.nextInt();
		 
		 System.out.println("Introduzca el Dni de la nómina : ");
		 this.dni=sc.nextInt();
		 
		 System.out.println("Introduzca el cif de la nómina : ");
		 this.cif=sc.nextInt();
		 
		 System.out.println("Introduzca el Salario Base de la nómina : ");
		 this.salarioBase=sc.nextInt();
		 
		 System.out.println("Introduzca el Complemento salario de la nómina : ");
		 this.complsalario=sc.nextInt();
		 
		 System.out.println("Introduzca las horas extras: ");
		 this.horasext=sc.nextInt();
		 
		 System.out.println("Introduzca el salario bruto de la nómina: ");
		 this.salariobruto=sc.nextInt();
		 
		 System.out.println("Introduzca los impuestos de la nómina : ");
		 this.impuestos=sc.nextInt();
		 
		 correcto=true;
		 
    			 }catch(InputMismatchException es){
    				 System.out.println("Dato incorrecto, introduzca los datos de nuevo: ");
    				 }
    		 }while(!correcto);
  }


}
