package thread;

public class p5_SinExpresionLambda {

    public static void main(String[] args) {

        OperacionSuma2 suma = new Suma();
        int resultado = suma.operar(5, 4);
        System.out.println("Resultado: " + resultado);

    }
}

interface OperacionSuma2{ int operar(int a, int b);}

class Suma implements OperacionSuma2{
    public int operar(int a, int b) { return a + b;}
}

