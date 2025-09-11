package jams.psp.ejemplos;

import java.io.File;

public class T1E54_SumadorLanzador_2 {
    public static void main(String[] args) {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();

        T1E54_SumadorLanzador_3 ls = new T1E54_SumadorLanzador_3();
        ls.lanzarSumador(1D,500000D);
        System.out.println("Ok");
        
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
    }

    public void lanzarSumador(Double n1, Double n2) {
        String clase = "jams.psp.ejemplos.T1E54_Sumador";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
            pb.directory(new File("Codigo/unidad1/target/classes"));
            pb.inheritIO();
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
