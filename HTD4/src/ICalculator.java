/**
 * @param <E> tipo de elemento en la lista
 */
import java.util.ArrayList;

/**
 * Esta interfaz define las operaciones básicas de una calculadora.
 */
public interface ICalculator {
    /**
     * Realiza la suma de dos números enteros.
     * @param n1 El primer número entero.
     * @param n2 El segundo número entero.
     * @return La suma de los dos números enteros.
     */
    public int add(int n1, int n2);

    /**
     * Realiza la resta de dos números enteros.
     * @param n1 El primer número entero.
     * @param n2 El segundo número entero.
     * @return La resta de los dos números enteros.
     */
    public int substraction(int n1, int n2);

    /**
     * Realiza la multiplicación de dos números enteros.
     * @param n1 El primer número entero.
     * @param n2 El segundo número entero.
     * @return La multiplicación de los dos números enteros.
     */
    public int multiplication(int n1, int n2);

    /**
     * Realiza la división de dos números enteros.
     * @param n1 El primer número entero.
     * @param n2 El segundo número entero.
     * @return El resultado de la división de los dos números enteros.
     * @throws Exception Si se intenta dividir entre cero.
     */
    public int division(int n1, int n2) throws Exception;

    /**
     * Calcula el residuo (módulo) de dos números enteros.
     * @param n1 El primer número entero.
     * @param n2 El segundo número entero.
     * @return El residuo (módulo) de los dos números enteros.
     * @throws Exception Si se intenta calcular el residuo con cero.
     */
    public int residue(int n1, int n2) throws Exception;

    /**
     * Lee una cadena de caracteres y la convierte en una lista de elementos.
     * @param CharactersString La cadena de caracteres a leer.
     * @return Una lista de elementos obtenidos de la cadena de caracteres.
     * @throws Exception Si ocurre un error durante la lectura.
     */
    public ArrayList<String> read(String CharactersString) throws Exception;

    /**
     * Resuelve una lista de elementos y devuelve el resultado.
     * @param elements La lista de elementos a resolver.
     * @return El resultado de la resolución de la lista de elementos.
     * @throws Exception Si ocurre un error durante la resolución.
     */
    public int solve(ArrayList<String> elements) throws Exception;
}
