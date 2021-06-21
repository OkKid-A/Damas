package src.Jugadores;

public class Jugador {

    private String nombre;
    private int victorias;
    private int derrotas;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.victorias = 0;
        this.derrotas = 0;
    }

    public void sumarVictoria(){
        victorias++;
    }

    public void sumarDerrota(){
        derrotas++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
