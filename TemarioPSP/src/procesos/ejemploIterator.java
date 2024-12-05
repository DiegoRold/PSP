package procesos;

import java.util.ArrayList;
import java.util.Iterator;

public class ejemploIterator {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList <String>();
        lista.add("Jose");
        lista.add("Jesus");
        lista.add("Diego");
        lista.add("Juan");
        lista.add("Sergio");

		/*for(String nombre : lista) {
			System.out.println(nombre);
			if(nombre.equals("Diego")) {
				lista.remove("Diego");
			}
		}*/     //El for no nos deja eliminar elementos de una lista

        /*El Iterator nos deja manejar la lista
         * de una mejor forma que el for,
         * en este caso for no nos deja eliminar un
         * nombre de la lista, en cambio,
         * Iterator si nos deja.*/

        Iterator<String> it = lista.iterator();
        while(it.hasNext()) {
            String nombre = it.next();
            System.out.println(it.next());
            if(nombre.equals ("Diego")) {
                it.remove();
            }

        }

        System.out.println("----------------");

        it = lista.iterator();
        while(it.hasNext()) {
            String nombre = it.next();
            System.out.println(nombre);
        }
    }
}
