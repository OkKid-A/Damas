package src.Tablero;

import src.Jugadores.Jugador;
import src.Jugadores.TablaJugadores;
import src.Menu.ComprobarDatos;
import src.Menu.PPT;

import java.util.InputMismatchException;

public class Arbitro {

    private TablaJugadores jugadores;
    private Tablero tablero;

    public Arbitro(TablaJugadores jugadores){
        this.jugadores = jugadores;
    }

    public void iniciarPartida(){
        if (jugadores.getJugadoresActivos()<2){
            System.out.println("No podemos jugar una partida con menos de 2 jugadores");
        } else {
            pedirJugadores();
        }
    }

    public void pedirJugadores(){
        try {
            jugadores.mostrarJugadores();
            Jugador jugador1 = jugadores.getJugador(ComprobarDatos.getEntero("Selecciona al jugador 1", false));
            jugadores.mostrarJugadores();
            Jugador jugador2 = jugadores.getJugador(ComprobarDatos.getEntero("Selecciona al jugador 2", false));
            PPT mini = new PPT(jugador1, jugador2);
            int first;
            do {
                first = mini.run();
            }while (mini.getGanador()==2);
            if (first == 0){
                tablero = new Tablero(jugador1,jugador2);
                empezarTurnos(jugador1,jugador2);
            } else {
                tablero = new Tablero(jugador2,jugador1);
                empezarTurnos(jugador2,jugador1);
            }
        } catch (IndexOutOfBoundsException | InputMismatchException e){
            System.out.println("\nNo se reconocio ese numero, intenta de nuevo");
            pedirJugadores();
        }
    }

    public void empezarTurnos(Jugador jugadorAmarillas,Jugador jugadorRojas){
        do {
            jugarTurno(jugadorAmarillas,false);
                if(comprobarGanador() != null){
                    break;
                }
            jugarTurno(jugadorRojas,true);
        } while (comprobarGanador() == null);
    }

    public void jugarTurno(Jugador jugador,boolean rojas){
        System.out.println("\nEs el turno de "+jugador.getNombre());
        String fichaEscogida = ComprobarDatos.getTexto("Ingresa la posicion de la ficha que deseas mover:");
        String movimiento = ComprobarDatos.getTexto("Ingresa la posicion hacia donde la quieres mover:\n");
        try {
            tablero.moverFicha(fichaEscogida, movimiento, rojas);
        } catch (InputMismatchException |NumberFormatException e){
            jugarTurno(jugador,rojas);
        }
        tablero.mostrarTablero();
    }

    public Jugador comprobarGanador(){
        if (tablero.getFichasRojas()==0){
            declararGanador(tablero.getJugadorAmarillas(),tablero.getJugadorRojas());
            return tablero.getJugadorAmarillas();
        } else if (tablero.getFichasAmarillas() == 0){
            declararGanador(tablero.getJugadorRojas(),tablero.getJugadorAmarillas());
            return tablero.getJugadorRojas();
        } 
        return null;
    }

    public void declararGanador(Jugador ganador,Jugador perdedor){
        System.out.println("\nHa ganado " + ganador.getNombre()+"!!!!!!");
        perdedor.sumarDerrota();
        ganador.sumarVictoria();
        System.out.println("\nLa partida ha terminado");
    }


}
