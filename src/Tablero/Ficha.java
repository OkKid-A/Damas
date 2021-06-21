package src.Tablero;

public class Ficha {

    private boolean rojo;
    private String forma;
    private boolean coronado;

    public Ficha(boolean rojo){
        this.rojo = rojo;
        forma = dibujarForma();
        coronado = false;
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

    public boolean isCoronado() {
        return coronado;
    }

    public void setCoronado(boolean coronado) {
        this.coronado = coronado;
    }
}
