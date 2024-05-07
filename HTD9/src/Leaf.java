// Clase Leaf que representa un nodo hoja, donde se almacena un carácter y su frecuencia
class Leaf extends Node {
    private final char character;

    public Leaf(char character, int frequency) {
        super(frequency);
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
