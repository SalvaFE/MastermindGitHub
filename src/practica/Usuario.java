package practica;

import practica.Teclado.Intervalos;

public class Usuario extends Jugador{
	
	Usuario(Dificultad dificultad){
		super(dificultad);
	}
	
	Combinacion crearCombinacion() {
		int numero, i;
		Combinacion combinacion=new Combinacion(dificultad);
		for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
			System.out.println("¿Qué color desea introducir?");
			System.out.println("\t1.- Negro");
			System.out.println("\t2.- Rojo");
			System.out.println("\t3.- Verde");
			System.out.println("\t4.- Amarillo");
			System.out.println("\t5.- Azul");
			System.out.println("\t6.- Morado");
			System.out.println("\t7.- Celeste");
			System.out.println("\t8.- Blanco");
			numero=Teclado.intervalos(1, dificultad.getCantidadColores(), Intervalos.AMBOS_INC);
			combinacion.crearCombinacion(i, numero-1);
		}
		return combinacion;
	}
	
	Jugada crearJugada(Combinacion combinacion) {
//		int numero, i;
		Respuesta respuesta=new Respuesta(dificultad);
		System.out.println("¿Cuántos colores en las casillas correctas hay?");
//		numero=Teclado.intervalos(0, dificultad.getCantidadCasillas(), Intervalos.AMBOS_INC);
		return new Jugada(combinacion, respuesta);
	}
	
	Respuesta crearRespuesta(Combinacion combinacion) {
		Respuesta resp= new Respuesta(combinacion.getDificultad());
		int i, j, numero;
		byte [] contador = new byte[3];
		boolean salir=false, dentro=false;
		
		for (i = 0; i < combinacion.getTamanho().length; i++) {
			for (j = 0; j <  tablero.getCombinacionOculta().getTamanho().length && !salir; j++) {
				if (combinacion.getTamanho()[i].equals(tablero.getCombinacionOculta().getTamanho()[j])) {
					if (i==j) {
						contador[0]++;
						salir=true;
						if (dentro) {
							contador[1]--;
						}
					} else if(!dentro){
						contador[1]++;
						dentro=true;
					}
				}
			}
			dentro=false;
			salir=false;
		}
		salir=false;

		do {
			System.out.println("¿Cuántos colores coinciden en color y posición?");
			numero=Teclado.intervalos(1, dificultad.getCantidadCasillas(), Intervalos.AMBOS_INC);
			if (numero==contador[0]) {
				salir=true;
			} else {
				System.out.println("Error, no es correcto.");
			}
		} while (salir);
		
		do {
			System.out.println("¿Cuántos colores coinciden en color pero no en posición?");
			numero=Teclado.intervalos(1, dificultad.getCantidadCasillas(), Intervalos.AMBOS_INC);
			if (numero==contador[1]) {
				salir=true;
			} else {
				System.out.println("Error, no es correcto.");
			}
		} while (salir);
		
		for (i = 0; i < combinacion.getTamanho().length; i++) {
			if (contador[0]>0) {
				resp.anhadirRespuesta(i,(byte)0);
				contador[0]--;
			} else if(contador[1]>0){
				resp.anhadirRespuesta(i,(byte)1);
				contador[1]--;
				} else{
					resp.anhadirRespuesta(i,(byte)2);
				}
		}
		return resp;
	}

	Combinacion crearCombinacionOculta() {
		Combinacion combinacion=new Combinacion(dificultad);
		
		return combinacion;
	}
}

