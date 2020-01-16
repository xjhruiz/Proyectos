package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@XmlRootElement
public class Opinion {

	public Opinion() {
		super();
	}
	@Id
	@GeneratedValue
	private Integer id;
	@JsonProperty
	private int puntuacion;
	@JsonProperty
	private String mensaje;
	@ManyToOne
	@JsonProperty
	private Usuario critico;
	@ManyToOne
	@JsonProperty
	private Usuario criticado;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Usuario getCritico() {
		return critico;
	}
	public void setCritico(Usuario critico) {
		this.critico = critico;
	}
	public Usuario getCriticado() {
		return criticado;
	}
	public void setCriticado(Usuario criticado) {
		this.criticado = criticado;
	}
	public Opinion(int puntuacion, String mensaje, Usuario critico, Usuario criticado) {
		super();
		this.puntuacion = puntuacion;
		this.mensaje = mensaje;
		this.critico = critico;
		this.criticado = criticado;
	}
	
	
	
	
	
}
