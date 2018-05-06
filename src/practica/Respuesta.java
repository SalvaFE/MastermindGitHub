package practica;

/** 
 * Esta clase crea un array de casillas con el constructor de tipo byte.
 * @author Salvador Foncubierta
 * @version 2.0
 * @since 1.0
 */

public class Respuesta implements Dibujable{

	private Casilla tamanho[];	
	
	/**
	 * Construye un nuevo objeto Respuesta.
	 * @param dificultad  La dificultad de la partida.
	 */
	
	Respuesta(Dificultad dificultad){
		tamanho=new Casilla[(byte)dificultad.getCantidadCasillas()];
	}
	
	Casilla[] getTamanho() {
		return tamanho;
	}
	
	void anhadirRespuesta(int posicion, byte colorRespuesta){
		tamanho[posicion]=new Casilla(colorRespuesta);
	}
	
	public void dibujar() {
		int i;
		for (i = 0; i < tamanho.length; i++) {
			tamanho[i].dibujar();
			System.out.print("  ");
		}
		System.out.println();
	}
	
}
