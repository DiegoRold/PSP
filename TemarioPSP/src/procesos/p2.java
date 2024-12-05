package procesos;

import java.io.IOException;

public class p2 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        //Obtener directorio
        String directorioHome = System.getProperty("user.home");
        //getProperty("user.home") nos indica cual es el directorio del usuario, cada usuario tendrá su directorio propio

        System.out.println("Directorio HOME: " + directorioHome);

        //System.getProperty("os.name") nos informará del windows que tenemos
        //.startsWith("windows") nos da true si es un windows y un false si no es un sistema windows
        boolean esWindows = System.getProperty("os.name") .toLowerCase() .startsWith("windows");
        System.out.println("OS NAME: " + System.getProperty("os.name") + " es.Windows: " + esWindows);

        //lanzar una shell para ejecutar un commando abriendo la terminal
        if(esWindows) {
            //cmd.exe /c para cargar el comando y el start  cmd.exe /k para mantenerlo activo
            Runtime.getRuntime() .exec(String.format("cmd.exe /c start cmd.exe /k dir %s", directorioHome));
        } else {
            //cargar comando
            Runtime.getRuntime() .exec(String.format("sh -c ls %s", directorioHome));
        }
        //String.format es para formatear
    }
}
