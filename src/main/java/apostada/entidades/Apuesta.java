package apostada.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

@Entity
public class Apuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Partido partido;
	
	private double cuota;
	private double cantidadApostada;
	
	//Valor entre "1"(Victoria Local)"2"(Empate)"3"(Victoria Visitante)
	private int resultado;
	
	public Apuesta(){}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	public Partido getPartido(){
		return partido;
	}
	
	public void setPartido(Partido partido){
		this.partido=partido;
	}

	public double getCuota() {
		return cuota;
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

}
