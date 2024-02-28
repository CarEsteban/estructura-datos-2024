import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de estructura de datos:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int opc = scanner.nextInt();
        IStack stack;

        switch (opc) {
            case 1:
                stack = StackFactory.createStack(StackFactory.StackType.ARRAY_LIST);
                AplicacionInfixAProfix();
                break;
            case 2:
                stack = StackFactory.createStack(StackFactory.StackType.VECTOR);
                AplicacionInfixAProfix();   
                break;
            case 3:
                System.out.println("Seleccione el tipo de lista:");
                System.out.println("1. Simple");
                System.out.println("2. Doble");

                int listChoice = scanner.nextInt();
                if (listChoice == 1) {
                    stack = StackFactory.createStack(StackFactory.StackType.SIMPLE_LIST);
                    AplicacionInfixAProfix();
                } else if (listChoice == 2) {
                    stack = StackFactory.createStack(StackFactory.StackType.DOUBLE_LIST);
                    AplicacionInfixAProfix();
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
    public static void AplicacionInfixAProfix(){

    }
}
