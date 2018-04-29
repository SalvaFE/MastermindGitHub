package practica;

public class Casilla implements Dibujable{
	
	static final String FONDO_NEGRO = "\u001B[48;5;0m";
	static final String FONDO_BURDEOS = "\u001B[48;5;1m";
	static final String FONDO_VERDE = "\u001B[48;5;2m";
	static final String FONDO_AMARILLO = "\u001B[48;5;11m";
	static final String FONDO_AZUL = "\u001B[48;5;4m";
	static final String FONDO_MORADO = "\u001B[48;5;5m";
	static final String FONDO_CELESTE = "\u001B[48;5;6m";
	static final String FONDO_BLANCO = "\u001B[48;5;7m";
	static final String FONDO_GRIS = "\u001B[48;5;8m";
	static final String FONDO_ROJO = "\u001B[48;5;9m";
	static final String RESET = "\u001B[0m";
	
	static String[] colores={"\u001B[48;5;0m", "\u001B[48;5;1m", "\u001B[48;5;2m", "\u001B[48;5;11m", "\u001B[48;5;4m", "\u001B[48;5;5m", "\u001B[48;5;6m", "\u001B[48;5;7m", "\u001B[48;5;8m", "\u001B[48;5;9m"};
	static String[] coloresRespuesta = {"\u001B[48;5;9m", "\u001B[48;5;7m", "\u001B[48;5;0m"};
	private String color;
	
	Casilla(int posicion){ //Constructor para las casillas de la clase combinación
		color=colores[posicion];
	}
	
	Casilla(byte posicionRespuesta){ //Constructor para las casillas de la clase respuesta.
		color=coloresRespuesta[posicionRespuesta];
	}
	
	String getColor() {
		return color;
	}
	
	public void dibujar() { //Método que imprime la casilla.
		System.out.printf("%s  %s", color, Casilla.RESET);
	}
	
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Casilla
				&& color.equals(((Casilla)obj).color)){
			resultado=true;
		}		
		return resultado;		
	}
	
}
