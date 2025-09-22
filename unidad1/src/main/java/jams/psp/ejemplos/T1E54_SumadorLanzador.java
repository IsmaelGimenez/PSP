package jams.psp.ejemplos;


public class T1E54_SumadorLanzador {
    public static void main(String[] args) {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        T1E54_SumadorLanzador ls = new T1E54_SumadorLanzador();
        ls.lanzarSumador(1D,500000D);
        System.out.println("Ok");
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
    }

    public long lanzarSumador(Double n1, Double n2) {
        String clase = "jams.psp.ejemplos.T1E54_Sumador";
        ProcessBuilder pb;
        long num=0;
        try {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
            
            // Con este método, el proceso creado hereda los flujos de entrada y salida del padre
            // ¿Se ha ejecutado la suma?
            // Descomentar para comprobar
            // pb.inheritIO();
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }
}
