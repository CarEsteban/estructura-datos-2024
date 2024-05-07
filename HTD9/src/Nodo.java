public class Nodo implements Comparable<Nodo> {
    // Atributos para un nodo del árbol de Huffman
    private char caracter; // El carácter asociado al nodo
    private int frecuencia; // Frecuencia del carácter en el texto
    private Nodo izquierda; // Nodo hijo izquierdo
    private Nodo derecha; // Nodo hijo derecho

    // Constructor para inicializar el nodo
    public Nodo(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        this.izquierda = null;
        this.derecha = null;
    }

    // Constructor para nodos no hoja (internos), sin carácter
    public Nodo(int frecuencia, Nodo izquierda, Nodo derecha) {
        this.caracter = '\0'; // Valor nulo para indicar que no es una hoja
        this.frecuencia = frecuencia;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    // Métodos de acceso (getters) para los atributos
    public char getCaracter() {
        return caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    // Métodos de modificación (setters) para los atributos
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    // Implementación del método compareTo para ordenar nodos según la frecuencia
    @Override
    public int compareTo(Nodo otro) {
        // Se ordena por frecuencia de menor a mayor
        return Integer.compare(this.frecuencia, otro.frecuencia);
    }

    // Método para verificar si el nodo es una hoja (no tiene hijos)
    public boolean esHoja() {
        return (izquierda == null && derecha == null);
    }
}
