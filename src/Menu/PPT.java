package src.Menu;

import src.Jugadores.Jugador;

import java.util.Random;

public class PPT{

    private Jugador jugador1;
    private Jugador jugador2;
    private int ganador;
    private Random random;
    private int rol1;
    private int rol2;

    public PPT(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        random = new Random();
    }

    public void escoger(int ganador){
        switch (ganador){
            case 0:
                System.out.println("\nEl ganador es " + jugador1.getNombre() + " Asi que tiene las amarillas");
                break;
            case 1:
                System.out.println("\nEl ganador es "+jugador2.getNombre()+" Asi que tiene las amarillas");
                break;
            case 2:
                System.out.println("\nFue un empate...");
        }
    }

    public String traducirInt(int indice){
        switch (indice){
            case 0:
                return "Piedra";
            case 1:
                return "Tijeras";
            case 2:
                return "Papel";
            default:
                return null;
        }
    }

    public int jugar(int jugador1,int jugador2) {
        if (jugador1 == 0 && jugador2 == 2) {
            return 1;
        } else if (jugador1 == 2 && jugador2 == 0){
            return 0;
        }else if (jugador1<jugador2){
            return 0;
        } else if (jugador1 == jugador2){
            return 2;
        } else  if(jugador1>jugador2){
            return 1;
        } else {
            return 2;
        }
    }

    public int randomizarJugador(){
        return random.nextInt(2);
    }

    public int run() {
        System.out.println("\nPiedra");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nPapel");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("\nO Tijeras");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n1 2 3 YA!");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rol1 = randomizarJugador();
        rol2 = randomizarJugador();
        System.out.println("\n"+jugador1.getNombre()+" ha jugado: "+traducirInt(rol1));
        System.out.println("\n"+jugador2.getNombre()+" ha jugado: "+traducirInt(rol2));
        ganador = jugar(rol1,rol2);
        escoger(ganador);
        return ganador;
    }

    public int getGanador() {
        return ganador;
    }
}
