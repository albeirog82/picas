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
	
	public void probar(int valor){
		Tablero tablero = Tablero.getInstance();
		System.out.println("Valor prueba antes " + tablero.getValorPrueba());
		tablero.setValorPrueba(valor);
		System.out.println("Valor prueba despues " + tablero.getValorPrueba());
	}
	
	public void crear_valores_jugada(){
		
		Tablero tablero = Tablero.getInstance();
		
		//Obtener primera cifra
		this.digitoUno = null;
		this.digitoDos = null;
		
		for(int valores = 0; valores < tablero.getMatriz().length; valores++ ){
			if(tablero.getMatriz()[valores][0].getEstado().equals(Casilla.SIN_USAR)){
				this.digitoUno = valores; 
				break;
			}
		}
		
		for(int valores = 0; valores < tablero.getMatriz().length; valores++ ){
			if(tablero.getMatriz()[valores][1].getEstado().equals(Casilla.SIN_USAR) && this.digitoUno != valores){
				this.digitoDos = valores; 
				break;
			}
		}
		
		System.out.println("El valor a adivinar es " + this.digitoUno + this.digitoDos + " ?");
		
	}
	
	public void descartar(Integer primerDigito, Integer segundoDigito){
		Tablero tablero = Tablero.getInstance();
		
		tablero.getMatriz()[primerDigito][0].setEstado(Casilla.DESCARTADO);
		tablero.getMatriz()[primerDigito][1].setEstado(Casilla.DESCARTADO);
		tablero.getMatriz()[segundoDigito][0].setEstado(Casilla.DESCARTADO);
		tablero.getMatriz()[segundoDigito][1].setEstado(Casilla.DESCARTADO);
		//tablero.setEstadoCasilla(primerDigito, 0, Casilla.DESCARTADO);
		
		System.out.println("descartar " + primerDigito + segundoDigito);
			
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
