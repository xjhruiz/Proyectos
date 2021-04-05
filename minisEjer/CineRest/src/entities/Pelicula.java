package entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import adaptadores.AdaptadorLocalDate;

/**
 * Created by user on 01/03/2018.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pelicula {
	
	@Id
    private String Title;
    private String Actors;
    @XmlJavaTypeAdapter(AdaptadorLocalDate.class)
    private LocalDate Released;
    private String Poster;

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public LocalDate getReleased() {
        return Released;
    }

    public void setReleased(LocalDate realeased) {
        Released = realeased;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String urlPoster) {
        this.Poster = urlPoster;
    }
}
