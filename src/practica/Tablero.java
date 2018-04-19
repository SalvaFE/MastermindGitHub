package practica;

import java.util.LinkedList;

public class Tablero {

	private Dificultad dificultad;
	private Combinacion combinacionPropia;
	private LinkedList<Combinacion>combinaciones = new LinkedList<Combinacion>();
	
	Tablero(Dificultad dificultad){
		this.dificultad=dificultad;
		combinacionPropia=0;
	}
	
	
	
}
