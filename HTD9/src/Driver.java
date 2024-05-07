import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1 - Comprimir");
            System.out.println("2 - Descomprimir");
            System.out.println("0 - Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    // Comprimir
                    try {
                        // Convertir el archivo de texto a una cadena
                        TxtToStringConverter converter = new TxtToStringConverter();
                        String text = converter.readFileToString("./src/texto_prueba.txt");
                        
                        // Codificar el texto usando Huffman
                        Huffman huffman = new Huffman(text);
                        String huffmanCode = huffman.encode();
                        
                        // Convertir el código Huffman a un array de bytes
                        List<Byte> byteList = new ArrayList<>();
                        
                        for (int i = 0; i < huffmanCode.length(); i += 8) {
                            String byteString = huffmanCode.substring(i, Math.min(i + 8, huffmanCode.length()));
                            // Asegurar que tenga 8 bits agregando ceros al final si es necesario
                            while (byteString.length() < 8) {
                                byteString += "0";
                            }
                            // Convertir el string de bits a un byte
                            int byteValue = Integer.parseInt(byteString, 2);
                            // Restar 128
                            byteValue -= 128;
                            // Agregar a la lista
                            byteList.add((byte) byteValue);
                        }

                        // Escribir los bytes a un archivo binario .huff
                        try (FileOutputStream fos = new FileOutputStream("./src/output.huff")) {
                            for (byte b : byteList) {
                                fos.write(b);
                            }
                        }

                        // Generar archivo .tree con las frecuencias
                        generateTreeFile(huffman.getFrequencies(), "./src/output.tree");

                        System.out.println("Archivo .huff creado con éxito.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    // Descomprimir
                    File huffFile = new File("./src/output.huff");
                    if (!huffFile.exists()) {
                        System.out.println("No se encontró el archivo 'output.huff'. Por favor, comprime un archivo primero.");
                    } else {
                        try {
                            // Leer el archivo binario
                            FileInputStream fis = new FileInputStream(huffFile);
                            List<Integer> bytesList = new ArrayList<>();
                            int value;
                            while ((value = fis.read()) != -1) {
                                bytesList.add(value + 128);
                            }
                            fis.close();

                            // Convertir bytes a cadena de bits
                            StringBuilder bitString = new StringBuilder();
                            for (int byteValue : bytesList) {
                                String byteBits = String.format("%8s", Integer.toBinaryString(byteValue & 0xFF)).replace(' ', '0');
                                bitString.append(byteBits);
                            }

                            // Convertir el archivo de texto a una cadena
                            TxtToStringConverter converter = new TxtToStringConverter();
                            String text = converter.readFileToString("./src/texto_prueba.txt");
                        
                            // Decodificar el texto original con el método de Huffman
                            Huffman huffman = new Huffman(text);
                            String originalText = huffman.decode(bitString.toString());

                            // Mostrar el texto original
                            System.out.println("Texto descomprimido: ");
                            System.out.println(originalText);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case 3:
                    int frecuencias[] = huffman.getFrequencies();
                    // Mostrar tabla de frecuencias
                    generateTreeFile(frecuencias, "./src/output.tree");
                    
                
                case 0:
                    // Salir del programa
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Programa terminado.");
    }

    private static void generateTreeFile(int[] frequencies, String filePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (int i = 0; i < frequencies.length; i++) {
                if (frequencies[i] > 0) {
                    writer.println((char) i + ": " + frequencies[i]);
                }
            }
        }
    }
}
