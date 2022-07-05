package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@PrimaryKeyJoinColumn(name="usu_codigo")
@Component
public class Ciudadano extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6553898866157297477L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ciu_codigo")
	private int codigo;
	@Column(name = "dni")
	@NotBlank
	@Size(min=8, max=8, message = "Debe tener 8 cifras sin guiones")
	private String dni;
	@Column(name = "nroTramite")
	@NotBlank(message="El dni no puede quedar en blanco")
	@Size(min=11, max=11, message = "Debe tener un maximo de 11 cifras")
	private String nroT;
	@Column(name = "estadoC")
	@NotBlank(message = "Debe elegir una opcion")
	private String estadoC;
	@Column(name = "nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd") @Past(message = "La fecha no es correcta")
	@NotNull
	private LocalDate fechaNacimiento;
	@Column(name="estado")
	private boolean estado;
	//-----CIUDADANO A CV----- IMPLICA QUE UN SOLO USUARIO SOLO PUEDE TENER UN TIPO CV
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Cv cv;
	
	//-----CIUDADANO A USUARIO----- IMPLICA QUE UN SOLO USUARIO SOLO PUEDE PERTENECER A UN SOLO TIPO CIUDADANO
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Usuario usuario;
	
	//-----CIUDADANO A OFERTAS----- IMPLICA QUE UN SOLO USUARIO SOLO PUEDE TENER VARIAS OFERTAS A LAS QUE SE POSTULE GUARDADAS EN UNA LISTA
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Oferta> ofertas;
	
	
	public String getNroT() {
		return nroT;
	}
	public void setNroT(String nroT) {
		this.nroT = nroT;
	}
	public String getEstadoC() {
		return estadoC;
	}
	public void setEstadoC(String estadoC) {
		this.estadoC = estadoC;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Cv getCv() {
		return cv;
	}
	public void setCv(Cv cv) {
		this.cv = cv;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
