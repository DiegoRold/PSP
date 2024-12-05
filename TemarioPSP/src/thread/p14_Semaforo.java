package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class p14_Semaforo {

    //creamos variable final
    private final int MAX_LIMITED = 20;
    private int producto = 0;
    private Semaphore productor = new Semaphore(MAX_LIMITED);
    private Semaphore consumidor = new Semaphore (0);
    private Semaphore mutex = new Semaphore(1);

    public void producir(String nombreProductor) throws InterruptedException {
        System.out.println(nombreProductor + " intentando almacenar un producto");
        productor.acquire();
        mutex.acquire();
        producto++;

        System.out.println(nombreProductor + " almacena un producto. Almacén con " + producto + "productos");

        mutex.release();

        Thread.sleep(ThreadLocalRandom.current().nextInt(0, 1000));

        consumidor.release();
    }

    public void consumir(String nombreConsumidor) throws InterruptedException {
        System.out.println(nombreConsumidor + " intentando retirar un producto");
        consumidor.acquire();
        mutex.acquire();
        producto--;
        System.out.println(nombreConsumidor + " retirar un producto" + "Almacén con + producto" + producto + "productos");
        mutex.release();
        Thread.sleep(ThreadLocalRandom.current().nextInt(0,10000000));

        productor.release();
    }
}
