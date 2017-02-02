package apostada.entidades;

import java.util.Calendar;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Generated;
import org.springframework.data.annotation.Id;

@Entity
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Equipo equipoLocal;
	@ManyToOne
	private Equipo equipoVisitante;
	
	private double cuotaLocal;
	private double cuotaEmpate;
	private double cuotaVisitante;
	
	private Calendar fecha;
	
	private int golLocal;
	private int golVisitante;
	
	
}
