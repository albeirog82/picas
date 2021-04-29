package com.kms.grupo02;


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
	
	private void inicializar (KieSession kSession, boolean test){
		
		Secret secreto = new Secret();
		secreto.setDigitoUno(1);
		secreto.setDigitoDos(2);
		secreto.setDigitoTres(3);
		secreto.setDigitoCuatro(4);
		kSession.insert(secreto);
	}
	
	public static void main(String[] args) {
		System.out.println("Hola");
		Jugar juego = new Jugar();
    	juego.ejecutar ();
	}
	
}
