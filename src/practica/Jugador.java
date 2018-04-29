package practica;

public abstract class Jugador {
	
	protected Tablero tablero;
	protected Dificultad dificultad;
	
	Jugador(Dificultad dificultad){
		this.dificultad=dificultad;
		tablero=new Tablero(dificultad);
	}
	
	abstract Combinacion crearCombinacion();
	
	abstract Combinacion crearCombinacionOculta();
	
	abstract Respuesta crearRespuesta(Combinacion combinacion);
	
	abstract Jugada crearJugada(Combinacion combinacion);
	
	
}
