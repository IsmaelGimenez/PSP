package jams.psp.ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class T1E421_LanzadosComando {
    public static void main(String[] args) {
        try {
            // Se define el comando a ejecutar
            ProcessBuilder pb = new ProcessBuilder("ls", "-l");
            // Se puede cambiar el directorio de trabajo si es necesario
            pb.directory(new File("/home/usuario/documentos"));

            // Se lanza el subproceso
            Process p = pb.start();

            // Se lee la salida del subproceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            System.out.println("--- Salida del comando ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Se espera a que el subproceso termine y se obtiene el valor de salida
            int exitCode = p.waitFor();
            System.out.println("--- Subproceso terminado con código de salida: " + exitCode + " ---");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
