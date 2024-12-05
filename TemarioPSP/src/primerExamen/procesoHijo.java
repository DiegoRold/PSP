package primerExamen;

import java.io.*;

public class procesoHijo {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Uso incorrecto. Uso: Hijo <ruta del archivo>");
            return;
        }

        File archivoEntrada = new File(args[0]);
        if (!archivoEntrada.exists()) {
            System.out.println("Error: archivo no encontrado.");
            return;
        }

        int suma = 0;

        // Leer el archivo línea por línea y sumar sus números
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                suma += Integer.parseInt(linea.trim()); // Convertir a entero y sumar
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo: " + archivoEntrada.getName());
            return;
        }

        // Escribir la suma en un archivo de salida
        String nombreSalida = archivoEntrada.getName().replace(".txt","salida.txt");
        File archivoSalida = new File(archivoEntrada.getParent() + "/salida/" + nombreSalida);

        try (FileWriter fw = new FileWriter(archivoSalida)){
            fw.write(Integer.toString(suma)); //Aquí guardamos la suma en el archivo de salida
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de salida: " + archivoSalida.getName());
        }

    }
}
