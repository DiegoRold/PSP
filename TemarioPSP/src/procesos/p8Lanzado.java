package procesos;

import java.io.IOException;

public class p8Lanzado {

    public static void main(String[] args) throws IOException, InterruptedException {

        if(args.length != 1) {
            System.out.println("Uso: p8Lanzado <nombre_de_aplicacion>");
            System.exit(1);
        }

        String aplicacion = args[0];

        ProcessBuilder pb = new ProcessBuilder(aplicacion);
        Process proceso = pb.start(); //hacemos throws

        int codigoFinalizacion;

        //en el waitFor realizamos un try catch
        try {
            codigoFinalizacion = proceso.waitFor();
            System.out.println("Código de finalización: " + codigoFinalizacion);
            System.exit(codigoFinalizacion);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
    }
}
