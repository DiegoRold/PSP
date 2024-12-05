package segundoExamen;

import java.util.concurrent.Semaphore;

public class AlmazenMain {

    public static final int NUM_VEHICULOS = 3;

    public static final Semaphore[] mercancias = new Semaphore[NUM_VEHICULOS];

    public static void main(String[] args){

        //Iniciamos el semaforo
        for( int i = 1; i < NUM_VEHICULOS; i ++){
            //cada mercancia solo puede ser usado por un vehiculo
            mercancias[i] = new Semaphore(i);
        }

        //creamos el hilo para cada vehiculo
        for (int i = 1; i < NUM_VEHICULOS; i++){
            final int vehiculo = i;

            new Thread(() -> {
                try{
                    while(true){
                        esperarTurno(vehiculo);
                        cargarMercancia(vehiculo);
                        salirTerminal(vehiculo);
                        entregarMercancia(vehiculo);
                    }
                }catch (InterruptedException e) {
                    System.out.println("Vehículo " + vehiculo + "se ha interrumpido.");
                }
            }).start();


        }

        //Una vez relizada 3 entregas, se termina el programa.


    }

    //Cremaos los metodos a realizar
    //metodo para esperar el turno
    private static void esperarTurno(int vehiculo) throws InterruptedException {
        System.out.println("Vehiculo" + vehiculo + "está esperando su turno.");
        Thread.sleep((int) (Math.random() * 3000)); //simulamos el tiempo de espera
    }

    //metodo para cargar la mercancia
    private static void cargarMercancia(int vehiculo) throws InterruptedException {
        int mercancia = vehiculo; //mercancia;

        //intentar cargar la mercancia
        mercancias[mercancia].acquire();

        System.out.println("Vehiculo " + vehiculo + "carga la mercancía.");
    }

    //metodo para salir de la terminal
    private static void salirTerminal(int vehiculo) throws InterruptedException {
        Thread.sleep((int) (Math.random() * 5000)); //simulamos el tiempo de salida
        System.out.println("Vehiculo " + vehiculo + "está saliendo del almacén.");
    }

    //metodo para entregar la mercancia
    private static void entregarMercancia(int vehiculo){
        int mercancia = vehiculo;

        //intentamos dejar la mercancia
        mercancias[mercancia].release();

        System.out.println("Vehiculo " + vehiculo + "está entregando la mercancia");
    }
}
