package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import adaptadores.AdaptadorLocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@XmlRootElement // elemento a serializar
//el orde de como aparecen los atributos
//@XmlType(propOrder = { "titular", "fechaEstreno","duracion" })
@XmlAccessorType(XmlAccessType.FIELD)//none a ninugn atributo
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeliculaEclipse {
	@Id
	@GeneratedValue
	Integer id;
	@JsonProperty(value ="Title")
	String titulo;
	//Añadimos el adaptador al atributo que queremos  "Adaptar"
	@JsonProperty(value ="Genri")
	String genero;
	@XmlJavaTypeAdapter(AdaptadorLocalDate.class)
	@JsonProperty(value ="Released")
	LocalDate fechaEstreno;
	//LocalDate fechaEstreno;
	//@XmlTransient//nos permite ignorar un atributo cuando se rerializa 
	@JsonProperty(value ="Runtime")
	String duracion;
	@JsonProperty(value ="imdbrating")
	double puntuacionIMBD;
	@JsonProperty(value ="Plot")
	String descripcion;
	
	
	

	
	
	
	
	
	
}
