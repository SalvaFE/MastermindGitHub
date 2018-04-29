package practica;

import java.util.LinkedList;

public class Tablero {

	private Dificultad dificultad;
	private Combinacion combinacionOculta;
	private LinkedList<Jugada>jugada = new LinkedList<Jugada>();
	
	Tablero(Dificultad dificultad){
		this.dificultad=dificultad;
		combinacionOculta=new Combinacion(dificultad);
	}
	
	Combinacion getCombinacionOculta() {
		return combinacionOculta;
	}
	
	void anhadirJugada(Jugada jugada) {
		this.jugada.addLast(jugada);
	}
	
}
