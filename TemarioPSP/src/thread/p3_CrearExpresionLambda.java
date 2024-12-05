package thread;

public class p3_CrearExpresionLambda {

    public static void main(String[] args){

        Runnable miRunnable = () -> {
            System.out.println("Thread corriendo");
        };
        Thread thread = new Thread(miRunnable);
        thread.start();
    }
}
