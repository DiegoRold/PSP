package procesos;

import java.io.IOException;

// vamos a utilizar el metodo process y processBuilder
public class p3 {

    public static void main(String[] args) throws IOException {

        //Para empezar tenemos que usar una cadena
        String comando1 = "notepad.exe C:\\Users\\diego\\Desktop\\dir1\\aleatorio1.txt"; //en este caso da error, para abajo vamos a ver como solucionarlo
        ProcessBuilder pb1 = new ProcessBuilder(comando1);

        //para lanzarlo
        //pb1.start(); si da error es porque hay que utilizar el throws IOException en el main

        //solución del error llamando a otro comando
        String [] comando2 ={"notepad.exe",  "C:\\Users\\diego\\Desktop\\dir1\\aleatorio1.txt"};
        //hemos creado una lista String para poder realizar ambos comandos

        ProcessBuilder pb2 = new ProcessBuilder(comando2);
        //pb2.start();

        String comando3 = "notepad.exe C:\\Users\\diego\\Desktop\\dir1\\aleatorio1.txt";
        ProcessBuilder pb3 = new ProcessBuilder(comando3.split("\\s")); //sirve para que no nos cuente los espacios
        pb3.start();
    }
}
