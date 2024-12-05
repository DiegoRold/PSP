package ejFilosofos;

import java.util.concurrent.Semaphore;

public class ejFilosofos {

    //cantidad de filosofos
    private static final int NUM_FILOSOFOS = 5;

    //semáforos que representan los tenedores
    private static final Semaphore[] tenedores = new Semaphore[NUM_FILOSOFOS];

    public static void main(String[] args) {

        //Iniciamos los semáforos(un tenedor por filosofo)
        for(int i =0; i < NUM_FILOSOFOS; i++) {
            //cada tenedor puede ser usado por un filosofo
            tenedores[i] = new Semaphore(i);
        }

        //crear y lanzar un hilo para cada filosofo
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            final int filosofo = i;
            new Thread(() -> {
                try {
                    while (true) {
                        pensar(filosofo);
                        tomarTenedor(filosofo);
                        comer(filosofo);
                        soltarTenedor(filosofo);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Filosofo" + filosofo + " ha sido interrumpido.");
                }
            }).start();
        }
    }

    //metodo para simular los estados de cada filosofo
    private static void pensar (int filosofo) throws InterruptedException {
        System.out.println("Filosofo " + filosofo + " está pensando.");
        Thread.sleep((int) (Math.random() * 1000)); //simular tiempo de pensar
    }

    private static void tomarTenedor (int filosofo) throws InterruptedException {
        int tenedorIzquierdo = filosofo; //el tenedor izquierdo del filosofo
        int tenedorDerecho = (filosofo + 1) % NUM_FILOSOFOS; //tenedor derecho del filosofo

        //Intentar tomas ambos tenedores
        tenedores[tenedorIzquierdo].acquire();
        tenedores[tenedorDerecho].acquire();

        System.out.println("Filosofo " + filosofo + "ha tomado los tenedores " + tenedorIzquierdo + " y" + tenedorDerecho + " .");

    }

    private static void comer(int filosofo) throws InterruptedException  {
        System.out.println("Filósofo " + filosofo + " esta comiendo.");
        Thread.sleep((int) (Math.random() * 1000)); //simular tiempo de comer
    }

    private static void soltarTenedor (int filosofo) {
        int tenedorIzquierdo = filosofo;
        int tenedorDerecho = (filosofo + 1) % NUM_FILOSOFOS;

        //liberar los tenedores
        tenedores[tenedorIzquierdo].release();
        tenedores[tenedorDerecho].release();

        System.out.println("Filosofo " + filosofo + " ha soltado los tenedores " + tenedorIzquierdo + " y" + tenedorDerecho + ".");

    }
}
