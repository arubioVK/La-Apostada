package apostada.entidades;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Partido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Equipo equipoLocal;
	@ManyToOne
	private Equipo equipoVisitante;
	
	@OneToMany
	private List<Apuesta> apuestas;
	
	private double cuotaLocal;
	private double cuotaEmpate;
	private double cuotaVisitante;
	
	private Date fecha;
	
	@Transient
	private String fechaBuena;
	
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
		fecha = f;
	}
	public Partido(Equipo el, Equipo eV, double cL, double cE, double cV, Date f, int gL, int gV){
		equipoLocal=el;
		equipoVisitante = eV;
		cuotaLocal=cL;
		cuotaEmpate=cE;
		cuotaVisitante=cV;
		fecha = f;
		golLocal=gL;
		golVisitante = gV;
		if(gL>gV){resultado = Apuesta.RESULTADO_VICTORIA_LOCAL;}
		else if(gV>gL){ resultado = Apuesta.RESULTADO_VICTORIA_VISITANTE;}
		else{resultado = Apuesta.RESULTADO_EMPATE;}
		
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

	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	
	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	public String getFechaBuena() {
		return String.format("%02d", fecha.getDate()) + "/" + String.format("%02d", fecha.getMonth())
				+ " " + String.format("%02d", fecha.getHours()) + ":" + String.format("%02d", fecha.getMinutes());
	}
	
	public void ajusteCuota(double cantidad, int resultado){
		double ajusteap =cantidad /1000;
		double ajusteot = ajusteap / 2;
		if(resultado == Apuesta.RESULTADO_VICTORIA_LOCAL) {
			this.cuotaEmpate +=ajusteot;
			this.cuotaVisitante+=ajusteot;
			this.cuotaLocal -= ajusteap;
			if(this.cuotaLocal < 1.01) {
				this.cuotaLocal = 1.01;
			}
		} else if(resultado == Apuesta.RESULTADO_EMPATE){
			this.cuotaLocal +=ajusteot;
			this.cuotaVisitante+=ajusteot;
			this.cuotaEmpate -= ajusteap;
			if(this.cuotaEmpate < 1.01) {
				this.cuotaEmpate = 1.01;
			}
		} else {
			this.cuotaLocal +=ajusteot;
			this.cuotaEmpate+=ajusteot;
			this.cuotaVisitante -= ajusteap;
			if(this.cuotaVisitante < 1.01) {
				this.cuotaVisitante = 1.01;
			}
		}
	}
	
}
