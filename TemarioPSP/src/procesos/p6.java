package procesos;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class p6 {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pbuilder = new ProcessBuilder("");
        System.out.println("Directorio de trabajo por defecto: " + System.getProperty("user.dir")); //muestra directorio por defecto
        pbuilder.directory(new File(System.getProperty("user.home")));

        Map <String, String> environment = pbuilder.environment();

        //obtener la variable de Path, modificarla y añadirle una nueva ruta.
        String systemPath = environment.get("Path") + "C:\\Users\\diego\\Desktop\\dir2";
        environment.replace("Path", systemPath);
        System.out.println("Path: " + environment.get("Path"));

        //vamos ha agregar una nueva variable de entorno con environment
        environment.put("Saludos", "Hola a todos");

        //pbuilder.command("cmd.exe", "start", "cmd.exe", "/k", "echo %Saludos%");

        pbuilder.command("cmd.exe", "start", "cmd.exe", "/k", "dir", "C:\\Users\\diego\\Dekstop\\dir2");

        // nos permite visualizarlo aquí --> pbuilder.inheritIO();

        //redirigimos la salida
        pbuilder.redirectOutput(new File("C:\\Users\\diego\\Desktop\\dir2\\salida_proc.txt"));

        //crear salida de error
        pbuilder.redirectError(new File("C:\\Users\\diego\\Desktop\\dir2\\salida_err.txt"));

        pbuilder.start();//hacemos throws

        Map variablesEntorno = pbuilder.environment();
        System.out.println("Variable entorno: " + variablesEntorno);

        //Ejecutamos commando para llamar a la lista
        List command = pbuilder.command();

        //Ejecutamos el iterator para modificar el nombre.
        Iterator iter = command.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
