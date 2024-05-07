// Clase InternalNode que representa un nodo interno con hijos izquierdo y derecho
/**
 * Represents an internal node in a binary tree.
 * An internal node contains references to its left and right child nodes.
 */
class InternalNode extends Node {
    private final Node leftNode;
    private final Node rightNode;

    /**
     * Constructs a new InternalNode object with the given left and right child nodes.
     *
     * @param leftNode  the left child node
     * @param rightNode the right child node
     */
    public InternalNode(Node leftNode, Node rightNode) {
        super(leftNode.getFrequency() + rightNode.getFrequency());
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * Returns the left child node of this internal node.
     *
     * @return the left child node
     */
    public Node getLeftNode() {
        return leftNode;
    }

    /**
     * Returns the right child node of this internal node.
     *
     * @return the right child node
     */
    public Node getRightNode() {
        return rightNode;
    }
}