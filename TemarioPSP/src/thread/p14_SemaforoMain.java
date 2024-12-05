package thread;

public class p14_SemaforoMain {

    public static void main(String[] args) throws InterruptedException {

        p14_Semaforo almacen = new p14_Semaforo();

        Thread productor1 = new Thread(()->{
            for(int i=0; 1<20; i ++) {

                try {
                    almacen.producir("Producir1");
                }catch(InterruptedException e) {

                    e.printStackTrace();
                }
            }
        });
        Thread Consumidor1 = new Thread(()->{
            for(int i=0; 1<10; i ++) {

                try {
                    almacen.producir("Consumidor1");
                }catch(InterruptedException e) {

                    e.printStackTrace();
                }
            }
        });
        Thread Consumidor2 = new Thread(()->{
            for(int i=0; 1<10; i ++) {

                try {
                    almacen.producir("Consumidor2");
                }catch(InterruptedException e) {

                    e.printStackTrace();
                }
            }
        });

        productor1.start();
        Consumidor1.start();
        Consumidor2.start();
        productor1.join();
        Consumidor1.join();
        Consumidor2.join();

        System.out.println("");
    }
}
