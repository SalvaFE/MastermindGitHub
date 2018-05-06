package practica;

import java.util.HashMap;

import practica.Teclado.Intervalos;

public class Usuario extends Jugador{
	
	Usuario(Dificultad dificultad){
		super(dificultad);
	}
	
	Combinacion crearCombinacion() {
		int numero, i;
		Combinacion combinacion=new Combinacion(dificultad);
		System.out.println("¿Qué color desea introducir?\n\t1.- Negro\t3.- Verde\t5.- Azul\t7.- Celeste\n\t2.- Rojo\t4.- Amarillo\t6.- Morado\t8.- Blanco\n");
		for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
			System.out.printf("Casilla nº %d: \n",i+1);
			numero=Teclado.intervalos(1, dificultad.getCantidadColores(), Intervalos.AMBOS_INC)-1;
			combinacion.crearCombinacion(i, numero);
		}
		return combinacion;
	}
	
	Jugada crearRespuesta(Combinacion combinacion) {
		Respuesta respuesta= new Respuesta(combinacion.getDificultad());
		int i, j, numero;
		byte [] contador = new byte[2];
		boolean salir=false, dentro=false;
		
		for (i = 0; i < combinacion.getTamanho().length; i++) {
			for (j = 0; j <  tablero.getCombinacionOcultaPropia().getTamanho().length && !salir; j++) {
				if (combinacion.getTamanho()[j].equals(tablero.getCombinacionOcultaPropia().getTamanho()[i])) {
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
		
		System.out.print("Combinación oculta: ");
		tablero.getCombinacionOcultaPropia().dibujar();
		System.out.print("Combinación del contrario: ");
		combinacion.dibujar();
		System.out.println("\n");

		do {
			System.out.println("¿Cuántos colores coinciden en color y posición?");
			numero=Teclado.intervalos(0, dificultad.getCantidadCasillas(), Intervalos.AMBOS_INC);
			if (numero==contador[0]) {
				salir=true;
			} else {
				System.out.println("Error, no es correcto.");
			}
		} while (!salir);
		salir=false;
		do {
			System.out.println("¿Cuántos colores coinciden en color pero no en posición?");
			numero=Teclado.intervalos(0, dificultad.getCantidadCasillas(), Intervalos.AMBOS_INC);
			if (numero==contador[1]) {
				salir=true;
			} else {
				System.out.println("Error, no es correcto.");
			}
		} while (!salir);
		
		for (i = 0; i < combinacion.getTamanho().length; i++) {
			if (contador[0]>0) {
				respuesta.anhadirRespuesta(i,(byte)0);
				contador[0]--;
			} else if(contador[1]>0){
				respuesta.anhadirRespuesta(i,(byte)1);
				contador[1]--;
				} else{
					respuesta.anhadirRespuesta(i,(byte)2);
				}
		}
		return new Jugada(combinacion, respuesta);
	}

	Combinacion crearCombinacionOculta() {
		int numero, i;
		Combinacion combinacion=new Combinacion(dificultad);
		HashMap<Integer, Boolean> mapa=new HashMap<>();
		
		for (i = 0; i < dificultad.getCantidadColores(); i++) {
			mapa.put(i, false);
		}
		i=0;
		
		System.out.println("Cree la combinación oculta:\n");
		System.out.println("¿Qué color desea introducir?\n\t1.- Negro\t3.- Verde\t5.- Azul\t7.- Celeste\n\t2.- Rojo\t4.- Amarillo\t6.- Morado\t8.- Blanco\n");
		
		do {
			System.out.printf("Casilla nº %d: \n",i+1);
			numero=Teclado.intervalos(1, dificultad.getCantidadColores(), Intervalos.AMBOS_INC)-1;
			combinacion.crearCombinacion(i, numero);
			if (!mapa.get(numero)) {
				combinacion.crearCombinacion(i, numero);
				i++;
				mapa.put(numero, true);
			}
			else {
				System.out.println("No puedes repetir colores.");
			}
		} while (i<dificultad.getCantidadCasillas());
		
		tablero.setCombinacionOcultaPropia(combinacion);
		
		return combinacion;
	}
}

