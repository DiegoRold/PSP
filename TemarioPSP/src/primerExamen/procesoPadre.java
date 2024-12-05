package primerExamen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class procesoPadre {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File dir = obtenerDirectorio(scanner); // Pedimos la ruta del directorio de entrada

        if (dir == null) {
            System.out.println("Directorio no válido. Saliendo del programa.");
            return; // Terminar el programa si el directorio no es válido
        }

        // Crear el directorio "salida" donde se guardarán los resultados
        File dirSalida = new File(dir, "salida");
        if (!dirSalida.exists()) {
            dirSalida.mkdir(); // Crear el directorio si no existe
        }

        // Listar archivos de texto y procesarlos
        File[] archivos = dir.listFiles((d, nombre) -> nombre.endsWith(".txt"));
        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos .txt en el directorio.");
            return;
        }

        // Crear un proceso hijo para cada archivo
        for (File archivo : archivos) {
            crearProcesoHijo(archivo);
        }

        // Calcular la suma total de los archivos de salida generados
        int sumaTotal = calcularSumaTotal(dirSalida);
        System.out.println("Suma total de todos los archivos: " + sumaTotal);
    }

    // Método para solicitar el directorio de entrada
    private static File obtenerDirectorio(Scanner scanner) {
        System.out.print("Indique la ruta del directorio donde están los archivos de entrada: ");
        String ruta = scanner.nextLine();
        File dir = new File(ruta);

        // Validamos que sea un directorio válido y que contenga archivos
        if (dir.exists() && dir.isDirectory() && dir.listFiles().length > 0) {
            return dir;
        } else {
            System.out.println("El directorio no es válido o está vacío.");
            return null;
        }
    }

    // Método para crear un proceso hijo para un archivo
    private static void crearProcesoHijo(File archivo) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "practicaExamen.Hijo", archivo.getAbsolutePath());
            pb.inheritIO(); // Permitir que el hijo use la misma salida de consola

            Process proceso = pb.start(); // Iniciar el proceso hijo
            proceso.waitFor(); // Esperar a que el proceso hijo termine
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el proceso hijo para el archivo: " + archivo.getName());
        }
    }

    // Método para calcular la suma total de los resultados en el directorio de salida
    private static int calcularSumaTotal(File dirSalida) {
        int sumaTotal = 0;

        for (File archivoSalida : dirSalida.listFiles()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivoSalida))) {
                String linea = br.readLine();
                sumaTotal += Integer.parseInt(linea); // Convertir el texto a un número y sumar
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error al leer o convertir el archivo de salida: " + archivoSalida.getName());
            }
        }
        return sumaTotal; // Retornar la suma total de los resultados
    }
}
