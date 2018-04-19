package practica;

import practica.Teclado.Intervalos;

public class Persona extends Jugador{

	private Dificultad dificultad;
	
	Persona(Dificultad dificultad){
		this.dificultad=dificultad;
	}
	
	void anhadirColor() {
		int numero, i;
		numero=Teclado.intervalos(1, dificultad.getCantidadColores(), Intervalos.AMBOS_INC);
		for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
			
		}
	}
	
}
