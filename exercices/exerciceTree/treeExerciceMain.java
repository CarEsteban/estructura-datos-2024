package exerciceTree;

import java.util.Comparator;
import java.util.Scanner;

public class treeExerciceMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<String> placaComparator = new PlacaComparator();
        ITree<String, Automovil> binaryTree = new BinarySearchTree<>(placaComparator);
        String marca, linea, placa;
        int modelo;
        double precio;

        System.out.println("Bienvenido al sistema de automóviles");
        while (true) {
            System.out.println("Ingrese la placa del automóvil o escriba SALIR para buscar el automovil:");
            placa = scanner.nextLine();
            if (placa.equalsIgnoreCase("SALIR")) break;

            System.out.println("Ingrese la marca del automóvil:");
            marca = scanner.nextLine();

            System.out.println("Ingrese el modelo del automóvil (año):");
            modelo = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el precio del automóvil:");
            precio = Double.parseDouble(scanner.nextLine());

            System.out.println("Ingrese la línea del automóvil:");
            linea = scanner.nextLine();

            binaryTree.insert(placa, new Automovil(marca, modelo, precio, linea, placa));
        }

        System.out.println("Ingrese la placa del automóvil a buscar:");
        placa = scanner.nextLine();
        Automovil autoBuscado = binaryTree.find(placa);
        if (autoBuscado != null) {
            System.out.println("Automóvil encontrado: " + autoBuscado);
        } else {
            System.out.println("El automóvil no existe.");
        }

        scanner.close();
    }
}
