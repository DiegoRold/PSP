package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class p10 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        List<ProcessBuilder> builders = Arrays.asList(
                new ProcessBuilder("cmd.exe", "start" , "cmd.exe", "/c" , "echo", "xxxholaxxx"),
                new ProcessBuilder("findstr", "hola")
        );

        List <Process> pipeline = ProcessBuilder.startPipeline(builders);

        // El último proceso de la lista es el que queremos capturar
        Process lastProcess = pipeline.get(pipeline.size() - 1);
        // Capturar y mostrar la salida del último proceso
        try (BufferedReader outputReader = new BufferedReader(new InputStreamReader(lastProcess.getInputStream()))) {
            String line;
            while ((line = outputReader.readLine()) != null) {
                System.out.println("Salida del comando: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
