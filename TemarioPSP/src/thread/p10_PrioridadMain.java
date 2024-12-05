package thread;

public class p10_PrioridadMain {

    public static void main(String[] args) {
    //creamos 3 hilos
    p10_PrioridadHilo h1 = new p10_PrioridadHilo();
    p10_PrioridadHilo h2 = new p10_PrioridadHilo();
    p10_PrioridadHilo h3 = new p10_PrioridadHilo();

    //les damos la prioridad

		/* UNA FORMA MENOS EFICAZ DE DAR PRIORIDAD
		h1.setPriority(5); //media prioridad
		h2.setPriority(10); //máxima prioridad
		h3.setPriority(1); //mínima prioridad
		*/

    //OTRA FORMA DE DAR  LA PRIORIDAD DE FORMA MAS EFICAZ

		h1.setPriority(Thread.NORM_PRIORITY); //media prioridad
		h2.setPriority(Thread.MAX_PRIORITY); //máxima prioridad
		h3.setPriority(Thread.MIN_PRIORITY); //mínima prioridad


    //lanzamos las prioridades
		h1.start();
		h2.start();
		h3.start();

    //como hacer dormir una prioridad
		try

    {
        Thread.sleep(10000);
    } catch(
    InterruptedException e)

    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } //funciona en milisegundos


    //parar los hilos
		h1.pararHilo();
		h2.pararHilo();
		h3.pararHilo();


		System.out.println("Prioridad máxima: "+h2.getContador());
		System.out.println("Prioridad normal: "+h1.getContador());
		System.out.println("Prioridad mínima: "+h3.getContador());


    }
}

