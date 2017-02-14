package apostada.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String email;
	private String password;
	private double puntos;
	
	@OneToMany(mappedBy="user")
	private List<Apuesta> apuestas;
	
	public Usuario(){}

	public Usuario(String n, String e, String p){
		name = n;
		email = e;
		password = p;
		puntos = 1000;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}
	public List<Apuesta> getApuestas() {
		return apuestas;
	}
	
	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	public void restarPuntos(double puntos){
		this.puntos -=puntos;
	}
	
}
