import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws IOException {

        //Declaración de variables
        String fileName = "./src/diccionario.txt", idiomaEntrada, idiomaSalida;
        ArrayList<ArrayList<String>> dictionary;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> textoEntrada;

        IWalk<ArrayList<String>> printWalk = new PrintWalk();

        //Comprobar la ruta del directorio 
        //String fileName = "C:\\Users\\esteb\\OneDrive\\Documentos\\UNIVERSIDAD\\DATOS\\estructura-datos-2024\\HTD7\\src\\diccionario.txt";
        //String directorioActual = System.getProperty("user.dir");

        //Creación de los arboles
        ITree<String, ArrayList<String>> englishTree = new BinarySearchTree<>(Comparator.comparing(String::toString));
        ITree<String, ArrayList<String>> spanishTree = new BinarySearchTree<>(Comparator.comparing(String::toString));
        ITree<String, ArrayList<String>> frenchTree = new BinarySearchTree<>(Comparator.comparing(String::toString));

        //cargar el archivo a un diccionario
        dictionary = loadDictionary(fileName);
        
        //insertar los archivos a los árboles
        for (int i = 0; i < dictionary.size(); i++) {
            englishTree.insert(dictionary.get(i).get(0), dictionary.get(i));
            spanishTree.insert(dictionary.get(i).get(1), dictionary.get(i));
            frenchTree.insert(dictionary.get(i).get(2), dictionary.get(i));
        }

        //Comprobar si los elemenos se ordenan respecto al idioma
        //frenchTree.InOrderWalk(printWalk);

        //leer el archivo del texto
        textoEntrada = loadTexto(fileNameTexto);


        //identificar el idioma (por ahora, el usuario lo coloca)



        System.out.println("Ingrese el idioma del texto");
        idiomaEntrada = scanner.nextLine();
        System.out.println("Ingrese el idioma de salida");
        idiomaSalida = scanner.nextLine();






        scanner.close();

    }

    public static ArrayList<ArrayList<String>> loadDictionary(String fileName) throws IOException {
        ArrayList<ArrayList<String>> dictionary = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String linea = reader.readLine();
            while (linea != null) {
                ArrayList<String> lineArray = new ArrayList<>(Arrays.asList(linea.split(","))); // Asumiendo coma como delimitador
                dictionary.add(lineArray);
                linea = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return dictionary;
    }
}
