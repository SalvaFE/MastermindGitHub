package practica;

public class Respuesta implements Dibujable{

	private Casilla tamanho[];	
	
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
