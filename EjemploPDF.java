import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Clase EjemploPDF, clase que muestra el uso de pilas y colas
 * usada como ejemplo en el PDF
 * @author Cynthia Sánchez
 * @version 1.0
 */
public class EjemploPDF {
    /* Pila de cadenas */
    private static Stack<Integer> pila = new Stack<>();
    /* Cola de cadenas */
    private static Queue<Integer> cola = new LinkedList<>();
     /* Colores */
     private static String RESET = "\u001B[0m";
     private static String GREEN = "\u001B[32m";
     private static String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // agregamos elementos a la pila y a la cola
            pila.push(i);
            cola.add(i);
        }
        imprimirPila();
        imprimirCola();
        System.out.println("\nUso de peek() para ver el elemento que está en la cima de la pila y el frente de la cola");
        System.out.println(GREEN + "\nElemento en la cima de la pila: " + pila.peek() + RESET);
        System.out.println(YELLOW + "\nElemento en el frente de la cola: " + cola.peek() + RESET);
        System.out.println("\nSi imprimimos la pila y la cola, vemos que no se eliminan los elementos");
        imprimirPila();
        imprimirCola();
        System.out.println("\nVe el orden en el que se eliminan los elementos de la pila y de la cola");
        eliminarElementos();
    }

    /**
     * Método que va eliminando elementos de la pila y de la cola
     * y los imprime en consola para observar el orden en el que se eliminan
     * y ver el cambio en la pila y la cola
     */
    private static void eliminarElementos() {
        String eliminadosPila = "";
        String eliminadosCola = "";
        for (int i = 0; i < 10; i++) {
            // eliminamos elementos de la pila y de la cola
            eliminadosPila += pila.pop() + " ";
            eliminadosCola += cola.poll() + " ";
        }
        // las cadenas representan los elementos eliminados y el orden en el que se eliminaron
        System.out.println(GREEN + "\nElementos eliminados de la pila: " + eliminadosPila + RESET);
        System.out.println(YELLOW + "\nElementos eliminados de la cola: " + eliminadosCola + RESET+"\n");
    }

    /**
     * Método que imprime la pila
     */
    private static void imprimirPila() {
        String cadena = "";
        for (int simbolo : pila) {
            cadena += simbolo + " ";
        }
        System.out.println(GREEN + "\nPila -> " + cadena + RESET);
    }

    /**
     * Método que imprime la cola
     */
    private static void imprimirCola() {
        String cadena = "";
        for (int simbolo : cola) {
            cadena += simbolo + " ";
        }
        System.out.println(YELLOW + "\nCola -> " + cadena + RESET);
    }
}
