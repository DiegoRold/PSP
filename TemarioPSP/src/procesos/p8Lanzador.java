package procesos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class p8Lanzador {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Aplicación a ejecutar");
        String aplicacion = sc.nextLine();

        //creamos processbuilder
        ProcessBuilder pb = new ProcessBuilder("java", "procesos.p8Lanzado", aplicacion ); ///metemos comando y lanzador

        //llamamor la clase para cambiarle al directorio bin
        pb.directory(new File("bin")); //nos retorno al directorio insertado
        pb.inheritIO(); //se añade por si nos da un error
        Process proceso = pb.start(); //hacemos un throws

        //nos devuelve el código de salida del proceso
        //el waitFor
        int codigoFinalizacion = proceso.waitFor();
        if(codigoFinalizacion == 0) {
            System.out.println("Aplicación ejecutada correctamente");
        } else {
            System.out.println("Aplicación ejecutada incorrectamente. Código de error: " + codigoFinalizacion);
        }

    }
}
