package jams.psp.ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

public class T1E422_Lanzador {
    public static void main(String args) {
        try {
            // Se configura el comando para lanzar la clase Sumador
            // Nota: Es crucial especificar la ruta correcta al.class
            ProcessBuilder pb = new ProcessBuilder("java", "Sumador", "10", "20", "30");

            // Para que ProcessBuilder encuentre la clase, se debe establecer el directorio
            // de trabajo al directorio donde se encuentran los archivos.class 
            pb.directory(new File("ruta/a/build/classes"));

            Process p = pb.start();

            // Se lee la salida del subproceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Se espera a que el subproceso termine
            int exitCode = p.waitFor();
            System.out.println("Subproceso 'Sumador' finalizado con código de salida: " + exitCode);

            // Se lee la salida de error en caso de que ocurra un problema
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
