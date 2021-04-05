package entities;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)// le decimos que ignore las propiedades que no estan aca
public class PeliculaOMDB {

	@JsonProperty(value="Title")// le decimos que es una propiedad del json
	String titulo ;
	@JsonProperty(value="Year")
	int anio;
	@JsonProperty(value="Released")
	String liberado;
}
