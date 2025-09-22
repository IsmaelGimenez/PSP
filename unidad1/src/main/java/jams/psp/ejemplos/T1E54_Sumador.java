package jams.psp.ejemplos;

/**
 * Suma los números comprendidos entre los dos núnmeros que recibe como parámetro
 */
public class T1E54_Sumador {
    public static void main(String[] args) {
        long numero1 = Long.parseLong(args[0]);
        long numero2 = Long.parseLong(args[1]);
        long resultado = 0;
        for (long i = numero1; i <= numero2; i++) {
            resultado = resultado + i;
        }
        System.out.println(resultado);
    }
}
