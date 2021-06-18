package src.Tablero;

public class Tablero {

    private Casilla[][] casillas;

    public Tablero(){
        formarTablero();
    }

    public void formarTablero(){
        casillas = new Casilla[8][8];
        boolean negro = false;
        boolean tieneFicha = false;
        System.out.println();
        for (int k = 0;k < 8;k++){
            for (int i = 0;i < 8;i++){
                casillas[k][i] = new Casilla(negro);
                if (negro && k<3){
                    casillas[k][i].asignarFicha(true);
                } else  if (negro && k >4){
                    casillas[k][i].asignarFicha(false);
                }
                negro = !negro;
            }
            negro = !negro;
        }
    }

    public void mostrarTablero(){
        for (int k = 0;k < 8;k++){
            for (int i = 0;i < 8;i++){
                casillas[k][i].repintar();
                System.out.printf(casillas[k][i].getColor());
            }
            System.out.println((8-k)+"");
        }
        System.out.printf(" A  B  C  D  E  F  G  H");
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
}