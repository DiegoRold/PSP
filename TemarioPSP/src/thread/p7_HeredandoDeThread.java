package thread;

public class p7_HeredandoDeThread extends Thread{

    public void run() {
        System.out.println("Thread corriendo");
    }


    public static void main(String[] args) {

        p7_HeredandoDeThread miThread = new p7_HeredandoDeThread();
        miThread.start();

    }
}
