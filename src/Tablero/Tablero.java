package src.Tablero;

import src.Jugadores.Jugador;
import src.Menu.ComprobarDatos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tablero {

    private Casilla[][] casillas;
    private int fichasRojas;
    private int fichasAmarillas;
    private Jugador jugadorRojas;
    private Jugador jugadorAmarillas;

    public Tablero(Jugador jugadorRojas, Jugador jugadorAmarillas) {
        this.jugadorAmarillas = jugadorAmarillas;
        this.jugadorRojas = jugadorRojas;
        fichasRojas = 12;
        fichasAmarillas = 12;
        formarTablero();
        mostrarTablero();
    }

    public void formarTablero() {
        casillas = new Casilla[8][8];
        boolean negro = false;
        boolean tieneFicha = false;
        System.out.println();
        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                casillas[k][i] = new Casilla(negro);
                if (negro && k < 3) {
                    casillas[k][i].asignarFicha(true);
                } else if (negro && k > 4) {
                    casillas[k][i].asignarFicha(false);
                }
                negro = !negro;
            }
            negro = !negro;
        }
    }

    public void mostrarTablero() {
        fichasRojas = 0;
        fichasAmarillas = 0;
        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                casillas[k][i].repintar();
                System.out.printf(casillas[k][i].getColor());
                if (casillas[k][i].isTieneFicha() && casillas[k][i].getFicha().isRojo()) {
                    fichasRojas++;
                } else if (casillas[k][i].isTieneFicha() && !casillas[k][i].getFicha().isRojo()) {
                    fichasAmarillas++;
                }
            }
            System.out.println((8 - k) + "");
        }
        System.out.printf(" A  B  C  D  E  F  G  H");
    }

    public void moverFicha(String posicionInicial, String posicionFinal, boolean roja) throws NumberFormatException {
        int horizonInicial = ComprobarDatos.traducirChara(posicionInicial.toCharArray()[0]);
        int verticalInicial = Integer.valueOf(posicionInicial.substring(1, 2)) - 1;
        int horizonFinal = ComprobarDatos.traducirChara(posicionFinal.toCharArray()[0]);
        int verticalFinal = Integer.valueOf(posicionFinal.substring(1, 2)) - 1;
        int diferencia = (horizonFinal + ((1 + verticalFinal) * 8)) - (horizonInicial + ((1 + verticalInicial) * 8));
        if (diferencia == 7 || diferencia == 9 || diferencia == -7 || diferencia == -9) {
            realizarMove(verticalInicial, verticalFinal, horizonInicial, horizonFinal, roja);
        } else if ((diferencia == 14 || diferencia == -14) && !roja) {
            realizarMove(verticalInicial, verticalFinal, horizonInicial, horizonFinal, roja);
            casillas[6 - verticalInicial][horizonInicial - 1].eliminarFicha();
        } else if ((diferencia == 18 || diferencia == -18) && !roja) {
            realizarMove(verticalInicial, verticalFinal, horizonInicial, horizonFinal, roja);
            casillas[6 - verticalInicial][horizonInicial + 1].eliminarFicha();
        } else if ((diferencia == 14 || diferencia == -14) && roja) {
            realizarMove(verticalInicial, verticalFinal, horizonInicial, horizonFinal, roja);
            casillas[6 - verticalFinal][horizonFinal - 1].eliminarFicha();
        } else if ((diferencia == 18 || diferencia == -18) && roja) {
            realizarMove(verticalInicial, verticalFinal, horizonInicial, horizonFinal, roja);
            casillas[6 - verticalFinal][horizonFinal + 1].eliminarFicha();
        } else {
            System.out.println("\nMovimiento ilegal");
            int error = Integer.parseInt("pro");
        }
    }

    public void realizarMove(int verticalInicial, int verticalFinal, int horizonInicial, int horizonFinal, boolean roja) {
        casillas[7 - verticalInicial][horizonInicial].eliminarFicha();
        casillas[7 - verticalFinal][horizonFinal].asignarFicha(roja);
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public int getFichasRojas() {
        return fichasRojas;
    }

    public int getFichasAmarillas() {
        return fichasAmarillas;
    }

    public Jugador getJugadorRojas() {
        return jugadorRojas;
    }

    public Jugador getJugadorAmarillas() {
        return jugadorAmarillas;
    }
}