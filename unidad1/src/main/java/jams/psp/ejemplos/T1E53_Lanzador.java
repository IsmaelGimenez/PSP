package jams.psp.ejemplos;

import java.io.File;
import java.io.IOException;

public class T1E53_Lanzador {
    public static void main(String args) {
        String[] archivos = { "archivo1.txt", "archivo2.txt", "archivo_inexistente.txt" };

        File classPath = new File("ruta/al/directorio/de/clases");

        for (String archivo : archivos) {
            try {
                // Configurar el subproceso para procesar un archivo
                ProcessBuilder pb = new ProcessBuilder("java", "ProcesadorArchivo", archivo);
                pb.directory(classPath);

                // Redirigir la salida y error del subproceso al proceso padre
                pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                pb.redirectError(ProcessBuilder.Redirect.INHERIT);

                // Lanzar el subproceso
                Process p = pb.start();

                // Esperar a que el subproceso termine
                int exitCode = p.waitFor();

                System.out.println("El subproceso para '" + archivo + "' ha terminado con código " + exitCode);
                System.out.println("----------------------------------------");

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
