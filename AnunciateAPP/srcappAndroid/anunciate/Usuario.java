package com.example.jhonatan.anunciate;


public class Usuario {


	 String userName;
	 String password;
	 String email;
	 String nombreApellidos;
	 String telefono;
	 String ciudad;
	
	public Usuario() {

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
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
