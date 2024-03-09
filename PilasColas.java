import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Clase PilasColas
 * 
 * @author Cynthia Sánchez
 * @version 1.0
 */

public class PilasColas {

    /* Arreglo de cadenas */
    private static String[] simbolos = { "1", "V", "E", "45", "6", "-7", "R", "2.2", "O", "N", "0.34", "I", "-8.7", "C",
            "2345", "A", "1.2345e3" };
    /* Scanner para leer datos */
    private static Scanner sc = new Scanner(System.in);
    /* Pila de cadenas */
    private static Stack<String> pila = new Stack<>();
    /* Cola de cadenas */
    private static Queue<String> cola = new LinkedList<>();
    /* Colores */
    private static String RESET = "\u001B[0m";
    private static String RED = "\u001B[31m";
    private static String GREEN = "\u001B[32m";
    private static String YELLOW = "\u001B[33m";

    /**
     * Método principal, menú de opciones, permite interactuar con la pila y la cola
     * 
     * @param args, argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // iteramos el arreglo de cadenas
        for (String simbolo : simbolos) {
            // si el simbolo no es un número, lo agregamos a la pila
            if (!esNumero(simbolo)) {
                pila.push(simbolo);
            } else {
                // si el simbolo es un número, lo agregamos a la cola
                cola.add(simbolo);
            }
        }
        System.out.println("\n-------------------[ B I E N V E N I D O ]-------------------");
        System.out.println("\nEl siguiente arreglo: ");
        imprimirArreglo();
        System.out.println("\nSe ha dividido en una pila y una cola");
        System.out.println("La pila contiene los símbolos no numéricos");
        imprimirPila();
        System.out.println("\ny la cola los símbolos numéricos");
        imprimirCola();
        menu();
    }

    /**
     * Método que muestra el menú de opciones y permite interactuar con la pila y la
     * cola
     * utiliza un switch para seleccionar la opción deseada y hace uso del scanner
     * para leer datos
     * dependiendo de la opción seleccionada, se llama a un método específico
     */
    public static void menu() {
        System.out.println("\nMenú: Elija una opción:");
        System.out.println("1. Imprimir pila");
        System.out.println("2. Imprimir cola");
        System.out.println("3. Sacar elemento de la pila");
        System.out.println("4. Sacar elemento de la cola");
        System.out.println("5. Añadir elemento a la pila");
        System.out.println("6. Añadir elemento a la cola");
        System.out.println("7. Salir");
        String eleccion = sc.nextLine();
        switch (eleccion) {
            case "1":
                imprimirPila();
                menu();
                break;
            case "2":
                imprimirCola();
                menu();
                break;
            case "3":
                eliminarElementoPila();
                menu();
                break;
            case "4":
                eliminarElementoCola();
                menu();
                break;
            case "5":
                addElementoPila();
                menu();
                break;
            case "6":
                addElementoCola();
                menu();
                break;
            case "7":
                System.out.println("Adiós! :(");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida, intente de nuevo.");
                menu();
                break;
        }
    }

    /**
     * Método que imprime la pila
     */
    public static void imprimirPila() {
        String cadena = "";
        for (String simbolo : pila) {
            cadena += simbolo + " ";
        }
        System.out.println(GREEN + "\nPila -> " + cadena + RESET);
    }

    /**
     * Método que imprime la cola
     */
    public static void imprimirCola() {
        String cadena = "";
        for (String simbolo : cola) {
            cadena += simbolo + " ";
        }
        System.out.println(YELLOW + "\nCola -> " + cadena + RESET);
    }

    /**
     * Método que imprime el arreglo
     */
    private static void imprimirArreglo() {
        String cadena = "\n";
        for (int i = 0; i < simbolos.length - 1; i++) {
            cadena += simbolos[i] + ", ";
        }
        cadena += simbolos[simbolos.length - 1];
        System.out.println(cadena);
    }

    /**
     * Método que verifica si un símbolo es un número
     * 
     * @param simbolo, el símbolo a verificar
     * @return true si es un número, false si no lo es
     */
    private static boolean esNumero(String simbolo) {
        try {
            // intentamos convertir el símbolo a un número
            Double.parseDouble(simbolo);
        } catch (Exception e) {
            // si no se puede convertir, no es un número
            return false;
        }
        return true;
    }

    /**
     * Método que añade un elemento a la pila, lee el elemento a añadir
     * y lo agrega a la pila
     */
    private static void addElementoPila() {
        System.out.println("Ingrese el elemento a añadir a la pila:");
        String agregado = sc.nextLine();
        pila.push(agregado); // push agrega un elemento a la pila
        System.out.println("Elemento añadido a la pila" + RED + " -> " + pila.peek() + RESET);
    }

    /**
     * Método que añade un elemento a la cola, lee el elemento a añadir
     * y lo agrega a la cola
     */
    private static void addElementoCola() {
        System.out.println("Ingrese el elemento a añadir a la cola:");
        String agregado = sc.nextLine();
        cola.add(agregado); // add agrega un elemento a la cola
        System.out.println("Elemento añadido a la cola" + RED + " -> " + agregado + RESET);
    }

    /**
     * Método que elimina un elemento de la pila, saca el último elemento
     * que se agregó a la pila.
     */
    private static void eliminarElementoPila() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Cuando sacamos un número de la pila sacamos el último elemento que se agregó");
        if (!pila.isEmpty()) {
            // pop saca el último elemento que se agregó a la pila
            System.out.println("Elemento sacado de la pila: " + RED + pila.pop() + RESET);
            imprimirPila();
        } else {
            System.out.println("La pila está vacía");
        }
        System.out.println("----------------------------------------------------------------------------");
    }

    /**
     * Método que elimina un elemento de la cola, saca el primer elemento
     * que se agregó a la cola.
     */
    private static void eliminarElementoCola() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Cuando sacamos un número de la cola sacamos el primer elemento que se agregó");
        if (!cola.isEmpty()) {
            // poll saca el primer elemento que se agregó a la cola
            System.out.println("Elemento sacado de la cola: " + RED + cola.poll() + RESET);
            imprimirCola();
        } else {
            System.out.println("La cola está vacía");
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}