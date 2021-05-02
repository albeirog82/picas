package com.kms.grupo02;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;




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
	
	private Casilla[][] crear_matriz_iniciada(int valores, int dimension){
		
		int mi_puntaje = puntaje_base(valores, dimension);  
		
		System.out.println(mi_puntaje);
		
		Casilla[][] matriz = new Casilla[valores][dimension];
		
		for(int i=0;  i < matriz.length; i++){
			for(int j=0;  j < dimension; j++){
				matriz[i][j] = new Casilla();
				matriz[i][j].setPuntaje(mi_puntaje);
				matriz[i][j].setEstado("sin_usar");
			}
		}
		
		return matriz; 
	}
	
	private void inicializar (KieSession kSession, boolean test){
		
		
		
		Jugada jugada = new Jugada();
		jugada.setDigitoUno(0);
		jugada.setDigitoDos(1);
		kSession.insert(jugada);
	}
	
	private void ejecutar_stateless ()
	{
        try 
        {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
    	    StatelessKieSession kSession = kContainer.newStatelessKieSession();	
        	//KieSession kSession = kContainer.newKieSession("ksession-rules");

    	    int valores = 10; 
    	    int dimension = 2;
    	    
    	    System.out.println("Iniciar matriz");
    	    Casilla[][] matriz = crear_matriz_iniciada(valores, dimension);
    	    System.out.println("Matriz creada");
    	    
    	    List<Jugada> listaJugadas = new ArrayList<Jugada>();
    	    
    	    while(true){
        	    Jugada jugada = new Jugada();
        	    jugada.crear_valores_jugada();
        	    String picas = JOptionPane.showInputDialog("Cuantas picas identifica:");
            	String fijas = JOptionPane.showInputDialog("Cuantas fijas identifica:");
            	if(Integer.parseInt(fijas) == dimension){
            		System.out.println("Se adivinó el numero, el juego termino");
            		break; 
            	}else{
            		//Poner las picas y las fijas que el usuario dijo y evaluar las reglas de acuerdo con lo dicho
            		jugada.setPicas(Integer.parseInt(picas));
            		jugada.setFijas(Integer.parseInt(fijas));
            		kSession.execute(jugada);
            		//Agregar la jugada completada a la lista de jugadas
            		listaJugadas.add(jugada);
            	}
    	    }
    	        	        	    
        } 
        catch (Throwable t) 
        {
            t.printStackTrace();
        }
	} 
	
	public static void main(String[] args) {
		System.out.println("Hola");
		Jugar juego = new Jugar();
    	juego.ejecutar_stateless();
	}
	
}
