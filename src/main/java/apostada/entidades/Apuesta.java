package apostada.entidades;

import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Apuesta {

	public final static int RESULTADO_VICTORIA_LOCAL = 1;
	public final static int RESULTADO_EMPATE = 2;
	public final static int RESULTADO_VICTORIA_VISITANTE = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Partido partido;
	@ManyToOne
	private Usuario user;
	private double cuota;
	private double cantidadApostada;
	private Date fecha;

	// Valor entre "1"(Victoria Local)"2"(Empate)"3"(Victoria Visitante)
	private int resultado;

	private boolean reclamado;

	public Apuesta() {
	}

	public Apuesta(Partido p, Usuario u, double c, double ca, Date f, int r) {
		partido = p;
		user = u;
		cuota = c;
		cantidadApostada = ca;
		fecha = f;
		resultado = r;
		reclamado = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public double getCuota() {
		return Double.parseDouble(String.format(Locale.ROOT, "%.2f", cuota));
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getCantidadApostada() {
		return cantidadApostada;
	}

	public void setCantidadApostada(double cantidadApostada) {
		this.cantidadApostada = cantidadApostada;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaBuena() {
		return String.format("%02d", fecha.getDate()) + "/" + String.format("%02d", fecha.getMonth())
				+ " " + String.format("%02d", fecha.getHours()) + ":" + String.format("%02d", fecha.getMinutes());
	}

	public boolean isReclamado() {
		return reclamado;
	}

	public void setReclamado(boolean reclamado) {
		this.reclamado = reclamado;
	}

}
