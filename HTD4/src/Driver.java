import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Driver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de estructura de datos:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int opc = scanner.nextInt();
        IStack<Character> stackChar = null; // Para manejar la conversión de infix a postfix
        IStack<String> stackString = null; // Para evaluar la expresión postfix

        // Seleccionar la implementación de stack basada en la elección del usuario
        switch (opc) {
            case 1:
                stackChar = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST);
                stackString = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST);
                break;
            case 2:
                stackChar = StackFactory.createStack(StackFactory.StackType.VECTOR);
                stackString = StackFactory.createStack(StackFactory.StackType.VECTOR);
                break;
            case 3:
                System.out.println("Seleccione el tipo de lista:");
                System.out.println("1. Simple");
                System.out.println("2. Doble");

                int listChoice = scanner.nextInt();
                if (listChoice == 1) {
                    stackChar = StackFactory.createStack(StackFactory.StackType.SIMPLE_LIST);
                    stackString = StackFactory.createStack(StackFactory.StackType.SIMPLE_LIST);
                } else if (listChoice == 2) {
                    stackChar = StackFactory.createStack(StackFactory.StackType.DOUBLE_LIST);
                    stackString = StackFactory.createStack(StackFactory.StackType.DOUBLE_LIST);
                } else {
                    throw new IllegalArgumentException("Tipo de lista no válido.");
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo de estructura de datos no válido.");
        }

        ICalculator calculator = new Calculator();

        // Convertir de infix a postfix usando stackChar
        String postfixExpression = AplicacionInfixAPostfix(stackChar);
        // Evaluar la expresión postfix usando stackString
        try {
            int resultado = evaluatePostfixExpression(postfixExpression, calculator, stackString);
            System.out.println("El resultado es aproximadamente: " + resultado);
        } catch (Exception e) {
            System.err.println("Error al evaluar la expresión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String AplicacionInfixAPostfix(IStack<Character> stack) {
        ShutingYard sy = new ShutingYard(stack);
        InputStream inputStream = Driver.class.getResourceAsStream("/datos.txt");
        if (inputStream == null) {
            throw new IllegalArgumentException("El archivo datos.txt no se encontró en el classpath");
        }
        Scanner scanner = new Scanner(inputStream);
        StringBuilder postfixExpressions = new StringBuilder();
        while (scanner.hasNextLine()) {
            String expression = scanner.nextLine();
            System.out.println("Leyendo expresión infija del archivo: " + expression);
            sy.parseExpression(expression);
            postfixExpressions.append(sy.output()).append('\n');
            System.out.println("Expresión postfija: " + sy.output());
        }
        scanner.close();
        return postfixExpressions.toString().trim(); // Usa trim() para eliminar el espacio final si es necesario
    }

    public static int evaluatePostfixExpression(String postfixExpression, ICalculator calculator, IStack<String> stack) throws Exception {
        int result = 0;
    
        for (String elemento : calculator.read(postfixExpression)) {
            if (elemento.matches("\\d+")) {
                stack.push(elemento);
            } else {
                int n2 = Integer.parseInt(stack.pop());
                int n1 = Integer.parseInt(stack.pop());
                
                switch (elemento) {
                    case "+":
                        result = calculator.add(n1, n2);
                        break;
                    case "-":
                        result = calculator.substraction(n1, n2);
                        break;
                    case "*":
                        result = calculator.multiplication(n1, n2);
                        break;
                    case "/":
                        result = calculator.division(n1, n2);
                        break;
                    case "%":
                        result = calculator.residue(n1, n2);
                        break;
                    default:
                        throw new IllegalArgumentException("Operador desconocido: " + elemento);
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
}
