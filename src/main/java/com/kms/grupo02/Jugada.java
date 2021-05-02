package com.kms.grupo02;


public class Jugada {
	
	private Integer digitoUno;
	
	private Integer digitoDos; 
	
	private Integer digitoTres; 
	
	private Integer digitoCuatro;

	private Integer picas; 
	
	private Integer fijas;
	
	public Jugada() {
		this.picas = 0; 
		this.fijas = 0;
	}
	
	public void crear_valores_jugada(){
		this.digitoUno = 0; 
		this.digitoDos = 0; 
		System.out.println("El valor a adivinar es " + this.digitoUno + this.digitoDos + " ?");
	}
	
	public Jugada(int picas, int fijas) {
		this.picas = picas;
		this.fijas = fijas;
		this.digitoUno = null; 
		this.digitoDos = null; 
	}
	
	public int getDigitoUno() {
		return digitoUno;
	}

	public void setDigitoUno(int digitoUno) {
		this.digitoUno = digitoUno;
	}

	public int getDigitoDos() {
		return digitoDos;
	}

	public void setDigitoDos(int digitoDos) {
		this.digitoDos = digitoDos;
	}

	public int getDigitoTres() {
		return digitoTres;
	}

	public void setDigitoTres(int digitoTres) {
		this.digitoTres = digitoTres;
	}

	public int getDigitoCuatro() {
		return digitoCuatro;
	}

	public void setDigitoCuatro(int digitoCuatro) {
		this.digitoCuatro = digitoCuatro;
	}

	public int getPicas() {
		return picas;
	}

	public void setPicas(int picas) {
		this.picas = picas;
	}

	public int getFijas() {
		return fijas;
	}

	public void setFijas(int fijas) {
		this.fijas = fijas;
	}



}
