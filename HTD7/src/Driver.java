/**
    Esta clase representa un programa controlador para una aplicación de traducción. Carga un diccionario de traducciones de palabras,
    permite a los usuarios elegir opciones como mostrar diccionarios ordenados o traducir texto, y proporciona funcionalidades
    para cargar diccionarios y archivos de texto.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Driver {

    /**
     * El metodo main del Driver
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     * @throws IOException Si ocurre un error de E/S mientras se leen los archivos.
     */
    public static void main(String[] args) throws IOException {

        // Declaración de variables
        String fileName = "./src/diccionario.txt", oracionOriginal, oracionTraducida,palabraNueva,idiomaEntrada, idiomaSalida, fileNameTexto = "./src/texto.txt";
        ArrayList<ArrayList<String>> dictionary;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> textoEntrada,textoTraducido=new ArrayList<>();
        int opc;
        boolean continuar=true;

        IWalk<ArrayList<String>> printWalk = new PrintWalk();

        // Cración de los arboles
        ITree<String, ArrayList<String>> englishTree = new BinarySearchTree<>(Comparator.comparing(String::toString));
        ITree<String, ArrayList<String>> spanishTree = new BinarySearchTree<>(Comparator.comparing(String::toString));
        ITree<String, ArrayList<String>> frenchTree = new BinarySearchTree<>(Comparator.comparing(String::toString));
        ITree<String, ArrayList<String>> arbolUsar = null;

        // Carga el archivo diccionario
        dictionary = loadDictionary(fileName);

        // Inserta la información a los arboles
        for (int i = 0; i < dictionary.size(); i++) {
            englishTree.insert(dictionary.get(i).get(0), dictionary.get(i));
            spanishTree.insert(dictionary.get(i).get(1), dictionary.get(i));
            frenchTree.insert(dictionary.get(i).get(2), dictionary.get(i));
        }

        // Lee el archivo de entrada
        textoEntrada = loadTexto(fileNameTexto);

        // Identifica el lenguaje automáticamente
        int contadorIngles = 0;
        int contadorEspanol = 0;
        int contadorFrances = 0;

        for (String palabraTexto : textoEntrada) {
            for (ArrayList<String> entradaDiccionario : dictionary) {
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
                    // Display sorted dictionaries
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

                case 2:
                    textoTraducido.clear();

                    if (idiomaEntrada.equals("Undefined")) {
                        System.out.println("No se reconoce el idioma de entrada");
                    }

                    System.out.println("Idioma de entrada: " + idiomaEntrada);

                    System.out.println("Ingrese el idioma de salida");
                    idiomaSalida = scanner.nextLine();


                    int idiomaIndex = -1;
                    switch(idiomaEntrada){
                        case "Inglés":
                            arbolUsar = englishTree;
                            break;
                        case "Español":
                            arbolUsar = spanishTree;
                            break;
                        case "Francés":
                            arbolUsar = frenchTree;
                            break;
                    }

                    switch (idiomaSalida) {
                        case "Ingles":
                            idiomaIndex = 0;
                            break;
                        case "Espanol":
                            idiomaIndex = 1;
                            break;
                        case "Frances":
                            idiomaIndex = 2;
                            break;
                        default:
                            System.out.println("Idioma de salida no reconocido.");
                            break;
                    }

                    for (String palabra : textoEntrada) {
                        ArrayList<String> traduccion = null;
                        traduccion = arbolUsar.find(palabra);
                        if (traduccion != null && idiomaIndex != -1) {
                            palabraNueva = traduccion.get(idiomaIndex);
                            textoTraducido.add(palabraNueva);
                        } else {
                            textoTraducido.add("'"+palabra+"'");
                        }
                    }

                    oracionOriginal = String.join(" ", textoEntrada);
                    oracionTraducida = String.join(" ", textoTraducido);

                    System.out.println( oracionOriginal);
                    System.out.println( oracionTraducida);

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

    /**
     * Muestra un mensaje al usuario preguntando si desea volver al menú principal o no.
     *
     * @param scanner El objeto Scanner utilizado para la entrada del usuario.
     * @return Verdadero si el usuario desea volver al menú principal, falso en caso contrario.
     */
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

    /**
     * Carga texto desde un archivo especificado.
     *
     * @param fileName El nombre del archivo que contiene el texto
     * @return Un ArrayList de cadenas que representan el texto
     * @throws IOException Si ocurre un error de E/S mientras se lee el archivo.
     */
    public static ArrayList<ArrayList<String>> loadDictionary(String fileName) throws IOException {
        ArrayList<ArrayList<String>> dictionary = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String linea = reader.readLine();
            while (linea != null) {
                String[] palabras = linea.split(",");
                ArrayList<String> lineArray = new ArrayList<>();
                for (String palabra : palabras) {
                    lineArray.add(palabra.toLowerCase().trim());
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

    /**
     * Carga texto desde un archivo especificado.
     *
     * @param fileName El nombre del archivo que contiene el texto
     * @return Un ArrayList de cadenas que representan el texto
     * @throws IOException Si ocurre un error de E/S mientras se lee el archivo.
     */
    public static ArrayList<String> loadTexto(String fileName) throws IOException {
        ArrayList<String> palabras = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String linea = reader.readLine();
            while (linea != null) {
                String[] palabrasDeLaLinea = linea.split("\\s+");
                for (String palabra : palabrasDeLaLinea) {
                    String palabraLimpia = palabra.trim().toLowerCase();
                    if (!palabraLimpia.isEmpty()) {
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