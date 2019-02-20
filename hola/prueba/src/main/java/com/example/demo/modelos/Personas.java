package com.example.demo.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Personas")

public class Personas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3378278172972470310L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "LSalida")
	private String LSalida;

	@Column(name = "LLlegada")
	private String LLlegada;
	
	@Column(name = "estado")
	private String estado;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLSalida() {
		return LSalida;
	}

	public void setLSalida(String lSalida) {
		LSalida = lSalida;
	}

	public String getLLlegada() {
		return LLlegada;
	}

	public void setLLlegada(String lLlegada) {
		LLlegada = lLlegada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Personas [id=" + id + ", nombre=" + nombre + ", LSalida=" + LSalida + ", LLlegada=" + LLlegada
				+ ", estado=" + estado + "]";
	}



}
