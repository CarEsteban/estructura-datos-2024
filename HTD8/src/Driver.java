import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Driver{
    public static void main(String[] args) {
        String fileName = "./src/files/procesos.txt";
        ComparadorNumeros<Integer> comparadorNumeros = new ComparadorNumeros<Integer>();
        HeapUsingIterativeBinaryTree<Integer, Proceso> tipoArbol = new HeapUsingIterativeBinaryTree<>(comparadorNumeros);
        PriorityQueue<Proceso> arbolPriorityQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getPrioridad(), p2.getPrioridad()));


        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de árbol que desea usar:");
        System.out.println("1. Heap");
        System.out.println("2. Priority Queue");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante


        switch (opcion) {
            case 1:
                leerEIngresarArchivo(fileName, tipoArbol);
                mostrarProcesosEnOrden(tipoArbol);
                break;
            case 2:
                leerEIngresarArchivoPriority(fileName, arbolPriorityQueue);
                mostrarProcesosEnOrdenPriority(arbolPriorityQueue);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

    }

    /**
     * Metodo que lee un archivo y lo ingresa a un HeapUsingIterativeBinaryTree
     * @param fileName
     * @param tipoDeArbol
     * @return HeapUsingIterativeBinaryTree<Integer, Proceso>
     */
 
    public static HeapUsingIterativeBinaryTree<Integer, Proceso> leerEIngresarArchivo(String fileName, HeapUsingIterativeBinaryTree<Integer, Proceso> tipoDeArbol) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en partes basado en ","
                String[] partes = line.split(",");
                if (partes.length == 3) {
                    // Crear una nueva instancia de Proceso
                    Proceso proceso = new Proceso(partes[0], partes[1], Integer.parseInt(partes[2]));
                    // Insertar el proceso en el árbol con su prioridad como clave
                    tipoDeArbol.Insert(proceso.getPrioridad(), proceso);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Devolver el árbol poblado
        return tipoDeArbol;
    }
    /**
     * Metodo que muestra los procesos en orden usando HeapUsingIterativeBinaryTree
     * @param tipoArbol
     */
    public static void mostrarProcesosEnOrden(HeapUsingIterativeBinaryTree<Integer, Proceso> tipoArbol) {
        while (!tipoArbol.isEmpty()) {
            Proceso proceso = tipoArbol.remove(); 
            System.out.println(proceso.toString());
        }
    }
    /**
     * Metodo que lee un archivo y lo ingresa a un PriorityQueue
     * @param fileName
     * @param queue
     */
    public static void leerEIngresarArchivoPriority(String fileName, PriorityQueue<Proceso> queue) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Dividir la línea en partes basado en ","
                String[] partes = line.split(",");
                if (partes.length == 3) {
                    // Crear una nueva instancia de Proceso
                    Proceso proceso = new Proceso(partes[0], partes[1], Integer.parseInt(partes[2]));
                    // Insertar el proceso en la cola con su prioridad como clave
                    queue.offer(proceso);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Metodo que muestra los procesos en orden usando PriorityQueue
     * @param queue
     */
    public static void mostrarProcesosEnOrdenPriority(PriorityQueue<Proceso> queue) {
        while (!queue.isEmpty()) {
            Proceso proceso = queue.poll(); // Extraer el elemento con mayor prioridad
            System.out.println(proceso);
        }
    }

}