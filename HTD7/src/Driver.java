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
        String fileName = "./src/diccionario.txt", oracionOriginal, oracionTraducida,palabraNueva,idiomaEntrada, idiomaSalida, fileNameTexto = "./src/texto.txt";
        ArrayList<ArrayList<String>> dictionary;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> textoEntrada,textoTraducido=new ArrayList<>();
        int opc;
        boolean continuar=true;

        IWalk<ArrayList<String>> printWalk = new PrintWalk();

        //Comprobar la ruta del directorio 
        //String fileName = "C:\\Users\\esteb\\OneDrive\\Documentos\\UNIVERSIDAD\\DATOS\\estructura-datos-2024\\HTD7\\src\\diccionario.txt";
        //String directorioActual = System.getProperty("user.dir");

        //Creación de los arboles
        ITree<String, ArrayList<String>> englishTree = new BinarySearchTree<>(Comparator.comparing(String::toString));
        ITree<String, ArrayList<String>> spanishTree = new BinarySearchTree<>(Comparator.comparing(String::toString));
        ITree<String, ArrayList<String>> frenchTree = new BinarySearchTree<>(Comparator.comparing(String::toString));
        ITree<String, ArrayList<String>> arbolUsar = null;

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
        
        
        //identificar el idioma (automaticamente)
        // Contadores para cada idioma
        int contadorIngles = 0;
        int contadorEspanol = 0;
        int contadorFrances = 0;

        for (String palabraTexto : textoEntrada) { // Iterar sobre cada palabra del texto
            for (ArrayList<String> entradaDiccionario : dictionary) { // Iterar sobre cada entrada del diccionario
                if (palabraTexto.equalsIgnoreCase(entradaDiccionario.get(0))) {
                    contadorIngles++;
                }
                if (palabraTexto.equalsIgnoreCase(entradaDiccionario.get(1))) {
                    contadorEspanol++;
                }
                if (palabraTexto.equalsIgnoreCase(entradaDiccionario.get(2))) {
                    contadorFrances++;
                }
            }
        }

        // Decidir el idioma basado en el contador más alto
        if (contadorIngles > contadorEspanol + contadorFrances) {
            idiomaEntrada="Inglés";
        } else if (contadorEspanol > contadorIngles + contadorFrances) {
            idiomaEntrada="Español";
        } else if (contadorFrances > contadorIngles + contadorEspanol) {
            idiomaEntrada="Francés";
        } else {
            idiomaEntrada="Undefined";
        }

        
        while (continuar) {
            
            System.out.println("Elija una opción:\n1)Mostrar ordenados los diccionarios\n2)Traducir texto");
            opc=scanner.nextInt();scanner.nextLine();

            switch (opc) {
                case 1:
                //el orden del array no cambia, fijarse literalmente en la columna del idioma que ahi lo ordena
                    System.out.println("------------------------------------------------");
                    System.out.println("Orden en inglés");
                    englishTree.InOrderWalk(printWalk);
                    System.out.println("------------------------------------------------");
                    System.out.println("Orden en español");
                    spanishTree.InOrderWalk(printWalk);
                    System.out.println("------------------------------------------------");
                    System.out.println("Orden en francés");
                    frenchTree.InOrderWalk(printWalk);
                    System.out.println("------------------------------------------------");



                    continuar=verMenu(scanner);

                    break;
            
                default:
                    System.out.println("Opción no existente");
                    continuar=false;
                    break;
            }
        }



        scanner.close();

    }


    public static boolean verMenu(Scanner scanner){
        int opc;
        System.out.println("Desea regresar al menú? (1=Si/2=No)");
        opc = scanner.nextInt();scanner.nextLine();
        switch (opc) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                return false;
        }
    }

    public static ArrayList<ArrayList<String>> loadDictionary(String fileName) throws IOException {
        ArrayList<ArrayList<String>> dictionary = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String linea = reader.readLine();
            while (linea != null) {
                // Divide la línea usando coma como delimitador
                String[] palabras = linea.split(",");
                ArrayList<String> lineArray = new ArrayList<>();
                // Convierte cada palabra a minúsculas antes de añadirla a lineArray
                for (String palabra : palabras) {
                    lineArray.add(palabra.toLowerCase().trim()); // También aplicamos trim() para eliminar espacios adicionales
                }
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

    
    public static ArrayList<String> loadTexto(String fileName) throws IOException {
        ArrayList<String> palabras = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String linea = reader.readLine();
            while (linea != null) {
                // Divide cada línea en palabras usando el espacio como delimitador
                String[] palabrasDeLaLinea = linea.split("\\s+");
                // Agrega todas las palabras de la línea al ArrayList, eliminando espacios al principio y convirtiendo a minúsculas
                for (String palabra : palabrasDeLaLinea) {
                    String palabraLimpia = palabra.trim().toLowerCase(); // Elimina espacios y convierte a minúsculas
                    if (!palabraLimpia.isEmpty()) { // Evita agregar cadenas vacías
                        palabras.add(palabraLimpia);
                    }
                }
                linea = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return palabras;
    }



}
