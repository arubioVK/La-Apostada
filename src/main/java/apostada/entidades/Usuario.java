package apostada.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {

	public static final int PUNTOS_POR_DEFECTO = 1000;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String email;
	private String passwordHash;
	private double puntos;

	@OneToMany(mappedBy = "user")
	private List<Apuesta> apuestas;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	public Usuario() {
		
	}

	public Usuario(String n, String e, String p) {
		name = n;
		email = e;
		puntos = PUNTOS_POR_DEFECTO;
		passwordHash = new BCryptPasswordEncoder().encode(p);
		roles = new ArrayList<String>();
		roles.add("ROLE_USER");
	}
	
	public Usuario(String n, String e, String p, String rol) {
		name = n;
		email = e;
		puntos = PUNTOS_POR_DEFECTO;
		passwordHash = new BCryptPasswordEncoder().encode(p);
		roles = new ArrayList<String>();
		roles.add(rol);
	}

	public Usuario(String n, String e, String p, String rol) {
		name = n;
		email = e;
		password = p;
		puntos = PUNTOS_POR_DEFECTO;
		roles = new ArrayList<>();
		roles.add(rol);
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public double getPuntos() {
		return puntos;
	}

	public void addPuntos(double puntos) {
		this.puntos += puntos;
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

	public void sumarPuntos(double puntos) {
		this.puntos += puntos;
	}

	public void restarPuntos(double puntos) {
		this.puntos -= puntos;
	}

	public void reclamarApuestas(List<Apuesta> aciertos) {
		double cantidad = 0;
		for (Apuesta acierto : aciertos) {
			cantidad += acierto.getCuota() * acierto.getCantidadApostada();
		}
		sumarPuntos(cantidad);
	}
	
	public List<String> getRoles() {
		return roles;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
