package practica;

public class Casilla {
	
	public static final String NEGRO = "\u001B[30m";
	public static final String ROJO = "\u001B[31m";
	public static final String VERDE = "\u001B[32m";
	public static final String AMARILLO = "\u001B[33m";
	public static final String AZUL = "\u001B[34m";
	public static final String MORADO = "\u001B[35m";
	public static final String CELESTE = "\u001B[36m";
	public static final String BLANCO = "\u001B[37m";

	String color;
	
	Casilla(String color){
		this.color=color;
	}
	
}
