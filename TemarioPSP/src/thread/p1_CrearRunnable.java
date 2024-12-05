package thread;

public class p1_CrearRunnable implements Runnable{

    public static void main(String[] args) {
        p1_CrearRunnable miRunnable = new p1_CrearRunnable();//instanciar clase
        Thread hilo1 = new Thread(miRunnable);
        hilo1.start();

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Hilo corriendo.");
    }
}
