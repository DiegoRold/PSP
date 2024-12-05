package ejProcesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ej2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try  {
            //Imprimir el directorio de trabajo actual
            System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));

            // Cambiar la propiedad user.dir
            System.setProperty("user.dir", "C:/temp"); // Cambia a "/tmp" en Linux

            // Imprimir el nuevo valor de user.dir
            System.out.println("Nuevo valor de user.dir: " + System.getProperty("user.dir"));

            // Determinar el comando basado en el sistema operativo
            String command = System.getProperty("os.name").toLowerCase().contains("win") ? "cmd.exe /c dir" : "ls";

            // Cambiar el directorio de trabajo a C:/temp o /tmp
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.directory(new java.io.File(System.getProperty("user.dir")));

            // Mostrar el directorio de trabajo después de cambiar
            System.out.println("Directorio de trabajo después de cambiar: " + processBuilder.directory().getAbsolutePath());

            // Iniciar el proceso
            Process process = processBuilder.start();

            // Leer la salida del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
