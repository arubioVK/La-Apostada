package apostada.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	private Date fecha;
	
	private int golLocal;
	private int golVisitante;
	
	//Valor entre "1"(Victoria Local)"2"(Empate)"3"(Victoria Visitante)
	private int resultado;
	
	public Partido(){}
	public Partido(Equipo el, Equipo eV, double cL, double cE, double cV, Date f){		equipoLocal=el;
	equipoVisitante = eV;
	cuotaLocal=cL;
	cuotaEmpate=cE;
	cuotaVisitante=cV;
	fecha = f;}
	public Partido(Equipo el, Equipo eV, double cL, double cE, double cV, Date f, int gL, int gV){
		equipoLocal=el;
		equipoVisitante = eV;
		cuotaLocal=cL;
		cuotaEmpate=cE;
		cuotaVisitante=cV;
		fecha = f;
		golLocal=gL;
		golVisitante = gV;
		if(gL>gV){resultado=1;}
		else if(gV>gL){ resultado=3;}
		else{resultado=2;}
		
	}
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal=equipoLocal;
	}
	
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante=equipoVisitante;
	}	
	
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	
	
	public double getCuotaEmpate() {
		return cuotaEmpate;
	}	
	public void setCuotaEmpate(double cuotaEmpate) {
		this.cuotaEmpate = cuotaEmpate;
	}

	public double getCuotaLocal() {
		return cuotaLocal;
	}

	public void setCuotaLocal(double cuotaLocal) {
		this.cuotaLocal = cuotaLocal;
	}

	public double getCuotaVisitante() {
		return cuotaVisitante;
	}

	public void setCuotaVisitante(double cuotaVisitante) {
		this.cuotaVisitante = cuotaVisitante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getGolLocal() {
		return golLocal;
	}

	public void setGolLocal(int golLocal) {
		this.golLocal = golLocal;
	}

	public int getGolVisitante() {
		return golVisitante;
	}

	public void setGolVisitante(int golVisitante) {
		this.golVisitante = golVisitante;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	
	
	
}
