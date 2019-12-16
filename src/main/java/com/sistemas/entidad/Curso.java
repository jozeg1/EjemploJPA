package com.sistemas.entidad;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name="Curso")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	@Column(length=60, nullable=false)
	@NotBlank(message="El código no puede estar vacio")
	@Size(min=2, max=8, message="El código debe tener 8 caracteres")
	public long codigo;
	
	@Column(length=60)
	public String descripcion;
	
	@Column(length=15)
	public String sumilla;
	
	@Column(length=60)
	public long creditos;
	
	@Column(length=60)
	public long ciclo;
	
	@Column(length=60)
	public long horasTeoria;
	
	@Column(length=60)
	public long horasPractica;

	
	public Curso() {
		
	}
		
	public Curso(long id, long codigo, String descripcion, String sumilla, 
			long creditos, long ciclo, long horasTeoria, long horasPractica) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.sumilla = sumilla;
		this.creditos = creditos;
		this.ciclo = ciclo;
		this.horasTeoria = horasTeoria;
		this.horasPractica = horasPractica;
	}
	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", sumilla=" + sumilla
				+ ", creditos=" + creditos + ", ciclo=" + ciclo + ", horasTeoria=" + horasTeoria + ", horasPractica="
				+ horasPractica + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSumilla() {
		return sumilla;
	}

	public void setSumilla(String sumilla) {
		this.sumilla = sumilla;
	}

	public long getCreditos() {
		return creditos;
	}

	public void setCreditos(long creditos) {
		this.creditos = creditos;
	}

	public long getCiclo() {
		return ciclo;
	}

	public void setCiclo(long ciclo) {
		this.ciclo = ciclo;
	}

	public long getHorasTeoria() {
		return horasTeoria;
	}

	public void setHorasTeoria(long horasTeoria) {
		this.horasTeoria = horasTeoria;
	}

	public long getHorasPractica() {
		return horasPractica;
	}

	public void setHorasPractica(long horasPractica) {
		this.horasPractica = horasPractica;
	}
	
	
	
}
