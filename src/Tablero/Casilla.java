package src.Tablero;

public class Casilla{

    public static final String BG_NEGRA = "\u001B[40m";
    public static final String BG_BLANCA = "\u001B[47m";
    public static final String DEFAULT = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    private String color;
    private Ficha ficha;
    private boolean tieneFicha;
    private boolean negra;

    public Casilla(boolean negra){
        this.negra = negra;
        color = pintarCasilla(negra);
        tieneFicha = false;
    }

    public String pintarCasilla(boolean negra){
        String forma = "   ";
        if (tieneFicha){
            forma = ficha.getForma();
        }
        if (negra){
            return (BG_NEGRA+forma+DEFAULT);
        } else {
            return (BG_BLANCA+forma+DEFAULT);
        }
    }

    public void eliminarFicha(){
        this.ficha = null;
        tieneFicha = false;
    }

    public void repintar(){
        color = pintarCasilla(negra);
    }

    public void asignarFicha(boolean rojo){
        this.ficha = new Ficha(rojo);
        tieneFicha = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha){
        this.ficha = ficha;
    }

    public boolean isTieneFicha() {
        return tieneFicha;
    }

    public void setTieneFicha(boolean tieneFicha) {
        this.tieneFicha = tieneFicha;
    }
}