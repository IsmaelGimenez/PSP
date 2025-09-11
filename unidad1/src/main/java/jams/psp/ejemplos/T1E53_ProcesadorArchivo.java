package jams.psp.ejemplos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class T1E53_ProcesadorArchivo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: Falta el nombre del archivo.");
            System.exit(1); // Código de error
        }

        String fileName = args[0];
        System.out.println("Procesando archivo: " + fileName);
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            long lineCount = lines.count();
            System.out.println("Archivo " + fileName + " procesado. Contiene " + lineCount + " líneas.");
            System.exit(0); // Éxito
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + fileName + ": " + e.getMessage());
            System.exit(2); // Código de error de I/O
        }
    }
}
