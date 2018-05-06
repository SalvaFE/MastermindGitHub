package practica;

public class Partida {
	
	private Dificultad dificultad;
	private Jugador jugador1;
	private Jugador jugador2;

	Partida(Dificultad dificultad, Jugador jugador1, Jugador jugador2){
		this.dificultad=dificultad;
		this.jugador1=jugador1;
		this.jugador2=jugador2;
	}
	
	void configurarPartida() {
		int i=0;
		boolean salir=false;
		
		if (dificultad==Dificultad.FACIL) {
			jugador1.getTablero().setCombinacionOcultaContrario(jugador2.crearCombinacionOculta());
		} else {
			jugador2.getTablero().setCombinacionOcultaContrario(jugador1.crearCombinacionOculta());
			jugador1.getTablero().setCombinacionOcultaContrario(jugador2.crearCombinacionOculta());
		}
		
		if (dificultad==Dificultad.FACIL) {
			do {
				jugador1.getTablero().anhadirJugada(jugador2.crearRespuesta(jugador1.crearCombinacion()));
				if (comprobarGanador(jugador1)==1) {
					System.out.println("Has ganado.");
					jugador1.getTablero().dibujar();
					salir=true;
				}else {
					jugador1.getTablero().dibujarCompleto();
					i++;
				}
			} while (i<dificultad.getIntentos() || salir);
			if (comprobarGanador(jugador1)==0) {
				System.out.println("Has perdido.");
			} 
		} else if(dificultad==Dificultad.MEDIO) {
			do {
				jugador1.getTablero().anhadirJugada(jugador2.crearRespuesta(jugador1.crearCombinacion()));
				jugador2.getTablero().anhadirJugada(jugador1.crearRespuesta(jugador2.crearCombinacion()));
				if (comprobarGanador(jugador1, jugador2, i+1)==1) {
					System.out.println("El jugador 1 ha ganado.");
					jugador1.getTablero().dibujar();
					salir=true;
				}else if(comprobarGanador(jugador1, jugador2, i+1)==2){
					System.out.println("El jugador 2 ha ganado.");
					jugador2.getTablero().dibujar();
					salir=true;
				}else {
					jugador1.getTablero().dibujar();
					jugador2.getTablero().dibujar();
					i++;
				}
			} while (i<dificultad.getIntentos() && !salir);
			if (comprobarGanador(jugador1, jugador2, dificultad.getIntentos())==0) {
				System.out.println("Ha habido empate.");
			} 
		}else {
			do {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				jugador1.getTablero().anhadirJugada(jugador2.crearRespuesta(jugador1.crearCombinacion()));
				jugador2.getTablero().anhadirJugada(jugador1.crearRespuesta(jugador2.crearCombinacion()));
				if (comprobarGanador(jugador1, jugador2, dificultad.getIntentos())==1) {
					System.out.println("El jugador 1 ha ganado.");
					jugador1.getTablero().dibujar();
					salir=true;
				}else if(comprobarGanador(jugador1, jugador2, dificultad.getIntentos())==2){
					System.out.println("El jugador 2 ha ganado.");
					jugador2.getTablero().dibujar();
					salir=true;
				}else {
					if (i%5==0) {
						jugador1.getTablero().dibujar();
						jugador2.getTablero().dibujar();
					}
					i++;
				}
			} while (!salir);
		}
		
	}
	
	int comprobarGanador(Jugador jugador) {
		byte contador[]=new byte[1];
		int i, gana=0;
		
		for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
			if (jugador.getTablero().ultimaJugada().getRespuesta().getTamanho()[i].getColor().equals("\u001B[48;5;9m")) {
				contador[0]++;
			} 
		}
		
		if (dificultad.getCantidadCasillas()==contador[0]) {
			gana=1;//Si gana es 1 es que ha ganado, si es 0 es que no.
		}
		return gana;
	}
	
	int comprobarGanador(Jugador jugador1, Jugador jugador2, int turno) {
		byte contador[][]=new byte[2][2];
		int i, gana=0;
		
		for (i = 0; i < dificultad.getCantidadCasillas(); i++) {
			if (jugador1.getTablero().ultimaJugada().getRespuesta().getTamanho()[i].getColor().equals("\u001B[48;5;9m")) {
				contador[0][0]++;
			} else if(jugador1.getTablero().ultimaJugada().getRespuesta().getTamanho()[i].getColor().equals("\u001B[48;5;7m")){
				contador[0][1]++;
			}
			if (jugador2.getTablero().ultimaJugada().getRespuesta().getTamanho()[i].getColor().equals("\u001B[48;5;9m")) {
				contador[1][0]++;
			} else if(jugador2.getTablero().ultimaJugada().getRespuesta().getTamanho()[i].getColor().equals("\u001B[48;5;7m")){
				contador[1][1]++;
			}
		}
		
		if (dificultad==Dificultad.MEDIO) {
			if (dificultad.getCantidadCasillas()==contador[0][0]) {
				gana=1;
			} else if(dificultad.getCantidadCasillas()==contador[1][0]) {
				gana=2;
			} else if(turno==dificultad.getIntentos()){
				if (contador[0][0]>contador[1][0]) {
					gana=1;
				} else if(contador[1][0]>contador[0][0]){
					gana=2;
				}else if(contador[1][0]==contador[0][0]) {
					if (contador[0][1]>contador[1][1]) {
						gana=1;
					} else if(contador[1][1]>contador[0][1]){
						gana=2;
					}else {
						gana=0;
					}
				}
			}
		} else if(dificultad==Dificultad.DIFICIL){
			if (dificultad.getCantidadCasillas()==contador[0][0]) {
				gana=1;
			} else if(dificultad.getCantidadCasillas()==contador[1][0]) {
				gana=2;
			}
		}
		return gana;
	}
}
