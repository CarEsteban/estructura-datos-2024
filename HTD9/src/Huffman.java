import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Clase Huffman con todas las funcionalidades necesarias
public class Huffman {
    private Node root;
    private final String text;
    private Map<Character, Integer> charFrequencies;
    private final Map<Character, String> huffmanCodes;
    private Map<Character, Integer> frequencyMap;

    public Huffman(String text) {
        this.text = text;
        fillCharFrequenciesMap();
        huffmanCodes = new HashMap<>();
        buildHuffmanTree();
        buildHuffmanCodes(root, "");
        this.frequencyMap = new HashMap<>();
        calculateFrequencies();
    }
    
    // Método para calcular las frecuencias de cada carácter en el texto
    private void calculateFrequencies() {
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
    }

    // Método para imprimir la tabla de frecuencias
    public void printFrequencies() {
        System.out.println("Tabla de frecuencias:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Método para construir el mapa de frecuencias de caracteres
    private void fillCharFrequenciesMap() {
        charFrequencies = new HashMap<>();
        for (char character : text.toCharArray()) {
            Integer frequency = charFrequencies.get(character);
            charFrequencies.put(character, frequency != null ? frequency + 1 : 1);
        }
    }

    // Método para construir el árbol de Huffman
    private void buildHuffmanTree() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        // Crear un nodo hoja para cada carácter y agregarlo a la cola
        for (Map.Entry<Character, Integer> entry : charFrequencies.entrySet()) {
            priorityQueue.add(new Leaf(entry.getKey(), entry.getValue()));
        }

        // Construir el árbol hasta que quede un solo nodo (la raíz)
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node parent = new InternalNode(left, right);
            priorityQueue.add(parent);
        }

        root = priorityQueue.poll();
    }

    // Método para construir los códigos de Huffman a partir del árbol
    private void buildHuffmanCodes(Node node, String code) {
        if (node instanceof Leaf) {
            Leaf leaf = (Leaf) node;
            huffmanCodes.put(leaf.getCharacter(), code);
        } else if (node instanceof InternalNode) {
            InternalNode internalNode = (InternalNode) node;
            buildHuffmanCodes(internalNode.getLeftNode(), code + '0');
            buildHuffmanCodes(internalNode.getRightNode(), code + '1');
        }
    }

    // Método para obtener el código Huffman para cada carácter
    public Map<Character, String> getHuffmanCodes() {
        return huffmanCodes;
    }

    // Método para codificar una cadena de texto en su representación de Huffman
    public String encode() {
        StringBuilder encodedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            encodedText.append(huffmanCodes.get(character));
        }
        return encodedText.toString();
    }

    // Método para decodificar una cadena codificada a texto original usando el árbol de Huffman
    public String decode(String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        Node current = root;
        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                current = ((InternalNode) current).getLeftNode();
            } else {
                current = ((InternalNode) current).getRightNode();
            }

            if (current instanceof Leaf) {
                decodedText.append(((Leaf) current).getCharacter());
                current = root;
            }
        }
        return decodedText.toString();
    }

    // Método para imprimir los códigos de Huffman de cada carácter
    public void printCodes() {
        huffmanCodes.forEach((character, code) -> System.out.println(character + ": " + code));
    }
}