package practica;

import practica.Teclado.Intervalos;

public class Menu {

	
	String crearMenu() {
		return 	"BIENVENIDO A MASTERMIND\n\n Antes de empezar debe elegir una dificultad.";
	}
	
	Partida elegirDificultad() {
		int numero;
		Partida partida=null;
		Jugador a, b, c, d, e, f;
		System.out.println("Escoja la dificultad:\n\t1.-Fácil\n\t2.-Medio\n\t3.-Difícil");
		numero=Teclado.intervalos(1, 3, Intervalos.AMBOS_INC);
		
		switch (numero) {
		case 1:
			partida=new Partida(Dificultad.FACIL, a=new Jugador(), b=new Jugador());
			break;
		case 2:
			partida=new Partida(Dificultad.MEDIO, c=new Jugador(), d=new Jugador());
			break;
		case 3:
			partida=new Partida(Dificultad.DIFICIL, e=new Jugador(), f=new Jugador());
			break;
		}
		return partida;
	}
	
	
	
}
