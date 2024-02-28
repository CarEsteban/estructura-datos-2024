import java.util.ArrayList;

/**
 * Clase Calculator que implementa la interfaz ICalculator.
 * Proporciona métodos para realizar operaciones matemáticas básicas.
 */
public class Calculator implements ICalculator {

    /**
     * Suma dos números enteros.
     * 
     * @param n1 El primer número a sumar.
     * @param n2 El segundo número a sumar.
     * @return La suma de n1 y n2.
     */
    @Override
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    /**
     * Resta dos números enteros.
     * 
     * @param n1 El número del que se resta.
     * @param n2 El número a restar.
     * @return La resta de n1 y n2.
     */
    @Override
    public int substraction(int n1, int n2) {
        return n1 - n2;
    }

    /**
     * Multiplica dos números enteros.
     * 
     * @param n1 El primer número a multiplicar.
     * @param n2 El segundo número a multiplicar.
     * @return El producto de n1 y n2.
     */
    @Override
    public int multiplication(int n1, int n2) {
        return n1 * n2;
    }

    /**
     * Divide dos números enteros.
     * 
     * @param n1 El dividendo.
     * @param n2 El divisor.
     * @return El cociente de n1 y n2.
     * @throws Exception Si n2 es 0.
     */
    @Override
    public int division(int n1, int n2) throws Exception {
        return n1 / n2;
    }

    /**
     * Calcula el residuo de la división de dos números enteros.
     * 
     * @param n1 El dividendo.
     * @param n2 El divisor.
     * @return El residuo de la división de n1 y n2.
     * @throws Exception Si n2 es 0.
     */
    @Override
    public int residue(int n1, int n2) throws Exception {
        return n1 % n2;
    }

    /**
     * Lee una cadena de caracteres y la convierte en una lista de operadores y
     * operandos.
     * 
     * @param CharactersString La cadena de caracteres a convertir.
     * @return Una lista de operadores y operandos.
     * @throws Exception Si la cadena de caracteres no puede ser convertida.
     */
    @Override
    public ArrayList<String> read(String CharactersString) throws Exception {
        ArrayList<String> operatorAndOperand = new ArrayList<String>();
        String[] partes = CharactersString.split(" ");

        for (String parte : partes) {
            operatorAndOperand.add(parte);
        }

        return operatorAndOperand;
    }

    /**
     * Resuelve una lista de operadores y operandos.
     * 
     * @param elements La lista de operadores y operandos a resolver.
     * @return El resultado de la operación.
     * @throws Exception Si la lista de operadores y operandos no puede ser
     *                   resuelta.
     */
    @Override
    public int solve(ArrayList<String> elements) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'result'");
    }
}