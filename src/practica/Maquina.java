package practica;

import java.util.HashMap;
import java.util.Random;

//import java.util.Random;

public class Maquina extends Jugador{

	Maquina(Dificultad dificultad) {
		super(dificultad);
	}

	
	Combinacion crearCombinacion() {
		Combinacion combinacion=new Combinacion(dificultad);
		Random rnd=new Random();
		HashMap<Integer, Boolean> mapa=new HashMap<>();
		int i, color;
		
		for (i = 0; i < dificultad.getCantidadColores(); i++) {
			mapa.put(i, false);
		}
		i=0;
		
		do {
			color=rnd.nextInt(dificultad.getCantidadColores());
			if (dificultad==Dificultad.DIFICIL) {
				combinacion.crearCombinacion(i, color);
				i++;
			} else {
				if (!mapa.get(color)) {
					combinacion.crearCombinacion(i, color);
					i++;
					mapa.put(color, true);
				}
			}
		} while (i<dificultad.getCantidadCasillas());
		
		return combinacion;
	}
	
	Respuesta crearRespuesta(Combinacion combinacion) {
		Respuesta resp= new Respuesta(combinacion.getDificultad());
		int i, j;
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

	
	Jugada crearJugada(Combinacion combinacion) {
		return null;
	}

	Combinacion crearCombinacionOculta() {
		Combinacion combinacion=new Combinacion(dificultad);
		
		return combinacion;
	}
	
}
