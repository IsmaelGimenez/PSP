package jams.psp.ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class T1E54_SumadorLanzador_4 {
    //static final int NUM_PROCESOS = Runtime.getRuntime().availableProcessors();
    static final int NUM_PROCESOS=2;
    public static void main(String[] args) {

        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();

        long n1 = Long.parseLong(args[0]);
        long n2 = Long.parseLong(args[1]);
        long rangoTotal = n2 - n1 + 1;
        long salto = rangoTotal / NUM_PROCESOS;
        long resto = rangoTotal % NUM_PROCESOS; // Para distribuir números sobrantes
        long inicioIntervalo = n1;
        long suma=0;
        for (int i = 1; i <= NUM_PROCESOS; i++) {
            System.out.print("n1:" + inicioIntervalo);
            long  finIntervalo = inicioIntervalo + salto - 1;

            // Distribuir el resto en los primeros procesos
            if (i <= resto) {
                finIntervalo++;
            }

            System.out.println(" n2:" + finIntervalo);
            suma+=lanzarSumador(inicioIntervalo, finIntervalo);
            inicioIntervalo = finIntervalo + 1;
            //System.out.println("Suma lanzada...");
        }
        System.out.println("Suma total"+suma);
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
    }

    public static long lanzarSumador(Long n1, Long n2) {
        String clase = "jams.psp.ejemplos.T1E54_Sumador";
        long suma=0;
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
            pb.directory(new File("unidad1/target/classes"));
            Process p = pb.start();

            // Se lee la salida del subproceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                suma+=Long.parseLong(line.trim());
            }
            //p.waitFor(),
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suma;
    }
}
