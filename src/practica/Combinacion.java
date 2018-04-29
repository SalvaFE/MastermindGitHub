package practica;

public class Combinacion implements Dibujable{

	private Casilla tamanho[];
	private Dificultad dificultad;	
	
	Combinacion(Dificultad dificultad){ //Al pasar la dificultad por parámetro, determinamos el tamaño de la combinación.s
		this.dificultad=dificultad;
		tamanho=new Casilla[dificultad.getCantidadCasillas()];
	}
	
	Casilla[] getTamanho() {
		return tamanho;
	}
	
	Dificultad getDificultad() {
		return dificultad;
	}
	
	void crearCombinacion(int posicion, int color){ //Este método está en un bucle for, así la posición es la i del bucle y el color es el número que introduce el usuario.
		tamanho[posicion]=new Casilla(color);
	}
	
	public void dibujar() { //Método que imprime la combinación.
		int i;
		for (i = 0; i < tamanho.length; i++) {
			tamanho[i].dibujar(); //Llama al dibujar de la casilla.
			System.out.print("  "); //Pone espacios entre casillas.
		}
		System.out.print("\t"); //Al dibujar la combinación completa, tabula.
	}
	
}
