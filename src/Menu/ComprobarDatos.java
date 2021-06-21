package src.Menu;

import java.util.*;

public class ComprobarDatos {
    static Scanner scanner = new Scanner(System.in);

    private static void imprimirMensaje(String mensaje){
        System.out.print("\n"+mensaje+" ");
    }

    public static int getEntero(String mensaje, boolean negativo){
        imprimirMensaje(mensaje);
        int tmp = scanner.nextInt();
        scanner.nextLine();

        if( negativo ){
            return tmp;
        }

        if (tmp<0){
            do{
                imprimirMensaje("\n\n No puede ingresar números negativos\n");
                imprimirMensaje(mensaje);
                tmp = scanner.nextInt();
            } while(tmp<0);
        }

        return tmp;
    }

    public static String getTexto(String mensaje){
        imprimirMensaje(mensaje);
        String res = scanner.nextLine();
        return res;
    }

    public static int traducirChara(char caracter){
        switch (caracter){
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            default:
                return -1;
        }
    }

}
