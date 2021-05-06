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

    	    //Remover esta variable	
    	    int dimension = 2; 
    	    
    	    List<Jugada> listaJugadas = new ArrayList<Jugada>();
    	    
    	    while(true){
        	    Jugada jugada = new Jugada();
        	    System.out.println("Obtener una jugada");
        	    jugada.crear_valores_jugada(); 
        	    if(jugada.esDuplicada(listaJugadas)){
        	    	jugada.crear_valores_jugada();
        	    }
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
		//Jugada jugada1 = new Jugada();
		//jugada1.probar(1);
		//Jugada jugada2 = new Jugada();
		//jugada2.probar(2);
	}
	
}
