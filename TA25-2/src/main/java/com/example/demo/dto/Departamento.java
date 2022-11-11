package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="departamento")
public class Departamento {

	//atributos de la entidad fabricante
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="departamento")
	private List<Empleado> empleado;

	//constructores
	
	public Departamento() {
		
	}
	
	public Departamento(Long id, String nombre, List<Empleado> empleado) {
		this.id = id;
		this.nombre = nombre;
		this.empleado = empleado;
	}

	//getters y setters
	
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

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado")
	public List<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}

	
	

	


	
	

	
	
	
	
	
	
}
