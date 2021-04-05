package beans;

public class Cuenta {
	
	String iban;
	String nombre;
	String apellidos;
	double saldo;
	public Cuenta() {
		
	}
	public Cuenta(String iban,String nombre ,String apellidos,double saldo) {
		this.iban=iban;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.saldo=saldo;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
