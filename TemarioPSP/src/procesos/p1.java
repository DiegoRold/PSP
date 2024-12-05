package procesos;

import java.io.IOException;

public class p1 {

    public static void main(String[] args) {

        //runtime para que corra y usar .exec() para que abra el notepad
        try {
            Runtime.getRuntime() .exec("notepad.exe");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
