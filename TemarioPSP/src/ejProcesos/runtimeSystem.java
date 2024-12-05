package ejProcesos;

import java.util.Properties;

public class runtimeSystem {

    public static void main(String[] args) {

        // Obtener las propiedades del sistema
        Properties properties = System.getProperties();

        // Mostrar propiedades del sistema
        System.out.println("Propiedades del sistema:");
        for (String propertyName : properties.stringPropertyNames()) {
            System.out.println(propertyName + ": " + properties.getProperty(propertyName));
        }

        // Obtener información sobre la memoria
        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("\nMemoria total: " + totalMemory + " bytes");
        System.out.println("Memoria libre: " + freeMemory + " bytes");
        System.out.println("Memoria en uso: " + usedMemory + " bytes");

        // Obtener número de procesadores disponibles
        int availableProcessors = runtime.availableProcessors();
        System.out.println("Procesadores disponibles: " + availableProcessors);
    }
}
