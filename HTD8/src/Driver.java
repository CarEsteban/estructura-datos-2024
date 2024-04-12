import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Driver{
    public static void main(String[] args) {
        String fileName = "./src/files/procesos.txt";
        ComparadorNumeros<Integer> comparadorNumeros = new ComparadorNumeros<Integer>();
        HeapUsingIterativeBinaryTree<Integer, Proceso> tipoArbol = new HeapUsingIterativeBinaryTree<>(comparadorNumeros);
        PriorityQueue<Proceso> arbolPriorityQueue = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getPrioridad(), p2.getPrioridad()));


        leerEIngresarArchivo(fileName, tipoArbol);
        mostrarProcesosEnOrden(tipoArbol);

        leerEIngresarArchivoPriority(fileName, arbolPriorityQueue);
        mostrarProcesosEnOrdenPriority(arbolPriorityQueue);



    }
    
 
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

    
    public static void mostrarProcesosEnOrden(HeapUsingIterativeBinaryTree<Integer, Proceso> tipoArbol) {
        while (!tipoArbol.isEmpty()) {
            Proceso proceso = tipoArbol.remove(); 
            System.out.println(proceso.toString());
        }
    }


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

    public static void mostrarProcesosEnOrdenPriority(PriorityQueue<Proceso> queue) {
        while (!queue.isEmpty()) {
            Proceso proceso = queue.poll(); // Extraer el elemento con mayor prioridad
            System.out.println(proceso);
        }
    }

}