package thread;

public class p10_PrioridadHilo extends Thread{

    //Contado
    long c = 0;

    boolean stopHilo = false; //nos indica que tenemos que parar el hilo

    //nos creamos un public que nos va a devoler el long
    public long getContador() {
        return c;
    }

    public void pararHilo() {
        stopHilo = true;
    }

    public void run() {
        while(!stopHilo) {
            c++;
        }
    }

}
