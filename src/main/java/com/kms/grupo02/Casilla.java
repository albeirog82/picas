package com.kms.grupo02;

public class Casilla {
	
	public static final String SIN_USAR = "sin_usar";
	public static final String DESCARTADO = "descartado";
	public static final String PICA = "pica";
	public static final String PICA_FIJA = "pica_fija";
	public static final String FIJA = "fija";
	
	private Integer puntaje; 
	private String estado;
	
	public Casilla(){
		this.puntaje = 0;
		this.estado = "sin_usar";
	}
	

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		estado = estado;
	}  
	
	

}
