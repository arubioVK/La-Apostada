package apostada.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@ManyToOne
	private Liga liga;
	
	@JsonIgnore
	@OneToMany(mappedBy="equipoLocal")
	private List<Partido>partidosLocal;
	
	@JsonIgnore
	@OneToMany(mappedBy="equipoVisitante")
	private List<Partido>partidosVisitante;
	
	public Equipo(){}
	
	public Equipo(String n, Liga l) {
		name = n;
		liga = l;		
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Liga getLiga() {
		return liga;
	}
	
	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	
	public List<Partido> getPartidosLocal() {
		return partidosLocal;
	}
	
	public void setPartidosLocal(List<Partido> partidosLocal) {
		this.partidosLocal=partidosLocal;
	}
	
	public List<Partido> getPartidosVisitante() {
		return partidosVisitante;
	}
	
	public void setPartidosVisitante(List<Partido> partidosVisitante) {
		this.partidosVisitante = partidosVisitante;
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Equipo other = (Equipo) obj;
		return this.id == other.id;
	}
	
}
