package com.kms.grupo02;

public class Tablero {
	
	public Casilla[][] matriz;
    Integer valores; 
    Integer dimension;
	Integer valorPrueba;
    
	private static Tablero instance = new Tablero();
	
	private Tablero(){
		int valores = 10; 
		int dimension = 2;
		this.valorPrueba = 0;
		
		System.out.println("Iniciar matriz");
 	    this.matriz = crear_matriz_iniciada(valores, dimension);
		System.out.println("Matriz creada");
	}
	
	public Integer getValorPrueba() {
		return valorPrueba;
	}

	public void setValorPrueba(Integer valorPrueba) {
		this.valorPrueba = valorPrueba;
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
		
		System.out.println("Crear y poblar nueva matriz");
		
		Casilla[][] nuevaMatriz = new Casilla[valores][dimension];
		
		for(int i=0;  i < nuevaMatriz.length; i++){
			for(int j=0;  j < dimension; j++){
				nuevaMatriz[i][j] = new Casilla();
				nuevaMatriz[i][j].setPuntaje(mi_puntaje);
				nuevaMatriz[i][j].setEstado("sin_usar");
			}
		}
		
		return nuevaMatriz; 
	}
	
	public static Tablero getInstance(){
		return instance;
	}

	public Casilla[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Casilla[][] matriz) {
		this.matriz = matriz;
	}

	public Integer getValores() {
		return valores;
	}

	public void setValores(Integer valores) {
		this.valores = valores;
	}

	public Integer getDimension() {
		return dimension;
	}

	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}
	
	public void setEstadoCasilla(int i, int j, String estado){
		this.matriz[i][j].setEstado(estado);
		System.out.println("Se escribio en la matriz");
	}
	
	public void imprimirMatriz(){
		for(int i=0; i<this.matriz.length; i++){
			System.out.println(i + "|" + this.matriz[i][0].getPuntaje() + "|" + this.matriz[i][1].getPuntaje());
		}
	}
	
	
	
}
