public class Main {
    public static void main(String[] args) {
        // Crea una instancia de la clase Huffman con el texto a codificar
        Huffman huffman = new Huffman("hola mi hermano");

        // Codifica el texto utilizando el árbol de Huffman
        String encodedText = huffman.encode();
        System.out.println("Texto codificado: " + encodedText);

        // Imprime los códigos generados para cada carácter
        huffman.printCodes();

        // Decodifica el texto codificado de regreso a su forma original
        String originalText = huffman.decode(encodedText);
        System.out.println("Texto original: " + originalText);
    }
}
