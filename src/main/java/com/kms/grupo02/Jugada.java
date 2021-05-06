package com.kms.grupo02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.dmg.pmml.pmml_4_2.descr.Matrix;

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
		this.digitoUno = null;
		this.digitoDos = null; 
	}
	
	public void probar(int valor){
		Tablero tablero = Tablero.getInstance();
		System.out.println("Valor prueba antes " + tablero.getValorPrueba());
		tablero.setValorPrueba(valor);
		System.out.println("Valor prueba despues " + tablero.getValorPrueba());
	}
	
	public void crear_valores_jugada(){
		
		Tablero tablero = Tablero.getInstance();
		
		if (this.digitoUno == null && this.digitoDos == null){
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
			
			if (this.digitoUno == null && this.digitoDos == null){
				this.digitoUno = 0;
				for(int i = 0; i < tablero.getMatriz().length; i++ ){
					if(tablero.getMatriz()[i][0].getPuntaje() > tablero.getMatriz()[this.digitoUno][0].getPuntaje())  {
						this.digitoUno = i; 
					}
				}
				
				this.digitoDos = 0;
				for(int i = 0; i < tablero.getMatriz().length; i++ ){
					if(tablero.getMatriz()[i][1].getPuntaje() > tablero.getMatriz()[this.digitoDos][1].getPuntaje())  {
						this.digitoDos = i; 
					}
				}
				
			}
			
		}else{
			this.digitoDos = this.digitoDos + 1; 
			for(int i = this.digitoDos; i < tablero.getMatriz().length; i++ ){
				if(tablero.getMatriz()[i][1].getPuntaje() > tablero.getMatriz()[this.digitoDos][1].getPuntaje())  {
					this.digitoDos = i; 
				}
			}
		}
		
				
		
		
		System.out.println("Matriz:");
		
		tablero.imprimirMatriz();
		
		System.out.println("El valor a adivinar es " + this.digitoUno + this.digitoDos + " ?");
		
	}
	
	public void actualizarEstado(Integer digito, Integer casilla, String estado){
		
		Tablero tablero = Tablero.getInstance();
		
		tablero.getMatriz()[digito][casilla].setEstado(estado);
			
	}
	
	public void actualizarPuntaje(Integer digito, Integer casilla, Integer puntaje){
		
		Tablero tablero = Tablero.getInstance();
		
		if (puntaje == 0) {
			tablero.getMatriz()[digito][casilla].setPuntaje(puntaje);
		}else{
			tablero.getMatriz()[digito][casilla].setPuntaje(tablero.getMatriz()[digito][casilla].getPuntaje() + puntaje);
		}
		
			
	}
	
	public boolean esDuplicada(List<Jugada> listaJugadas){
		for (int i = 0; i < listaJugadas.size(); i++) {
		    Jugada jugada = listaJugadas.get(i);
		    if(jugada.digitoUno == this.digitoUno && jugada.digitoDos == this.digitoDos ){
		    	System.out.println("Se ha encontrado una jugada duplicada");
		    	return true;
		    }
		}
		return false; 
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
