package thread;

public class p9_MetodosThreadHilos implements Runnable{

    public void run() {

        String nombreThread = Thread.currentThread().getName();

        System.out.println("[" + nombreThread + "]" + "Dentro del thread");

        System.out.println("[" + nombreThread + "]" + "Prioridad" + Thread.currentThread().getPriority());

        Thread.yield();
        System.out.println("[" + nombreThread + "]" + "Id: " + Thread.currentThread().getId());

        //Obtener nombre de grupos de hilos
        System.out.println("[" + nombreThread + "]" + Thread.currentThread().getThreadGroup().getName());

        //Contador de grupo del hilo
        System.out.println("[" + nombreThread + "]" + "Contador del grupo del hilo" + Thread.currentThread().getThreadGroup().activeCount());
    }

}
