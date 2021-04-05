package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@XmlRootElement
public class Usuario {

	@Id
	@JsonProperty
	private String userName;
	@JsonProperty
	private String password;
	@JsonProperty
	private String email;
	@JsonProperty
	private String nombreApellidos;
	@JsonProperty
	private String telefono;
	@JsonProperty
	private String ciudad;
	
	public Usuario() {
		super();
	}
	
	
	public Usuario(String userName, String password, String email, String nombreApellidos,
			 String telefono, String ciudad) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.nombreApellidos = nombreApellidos;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}


	public String getNombreApellidos() {
		return nombreApellidos;
	}
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
