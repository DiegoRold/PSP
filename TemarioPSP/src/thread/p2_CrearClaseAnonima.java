package thread;

public class p2_CrearClaseAnonima {

    public static void main(String[] args) {

        Runnable miRunnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("Hilo corriendo");
            }
        };
//		Thread thread = new Thread(miRunnable);
//		thread.start();

        new Thread(miRunnable).start(); //lo mismo que la linea anterior pero lo mismo y más corto.

    }
}
