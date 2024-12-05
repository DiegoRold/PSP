package ejProcesos;

import java.io.IOException;

public class ej3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Array de comandos a ejecutar
        String[] comandos = {
                "notepad",
                "calc",
                "comando_inexistente", // Comando inválido
                "cmd /c echo Hola Mundo", // Comando válido
                "explorer" // Otro comando válido
        };

        for (String comando : comandos) {
            try {
                // Crear un proceso para ejecutar el comando
                Process process = Runtime.getRuntime().exec(comando);
                // Esperar a que el proceso termine y obtener el código de finalización
                int exitCode = process.waitFor();
                System.out.println("Comando: " + comando + " - Código de finalización: " + exitCode);
            } catch (IOException e) {
                System.out.println("Error al ejecutar el comando: " + comando + " - " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("El proceso fue interrumpido: " + comando);
                Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
            }
        }

        // Probar System.exit()
        System.exit(10); // Cambiar a 0 para la otra prueba
    }
}
