package src.Tablero;

public class Ficha {

    private boolean rojo;
    private String forma;

    public Ficha(boolean rojo){
        this.rojo = rojo;
        forma = dibujarForma();
    }

    public String dibujarForma(){
        if (rojo){
            return Casilla.ROJO+" @ ";
        } else {
            return Casilla.AMARILLO+" @ ";
        }
    }

    public boolean isRojo() {
        return rojo;
    }

    public String getForma() {
        return forma;
    }

    public void setRojo(boolean rojo) {
        this.rojo = rojo;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
}
