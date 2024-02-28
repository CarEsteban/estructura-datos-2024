import java.util.Scanner;

public class Driver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de estructura de datos:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int opc = scanner.nextInt();
        IStack<Character> stack;

        switch (opc) {
            case 1:
                stack = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST);
                AplicacionInfixAPostfix(stack);
                break;
            case 2:
                stack = StackFactory.createStack(StackFactory.StackType.VECTOR);
                AplicacionInfixAPostfix(stack);   
                break;
            case 3:
                System.out.println("Seleccione el tipo de lista:");
                System.out.println("1. Simple");
                System.out.println("2. Doble");

                int listChoice = scanner.nextInt();
                if (listChoice == 1) {
                    stack = StackFactory.createStack(StackFactory.StackType.SIMPLE_LIST);
                    AplicacionInfixAPostfix(stack);
                } else if (listChoice == 2) {
                    stack = StackFactory.createStack(StackFactory.StackType.DOUBLE_LIST);
                    AplicacionInfixAPostfix(stack);
                } else {
                    throw new IllegalArgumentException("Tipo de lista no válido.");
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo de estructura de datos no válido.");
        }


    }

    //aqui crear la logica del infix a profix
    //para poder aplicarlo despues que se instancia cada data structure
    public static void AplicacionInfixAPostfix(IStack stack){
        ShutingYard sy = new ShutingYard(stack);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresion infija:");
        String expression = scanner.nextLine();
        sy.parseExpression(expression);
        System.out.println("Expresion postfija: " + sy.output());
        scanner.close();
    }
}
