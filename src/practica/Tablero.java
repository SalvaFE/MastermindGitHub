package practica;

import java.util.LinkedList;

public class Tablero {

	private Dificultad dificultad;
	private Combinacion combinacionOcultaPropia, combinacionOcultaContrario;
	private LinkedList<Jugada>jugada = new LinkedList<Jugada>();
	
	Tablero(Dificultad dificultad){
		this.dificultad=dificultad;
	}
	
	Combinacion getCombinacionOcultaPropia() {
		return combinacionOcultaPropia;
	}
	
	Combinacion getCombinacionOcultaContrario() {
		return combinacionOcultaContrario;
	}
	
	Jugada ultimaJugada() {
		return jugada.getLast();
	}
	
	void setCombinacionOcultaPropia(Combinacion combinacionOcultaPropia) {
		this.combinacionOcultaPropia=combinacionOcultaPropia;
	}
	
	void setCombinacionOcultaContrario(Combinacion combinacionOcultaContrario) {
		this.combinacionOcultaContrario=combinacionOcultaContrario;
	}
	
	void anhadirJugada(Jugada jugada) {
		this.jugada.addLast(jugada);
	}
	
	void dibujar() {
		int i;
		for (i = 0; i < jugada.size(); i++) {
			System.out.printf("Intento nº %d:\t",i+1);
			jugada.get(i).dibujar();
			System.out.println();
		}
	}
	
	void dibujarCompleto() {
		int i;
		for (i = 0; i < jugada.size(); i++) {
			System.out.printf("Intento nº %d:\t",i+1);
			jugada.get(i).dibujar();
			System.out.println();
		}
		System.out.println("La combinación oculta era: ");
		combinacionOcultaContrario.dibujar();
	}
	
}
