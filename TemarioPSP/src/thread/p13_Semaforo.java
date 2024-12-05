package thread;

import java.util.concurrent.Semaphore;

public class p13_Semaforo {

    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(3);

        Runnable tarea = () -> {
            try {
                semaforo.acquire();
                System.out.println(Thread.currentThread() .getName() + "adquirió el semáforo");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread() .getName() + "liberó el semáforo");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforo.release();
            }
        };

        Thread hilo1 = new Thread(tarea, "Hilo1");
        Thread hilo2 = new Thread(tarea, "Hilo2");
        Thread hilo3 = new Thread(tarea, "Hilo3");
        Thread hilo4 = new Thread(tarea, "Hilo4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

    }
}
