package apostada.entidades;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.Id;

@Entity
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@ManyToOne
	private Liga liga;
	
	@OneToMany(mappedBy="equipoLocal")
	private List<Partido>partidosLocal;
	@OneToMany(mappedBy="equipoVisitante")
	private List<Partido>partidosVisitante;
	
}
