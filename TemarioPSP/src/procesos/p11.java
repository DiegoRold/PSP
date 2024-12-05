package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class p11 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            // Primer proceso: "find src -name *.java -type f"
            Process proceso1 = new ProcessBuilder("cmd.exe", "start" , "cmd.exe", "/c" , "echo", "hola").start();
            // Segundo proceso: "wc -l"
            Process proceso2 = new ProcessBuilder("findstr", "xxx").start();
            // Conectar la salida del primer proceso a la entrada del segundo proceso
            BufferedReader lectorP1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
            OutputStream escritorP2 = proceso2.getOutputStream();
            String linea;
            while ((linea = lectorP1.readLine()) != null) {
                escritorP2.write((linea + "\n").getBytes(StandardCharsets.UTF_8));
            }
            lectorP1.close();
            escritorP2.close(); // Importante cerrar la entrada del segundo proceso
            // Obtener la salida del segundo proceso
            BufferedReader lectorP2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
            String resultado = lectorP2.readLine();
            lectorP2.close();
            System.out.println("Resultado: " + resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
