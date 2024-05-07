
// Clase base abstracta Node que representa un nodo genérico en el árbol de Huffman
/**
 * The abstract Node class represents a node in a data structure.
 * It provides a common base for different types of nodes.
 */
abstract class Node implements Comparable<Node> {
    private final int frequency;

    /**
     * Constructs a Node object with the given frequency.
     *
     * @param frequency the frequency of the node
     */
    public Node(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Returns the frequency of the node.
     *
     * @return the frequency of the node
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Compares this node with the specified node for order.
     * Returns a negative integer, zero, or a positive integer
     * as this node is less than, equal to, or greater than
     * the specified node based on their frequencies.
     *
     * @param node the node to be compared
     * @return a negative integer, zero, or a positive integer
     *         as this node is less than, equal to, or greater than
     *         the specified node
     */
    @Override
    public int compareTo(Node node) {
        return Integer.compare(frequency, node.getFrequency());
    }
}