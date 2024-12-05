package thread;

public class p4_ExpresionLambda {

    public static void main(String[] args) {

        OperacionSuma suma = (a, b) -> a + b;

        int resultado = suma.operar(5, 4);
        System.out.println("Resultado: " + resultado);
    }
}

interface OperacionSuma{ int operar(int a, int b); }

