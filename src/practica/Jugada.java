package practica;

public class Jugada implements Dibujable{

	Combinacion combinacion;
	Respuesta respuesta;
	
	Jugada(Combinacion combinacion, Respuesta respuesta){
		this.combinacion=combinacion;
		this.respuesta=respuesta;
	}
	
	public void dibujar(){
		combinacion.dibujar();
		respuesta.dibujar();
	}
	
}
