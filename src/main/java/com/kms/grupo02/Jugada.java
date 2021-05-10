package com.kms.grupo02;

public class Jugada {
	
	private Integer digitoUno;
	
	private Integer digitoDos; 
	
	private Integer digitoTres; 
	
	private Integer digitoCuatro;

	private Integer picas; 
	
	private Integer fijas;
	
	private Boolean perdioFijas;
	
	private Boolean aumentoFijas;
	
	public Jugada() {
		this.picas = 0; 
		this.fijas = 0;
		this.digitoUno = null;
		this.digitoDos = null;
		this.digitoTres = null; 
		this.digitoCuatro = null; 
		this.perdioFijas = false; 
		this.aumentoFijas = false; 
	}
	
	public void crear_valores_jugada(){
		
		Tablero tablero = Tablero.getInstance();
		
		
		if (this.digitoUno == null && this.digitoDos == null && this.digitoTres == null && this.digitoCuatro == null){
			for(int valores = 0; valores < tablero.getMatriz().length; valores++ ){
				if(tablero.getMatriz()[valores][0].getEstado().equals(Casilla.SIN_USAR)){
					this.digitoUno = valores; 
					System.out.println("digitoUno por SIN USAR");
					break;
				}
			}
			
			for(int valores = 0; valores < tablero.getMatriz().length; valores++ ){
				if(tablero.getMatriz()[valores][1].getEstado().equals(Casilla.SIN_USAR) && this.digitoUno != valores){
					this.digitoDos = valores; 
					System.out.println("digitoDos por SIN USAR");
					break;
				}
			}
			
			for(int valores = 0; valores < tablero.getMatriz().length; valores++ ){
				if(tablero.getMatriz()[valores][2].getEstado().equals(Casilla.SIN_USAR) && this.digitoUno != valores 
						&& this.digitoDos != valores){
					this.digitoTres = valores; 
					System.out.println("digitoTres por SIN USAR");
					break;
				}
			}
			
			for(int valores = 0; valores < tablero.getMatriz().length; valores++ ){
				if(tablero.getMatriz()[valores][3].getEstado().equals(Casilla.SIN_USAR) && this.digitoUno != valores 
						&& this.digitoDos != valores && this.digitoTres != valores){
					this.digitoCuatro = valores; 
					System.out.println("digitoCuatro por SIN USAR");
					break;
				}
			}
			
			if(this.digitoUno == null){
				this.digitoUno = 0;
				for(int i = 0; i < tablero.getMatriz().length; i++ ){
					if(tablero.getMatriz()[i][0].getPuntaje() > tablero.getMatriz()[this.digitoUno][0].getPuntaje())  {
						this.digitoUno = i; 
						System.out.println("digitoUno por Mayor");
					}
				}
			}

			if(this.digitoDos == null){
				this.digitoDos = 0;
				System.out.println("Calcular segundo digito");
				for(int i = 0; i < tablero.getMatriz().length; i++ ){
					if(tablero.getMatriz()[i][1].getPuntaje() > tablero.getMatriz()[this.digitoDos][1].getPuntaje())  {
						if (this.digitoUno != i){
							this.digitoDos = i; 
							System.out.println("digitoDos por Mayor");
						}
					}
				}
			}
			
			if(this.digitoTres == null){
				System.out.println("Analizar digito 3 por mayor");
				this.digitoTres = 0;
				for(int i = 0; i < tablero.getMatriz().length; i++ ){
					System.out.println(" Puntaje iterador " +  tablero.getMatriz()[i][2].getPuntaje() + 
							" Puntaje digito actual " + tablero.getMatriz()[this.digitoTres][2].getPuntaje());
					if(tablero.getMatriz()[i][2].getPuntaje() > tablero.getMatriz()[this.digitoTres][2].getPuntaje())  {
						this.digitoTres = i; 
						System.out.println("digitoTres por Mayor");
					}
				}								
			}
			
			if(this.digitoCuatro == null){
				if(this.digitoTres == 0){
					this.digitoCuatro = 1;
				}else{
					this.digitoCuatro = 0;
				}
				for(int i = 0; i < tablero.getMatriz().length; i++ ){
					if(tablero.getMatriz()[i][3].getPuntaje() > tablero.getMatriz()[this.digitoCuatro][3].getPuntaje()){
						this.digitoCuatro = i; 
						System.out.println("digitoCuatro por Mayor");
					}
				}								
			}
			
		}else{
			
			Integer cerosEnCasillaCuatro = 0;
			for(int i=0; i < tablero.getMatriz().length; i++){
				if(tablero.getMatriz()[i][3].getPuntaje()==0){
					cerosEnCasillaCuatro = cerosEnCasillaCuatro + 1;
				}
			}
			System.out.println("Ceros encontrados en casilla 4: " + cerosEnCasillaCuatro);
			if(cerosEnCasillaCuatro < 9){
				this.digitoCuatro = this.digitoCuatro + 1; 
				for(int i = this.digitoCuatro; i < tablero.getMatriz().length; i++ ){
					if(tablero.getMatriz()[i][3].getPuntaje() > tablero.getMatriz()[this.digitoCuatro][3].getPuntaje())  {
						//Verificar que no sea igual a otro de los digitos
						if(i != this.digitoUno && i != this.digitoDos && i != this.digitoTres ){
							System.out.println("digitoCuatro por iteracion");
							this.digitoCuatro = i;
						}
					}
				}
			}else{
				System.out.println("Digito 3 actual " + this.digitoTres);
				Integer cerosEnCasillaTres = 0;
				for(int i=0; i < tablero.getMatriz().length; i++){
					if(tablero.getMatriz()[i][2].getPuntaje()==0){
						cerosEnCasillaTres = cerosEnCasillaTres + 1;
					}
				}
				if(cerosEnCasillaTres < 9){
					this.digitoTres = this.digitoTres + 1; 
					for(int i = this.digitoTres; i < tablero.getMatriz().length; i++ ){
						if(tablero.getMatriz()[i][2].getPuntaje() > tablero.getMatriz()[this.digitoTres][2].getPuntaje())  {
							//Verificar que no sea igual a otro de los digitos
							if(i != this.digitoUno && i != this.digitoDos ){
								System.out.println("digitoTres por iteracion");
								this.digitoTres = i;
							}
						}
					}					
				}else{
					
					//Recalcular casilla 1
					this.digitoUno = 0;
					for(int i = 0; i < tablero.getMatriz().length; i++ ){
						if(tablero.getMatriz()[i][0].getPuntaje() > tablero.getMatriz()[this.digitoUno][0].getPuntaje())  {
							this.digitoUno = i; 
							System.out.println("digitoUno por Mayor recalculado");
						}
					}
					
					//calcular digito dos 
					System.out.println("Ingresar a rotacion digito dos. Digito dos actual " + (this.digitoDos + 1));
					this.digitoDos = this.digitoDos + 1; 
					for(int i = this.digitoDos; i < tablero.getMatriz().length; i++ ){
						System.out.println("valor " + i);
						System.out.println(tablero.getMatriz()[i][1].getPuntaje());
						System.out.println(tablero.getMatriz()[this.digitoDos][1].getPuntaje());
						if(tablero.getMatriz()[i][1].getPuntaje() > tablero.getMatriz()[this.digitoDos][1].getPuntaje())  {
							//Verificar que no sea igual a otro de los digitos
							if(i != this.digitoUno ){
								System.out.println("digitoDos por iteracion");
								this.digitoDos = i;
								if(this.esDuplicada()){
									System.out.println("se genera una jugada duplicada desde el digito dos");
								}
							}
						}
					}
					System.out.println("Digito dos actual " + this.digitoDos);	
					
				}

			}
			
			
		}
		
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
	
	public boolean esDuplicada(){
		
		Tablero tablero = Tablero.getInstance();
		
		for (int i = 0; i < tablero.getListaJugadas().size(); i++) {
		    Jugada jugada = tablero.getListaJugadas().get(i);
		    if(jugada.digitoUno == this.digitoUno && jugada.digitoDos == this.digitoDos 
		    		&& jugada.digitoTres == this.digitoTres && jugada.digitoCuatro == this.digitoCuatro ){
		    	System.out.println("Se ha encontrado una jugada duplicada " +  this.digitoUno + this.digitoDos + 
						this.digitoTres + this.digitoCuatro );
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
		this.digitoTres = null; 
		this.digitoCuatro = null; 
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

	public void verJugada() {
		
		Tablero tablero = Tablero.getInstance();
		
		System.out.println("Matriz:");
		
		tablero.imprimirMatriz();
		
		System.out.println("El valor a adivinar es " + this.digitoUno + this.digitoDos + 
				this.digitoTres + this.digitoCuatro + " ?");

		
	}
	
	public Integer consultarFijaPerdida(){
		Tablero tablero = Tablero.getInstance();
		Integer fijaPerdida = tablero.getListaJugadas().get(tablero.getListaJugadas().size()-1).getDigitoCuatro();
		System.out.println("Fija que se perdio " + fijaPerdida);
		return fijaPerdida;
	}
	
	public Integer consultarFijaGanada(){
		Tablero tablero = Tablero.getInstance();
		//Integer fijaGanada = tablero.getListaJugadas().get(tablero.getListaJugadas().size()-1).getDigitoTres();
		Integer fijaGanada = this.digitoTres;
		System.out.println("Fija que se gano " + fijaGanada);
		return fijaGanada;
	}
	
	public void descartarVertical(Integer columna, Integer valorExcluido){
		Tablero tablero = Tablero.getInstance();
		for(int i=0; i < tablero.getMatriz().length; i++){
			if(valorExcluido != i){
		        this.actualizarEstado(i, columna, Casilla.DESCARTADO);
		        this.actualizarPuntaje(i, columna, 0);  
			}
		}
	}
	
	public void descartarHorizontal(Integer valor, Integer casillaActual){
		Tablero tablero = Tablero.getInstance();
		for(int i=0; i < tablero.getDimension(); i++){
			if(casillaActual != i){
		        this.actualizarEstado(valor, i, Casilla.DESCARTADO);
		        this.actualizarPuntaje(valor, i, 0);
			}
		}
	}
	

	public Boolean getPerdioFijas() {
		return perdioFijas;
	}

	public void setPerdioFijas(Boolean perdioFijas) {
		this.perdioFijas = perdioFijas;
	}

	public void calcularPerdidaFijas() {
		Tablero tablero = Tablero.getInstance();
		if(tablero.getListaJugadas().size() >= 1){
			Jugada jugadaPasada = tablero.getListaJugadas().get(tablero.getListaJugadas().size()-1);
			if(jugadaPasada.getFijas() > this.fijas){
				System.out.println("se perdieron fijas en jugada actual");
				this.perdioFijas = true; 
			}		

		}
	}
	
	public void calcularAumentoFijas(){
		Tablero tablero = Tablero.getInstance();
		Boolean flag = true;
		for(int valores = 0; valores < tablero.getMatriz().length; valores++ ){
			if(tablero.getMatriz()[valores][0].getEstado().equals(Casilla.SIN_USAR)
					|| tablero.getMatriz()[valores][1].getEstado().equals(Casilla.SIN_USAR)
					|| tablero.getMatriz()[valores][2].getEstado().equals(Casilla.SIN_USAR)
					|| tablero.getMatriz()[valores][3].getEstado().equals(Casilla.SIN_USAR)){
				flag = false;
				break;
			}
		}
		
		if(flag){
			System.out.println("Se cumple condicion para buscar aumento de fijas");
			if(tablero.getListaJugadas().size() >= 1){
				Jugada jugadaPasada = tablero.getListaJugadas().get(tablero.getListaJugadas().size()-1);
				if(this.fijas > jugadaPasada.getFijas()){
					System.out.println("se ganaron fijas en jugada actual");
					this.aumentoFijas = true; 
				}		

			}
		}
		
	}
	
	public void descartarFijasJugadaAnterior(Integer valorFijado){
		Tablero tablero = Tablero.getInstance();
		for (int i = 0; i < tablero.getListaJugadas().size(); i++) {
		    Jugada jugada = tablero.getListaJugadas().get(i);
		    if(jugada.digitoTres == valorFijado ){
		    	System.out.println("Se debe descartar en casilla 2 el valor " + jugada.digitoDos);
		        this.actualizarEstado(jugada.digitoDos, 1, Casilla.DESCARTADO);
		        this.actualizarPuntaje(jugada.digitoDos, 1, 0);  
		    }
		}
		
		for (int i = 0; i < tablero.getListaJugadas().size(); i++) {
		    Jugada jugada = tablero.getListaJugadas().get(i);
		    if(jugada.digitoTres == valorFijado ){
		    	System.out.println("Se debe descartar en casilla 1 el valor " + jugada.digitoUno);
		        this.actualizarEstado(jugada.digitoUno, 0, Casilla.DESCARTADO);
		        this.actualizarPuntaje(jugada.digitoUno, 0, 0);  
		    }
		}
		
		//Identificar fija de ultima casilla 
		Integer cerosEnCasillaCuatro = 0;
		for(int i=0; i < tablero.getMatriz().length; i++){
			if(tablero.getMatriz()[i][3].getPuntaje()==0){
				cerosEnCasillaCuatro = cerosEnCasillaCuatro + 1;
			}
		}
		if(cerosEnCasillaCuatro==9){
			
			for (int i = 0; i < tablero.getListaJugadas().size(); i++) {
			    Jugada jugada = tablero.getListaJugadas().get(i);
			    if(jugada.digitoCuatro == this.digitoCuatro){
			    	System.out.println("Se debe descartar en casilla 2 el valor " + jugada.digitoDos);
			        this.actualizarEstado(jugada.digitoDos, 1, Casilla.DESCARTADO);
			        this.actualizarPuntaje(jugada.digitoDos, 1, 0);  
			    }
			}
			
			for (int i = 0; i < tablero.getListaJugadas().size(); i++) {
			    Jugada jugada = tablero.getListaJugadas().get(i);
			    if(jugada.digitoCuatro == this.digitoCuatro){
			    	System.out.println("Se debe descartar en casilla 1 el valor " + jugada.digitoUno);
			        this.actualizarEstado(jugada.digitoUno, 0, Casilla.DESCARTADO);
			        this.actualizarPuntaje(jugada.digitoUno, 0, 0);  
			    }
			}
			
			
		}
		
	}
	
	
	
	public void descartarResto(){
		
		System.out.println("descartar resto");
		
		Boolean excluir = false; 
		
		Tablero tablero = Tablero.getInstance();
		
		for (int valores = 0; valores < tablero.getMatriz().length; valores++ ){
			
			excluir = (this.digitoUno == valores) || (this.digitoDos == valores) || (this.digitoTres == valores) || 
					(this.digitoCuatro == valores); 
			System.out.println("boolean excluir " + excluir );
			if(!excluir){
				System.out.println("descartando.....  " + valores );
				descartarHorizontal(valores, 0);
		        this.actualizarEstado(valores, 0, Casilla.DESCARTADO);
		        this.actualizarPuntaje(valores, 0, 0);
			}
		}
		
		
		
	}
	
	public Boolean getAumentoFijas() {
		return aumentoFijas;
	}

	public void setAumentoFijas(Boolean aumentoFijas) {
		this.aumentoFijas = aumentoFijas;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " digitoUno " + this.digitoUno + " digitoDos " + this.digitoDos + " digitoTres " + this.digitoTres +
				" digitoCuatro " + this.digitoCuatro + " picas " + this.fijas + " fijas " + this.fijas +
				" perdioFijas " + this.perdioFijas + " aumentoFijas " + this.aumentoFijas; 
	}
	


}
