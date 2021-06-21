package src.Jugadores;

import src.Menu.ComprobarDatos;

public class TablaJugadores {

    private Jugador[] jugadores;
    private int jugadoresActivos;

    public TablaJugadores(){
        jugadores = new Jugador[10];
        jugadoresActivos = 0;
    }

    public void agregarJugador(){
        if (jugadoresActivos<10) {
            String nombre = ComprobarDatos.getTexto("\nIngresa el nombre del Jugador");
            jugadores[jugadoresActivos] = new Jugador(nombre);
            jugadoresActivos++;
            System.out.println("\nEl jugador se agrego con exito");
        } else {
            System.out.println("Se ha alcanzado el limite de jugadores");
        }
    }

    public void mostrarJugadores(){
        for (int k = 0;k < jugadoresActivos;k++){
            System.out.println("\n"+(k+1)+". "+jugadores[k].getNombre());
        }
    }
    public Jugador getJugador(int indice) {
        return jugadores[indice-1];
    }

    public int getJugadoresActivos() {
        return jugadoresActivos;
    }

    public void ordenarPorVictorias(){
        for (int k = 0;k < jugadoresActivos;k++) {
            for (int i = k+1; i < jugadoresActivos;i++){
                if (jugadores[k].getVictorias()<jugadores[i].getVictorias()) {
                    Jugador temp = jugadores[k];
                    jugadores[k] = jugadores[i];
                    jugadores[i] = temp;
                }
            }
        }
    }
}
