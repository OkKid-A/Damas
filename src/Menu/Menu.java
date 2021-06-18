package src.Menu;

import src.Jugadores.Jugador;
import src.Tablero.Tablero;

public class Menu {

    private Tablero tablero;
    private Jugador[] jugadores;
    private int contJugadores;

    public Menu(){
        tablero = new Tablero();
        jugadores = new Jugador[5];
        contJugadores = 0;
        presentarMenu();
    }

    public void presentarMenu(){
        do {
            System.out.println("\nBienvenido a Checkers");
            System.out.println("\n1.Ingresar Jugador");
            System.out.println("\n2.Jugar una Partida");
            System.out.println("\n0.Salir");
            int opcion = ComprobarDatos.getEntero("Ingresa una opcion", false);
            switch (opcion) {
                case 1:
                    ingresarJugador();
                    break;
                case 2:
                    tablero.mostrarTablero();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    presentarMenu();
            }
        }while (5 == 5);
    }

    public void ingresarJugador(){
        jugadores[contJugadores] = new Jugador(ComprobarDatos.getTexto("Ingresa el nombre del Jugador"));
        contJugadores++;
    }
}
