package entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@XmlRootElement
public class Anuncio {

	@Id
	@GeneratedValue
	int id;
	//@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonProperty
	LocalDateTime fechaAnuncio;
	@JsonProperty
	String funcionLaboral;
	@JsonIgnoreProperties(ignoreUnknown = true)
	String pago;
	@JsonProperty
	String direccion;
	@JsonProperty
	String ciudad;
	@JsonProperty
	String jornada;
	@JsonProperty
	String detallesOferta;
	@JsonProperty
	String etiquetas;
	@JsonProperty
	@ManyToOne
	Usuario autor;
	
	
	public Anuncio() {
		super();
	}
	
	public Anuncio( LocalDateTime fechaAnuncio, String funcionlaboral, String pago, String direccion,
			String ciudad, String jornada, String detallesoferta, String etiquetas, Usuario autor) {
		super();
		this.fechaAnuncio = fechaAnuncio;
		this.funcionLaboral = funcionlaboral;
		this.pago = pago;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.jornada = jornada;
		this.detallesOferta = detallesoferta;
		this.etiquetas = etiquetas;
		this.autor = autor;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getFechaAnuncio() {
		return fechaAnuncio;
	}
	public void setFechaAnuncio(LocalDateTime fechaAnuncio) {
		this.fechaAnuncio = fechaAnuncio;
	}
	public String getFuncionlaboral() {
		return funcionLaboral;
	}
	public void setFuncionlaboral(String funcionlaboral) {
		this.funcionLaboral = funcionlaboral;
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
	public String getDetallesoferta() {
		return detallesOferta;
	}
	public void setDetallesoferta(String detallesoferta) {
		this.detallesOferta = detallesoferta;
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
	
}
