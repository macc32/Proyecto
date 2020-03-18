package com.ABPApp.ws.rest.vo;

public class VOCurso {
	
	String nombre;
	VOUsuario estudiante;
	VOUsuario profesor;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public VOUsuario getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(VOUsuario estudiante) {
		this.estudiante = estudiante;
	}
	public VOUsuario getProfesor() {
		return profesor;
	}
	public void setProfesor(VOUsuario profesor) {
		this.profesor = profesor;
	}
	
}
