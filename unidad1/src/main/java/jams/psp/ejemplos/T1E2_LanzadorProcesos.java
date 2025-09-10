package jams.psp.ejemplos;

import java.io.IOException;

public class T1E2_LanzadorProcesos {
    public void ejecutar(String ruta){
        ProcessBuilder pb;
        try{
            pb=new ProcessBuilder(ruta.split(" "));
            pb.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ruta="ls -l";
        T1E2_LanzadorProcesos lp=new T1E2_LanzadorProcesos();
        lp.ejecutar(ruta);
        System.out.println("Finalizado");
    }
}
