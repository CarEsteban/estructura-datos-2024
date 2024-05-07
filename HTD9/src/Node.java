
// Clase base abstracta Node que representa un nodo genérico en el árbol de Huffman
abstract class Node implements Comparable<Node> {
    private final int frequency;

    public Node(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(frequency, node.getFrequency());
    }
}