package jams.psp.ejemplos;

import java.io.IOException;

public class T1E1_RuntimeListado {
    public static void main(String[] args) {
        // Primero obtenemos la carpeta del usuario
        String homeDirectory = System.getProperty("user.home");
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        System.out.println(homeDirectory);
        try {
            if (isWindows) {
                Runtime.getRuntime().exec(String.format("cmd.exe /c dir %s", homeDirectory));
            } else {
                Runtime.getRuntime().exec(String.format("sh -c ls %s", homeDirectory));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
