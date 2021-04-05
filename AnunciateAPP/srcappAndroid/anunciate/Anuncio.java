package com.example.jhonatan.anunciate;




public class Anuncio {

	Integer id;
	String fechaAnuncio;
	String funcionLaboral;
	String pago;
	String direccion;
	String ciudad;
	String jornada;
	String detalles;
	String etiquetas;
	String estado;
	Usuario autor;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaAnuncio() {
		return fechaAnuncio;
	}

	public void setFechaAnuncio(String fechaAnuncio) {
		this.fechaAnuncio = fechaAnuncio;
	}

	public String getFuncionLaboral() {
		return funcionLaboral;
	}

	public void setFuncionLaboral(String funcionLaboral) {
		this.funcionLaboral = funcionLaboral;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Anuncio() {

	}

	public Anuncio(String fechaAnuncio, String funcionLaboral, String pago, String direccion, String ciudad, String jornada, String detalles, String etiquetas, String estado, Usuario autor) {
		this.fechaAnuncio = fechaAnuncio;
		this.funcionLaboral = funcionLaboral;
		this.pago = pago;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.jornada = jornada;
		this.detalles = detalles;
		this.etiquetas = etiquetas;
		this.estado = estado;
		this.autor = autor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
