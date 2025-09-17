package jams.psp.ejemplos;

public class T1E422_Sumador {
    public static void main(String[] args) {
        // Se asume que los argumentos son números a sumar
        long resultado = 0;
        for (String arg : args) {
            try {
                resultado += Long.parseLong(arg);
            } catch (NumberFormatException e) {
                // Si hay un error, el subproceso devuelve 1
                System.err.println("Error: El argumento '" + arg + "' no es un número.");
                System.exit(1);
            }
        }
        System.out.println("El resultado de la suma es: " + resultado);
        // Si todo va bien, el subproceso devuelve 0
        System.exit(0);
    }
}
