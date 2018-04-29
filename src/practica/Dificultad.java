package practica;

public enum Dificultad {

	FACIL(4,8,10,false), MEDIO(5,8,15,true), DIFICIL(8,10,-1,true);
	
	private int cantidadCasillas, cantidadColores, intentos;
	private boolean repetirColor;
	
	Dificultad(int cantidadCasillas, int cantidadColores, int intentos, boolean repetirColor){
		this.cantidadCasillas=cantidadCasillas;
		this.cantidadColores=cantidadColores;
		this.intentos=intentos;
		this.repetirColor=repetirColor;
	}
	
	int getCantidadCasillas(){
		return cantidadCasillas;
	}
	
	int getCantidadColores(){
		return cantidadColores;
	}
	
	int getIntentos(){
		return intentos;
	}
	
	boolean getRepetirColor(){
		return repetirColor;
	}
}
