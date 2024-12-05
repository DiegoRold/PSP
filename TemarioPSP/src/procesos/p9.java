package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "start", "cmd.exe", "/c", "dir", "C:\\Users\\diego\\Desktop\\dir2");

        Process p = pb.start(); //throws

        //pb.inheritIO();

        BufferedReader salidaProceso =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        String linea;
        while((linea = salidaProceso.readLine()) != null) {
            System.out.println("stdout: " + linea);
        }
        salidaProceso.close();

        BufferedReader errorProceso =
                new BufferedReader(new InputStreamReader(p.getErrorStream()));
        while((linea = errorProceso.readLine()) !=null) {
            System.out.println("stderr:" + linea);
        }
        errorProceso.close();
    }
}
