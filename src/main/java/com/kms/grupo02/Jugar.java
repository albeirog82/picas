package com.kms.grupo02;


import java.util.HashMap;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class Jugar {
	
	/**
	 * Crea el ambiente para Drools, genera los hechos con los que se quiere trabajar y lanza la ejecución
	 */
	private void ejecutar ()
	{
        try 
        {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            inicializar (kSession, false);
            kSession.fireAllRules();
            kSession.dispose ();
            System.out.println("Aplicación finalizada con exito !!");
        } 
        catch (Throwable t) 
        {
            t.printStackTrace();
        }
	}
	
	// 10, 2
	private int puntaje_base(int valores, int casillas){
		int retornar = valores;
		
		for(int c=1; c<casillas; c++){
			int v = valores-c;
			retornar = retornar*v;
		}
		
		return retornar/valores; 
		
	}
	
	private void inicializar (KieSession kSession, boolean test){
		
		int dimension = 3; 
		int valores = 10; 
		
		int mi_puntaje = puntaje_base(valores, dimension);  
		
		System.out.println(mi_puntaje);
		Casilla Matriz[][];
		Matriz = new Casilla[10][3];
		
		System.out.println(Matriz[0]);
		System.out.println(Matriz[0][0]);
		
		for(int i=0;  i < Matriz.length; i++){
			for(int j=0;  j < dimension; j++){
				Matriz[i][j].setPuntaje(mi_puntaje);
				Matriz[i][j].setEstado("sin_usar");
			}
		}
				
		
		Jugada jugada = new Jugada();
		jugada.setDigitoUno(0);
		jugada.setDigitoDos(1);
		kSession.insert(jugada);
	}
	
	public static void main(String[] args) {
		System.out.println("Hola");
		Jugar juego = new Jugar();
    	juego.ejecutar ();
	}
	
}
