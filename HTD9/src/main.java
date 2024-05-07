import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Ruta al archivo de texto
        String filePath = "./src/texto_prueba.txt";

        try {
            // Usa TxtToStringConverter para leer el contenido del archivo en una cadena
            String text = TxtToStringConverter.readFileToString(filePath);

            // Crea una instancia de la clase Huffman con el texto leído del archivo
            Huffman huffman = new Huffman(text);

            huffman.printFrequencies(); // Este método debería existir en tu clase Huffman
/* 
            // Codifica el texto utilizando el árbol de Huffman
            String encodedText = huffman.encode();
            System.out.println("Texto codificado: " + encodedText);

            // Imprime los códigos generados para cada carácter
            huffman.printCodes();

            // Decodifica el texto codificado de regreso a su forma original
            String originalText = huffman.decode(encodedText);
            System.out.println("Texto original: " + originalText);   */
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}
