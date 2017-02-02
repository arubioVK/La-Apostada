package apostada.entidades;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class Liga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany(mappedBy="liga")
	private List<Equipo> equipos;
}
