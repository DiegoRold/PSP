package ejProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ej1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Solicitar acción
            System.out.println("¿Qué acción quieres realizar? (apagar, reiniciar, suspender): ");
            String action = reader.readLine().trim().toLowerCase();

            // Solicitar tiempo
            System.out.println("¿Cuántos segundos quieres esperar antes de realizar la acción?: ");
            String timeInput = reader.readLine().trim();
            int time = Integer.parseInt(timeInput);

            // Determinar sistema operativo
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            switch (action) {
                case "apagar":
                    if (os.contains("win")) {
                        processBuilder = new ProcessBuilder("C:\\Windows\\System32\\shutdown.exe", "-s", "-t", String.valueOf(time));
                    } else {
                        processBuilder = new ProcessBuilder("shutdown", "-h", String.valueOf(time));
                    }
                    break;
                case "reiniciar":
                    if (os.contains("win")) {
                        processBuilder = new ProcessBuilder("C:\\Windows\\System32\\shutdown.exe", "-r", "-t", String.valueOf(time));
                    } else {
                        processBuilder = new ProcessBuilder("shutdown", "-r", String.valueOf(time));
                    }
                    break;
                case "suspender":
                    if (os.contains("win")) {
                        processBuilder = new ProcessBuilder("C:\\Windows\\System32\\shutdown.exe", "-h");
                    } else {
                        processBuilder = new ProcessBuilder("systemctl", "suspend");
                    }
                    break;
                default:
                    System.out.println("Acción no válida.");
                    return;
            }

            // Mostrar el comando que se va a ejecutar
            System.out.println("Comando a ejecutar: " + processBuilder.command());

            // Ejecutar el comando
            processBuilder.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número válido para el tiempo.");
        }
    }
}
