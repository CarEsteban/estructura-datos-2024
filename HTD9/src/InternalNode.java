// Clase InternalNode que representa un nodo interno con hijos izquierdo y derecho
class InternalNode extends Node {
    private final Node leftNode;
    private final Node rightNode;

    public InternalNode(Node leftNode, Node rightNode) {
        super(leftNode.getFrequency() + rightNode.getFrequency());
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
}