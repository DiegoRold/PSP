package procesos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class p4 {

    public static void main(String[] args) {
        if(args.length == 2 && args[0].equals("-install")){
            String directorio = args[1];
            System.out.println("Instalando en el directorio " + directorio);
            File dir = new File(directorio);
            if(!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, "instalacion.log");
            try {
                FileWriter writer = new FileWriter (file);
                writer.write("Archivo de instalación creando en: " + file.getAbsolutePath());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("Uso incorrecto. Utilizar: -install <directorio>");
        }
    }
}
