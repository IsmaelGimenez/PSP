package jams.psp.ejemplos;

import java.io.IOException;

public class T1E4_LanzadorProcesosArgs {
    public static void main(String[] args) {
        if (args.length <= 0){
            System.out.println("Hay que indicar el comando a ejecutar...");
            System.exit(1);
        }

        ProcessBuilder pb=new ProcessBuilder(args);
        pb.inheritIO(); // Hereda E/S del proceso padre

        try {
            Process p=pb.start();
            int codeRetorno=p.waitFor(); // Recoge el código de retorno del proceso
            System.out.println("Ejecución finalizada con código "+codeRetorno);
        } catch (IOException e) {
            System.err.println("Error durante la ejecución");
            // e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e){
            System.err.println("Proceso interrumpido");
            System.out.println(3);
        }
    }
}
