package src.Menu;

import src.Jugadores.*;
import src.Tablero.*;

public class Menu {

    private TablaJugadores jugadores;
    private Arbitro arbitro;

    public Menu(){
        jugadores = new TablaJugadores();
        arbitro = new Arbitro(jugadores);
        presentarMenu();
    }

    public void presentarMenu(){
        do {
            System.out.println("\nBienvenido a Checkers");
            System.out.println("\n1.Ingresar Jugador");
            System.out.println("2.Jugar una Partida");
            System.out.println("3.Mostrar Puntuaciones");
            System.out.println("0.Salir");
            int opcion = ComprobarDatos.getEntero("Ingresa una opcion", false);
            switch (opcion) {
                case 1:
                    jugadores.agregarJugador();
                    break;
                case 2:
                    arbitro.iniciarPartida();
                    break;
                case 3:
                    listarPunteos();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    presentarMenu();
            }
        }while (5 == 5);
    }

    public void listarPunteos(){
        jugadores.ordenarPorVictorias();
        System.out.println("\nVictorias/Derrotas    Jugador");
        for (int k = 0; k < jugadores.getJugadoresActivos();k++){
            System.out.print(k+".    " + jugadores.getJugador(k+1).getVictorias()+"/"+jugadores.getJugador(k+1).getDerrotas()+"  "+jugadores.getJugador(k+1).getNombre()+"\n");
        }
    }

}
