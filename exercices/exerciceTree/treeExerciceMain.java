package exerciceTree;

import java.util.Comparator;
import java.util.Scanner;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class treeExerciceMain {
    public static void main(String[] args) {
        IComparator comparator = new Comparator();
        ITree<Integer, Automovil> binaryTree = new BinarySearchTree<>(comparator);
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);
        String marca, linea, resp;
        int modelo,i;
        double precio;

        System.out.println("Bienvenido al sistema de automoviles");
        while (continuar) {
            // Solicita al usuario que ingrese la marca del automóvil
            System.out.println("Ingrese la marca del automóvil:");
            marca = scanner.nextLine();
            
            // Solicita al usuario que ingrese el modelo del automóvil (como un número entero)
            System.out.println("Ingrese el modelo del automóvil (año):");
            modelo = scanner.nextInt();scanner.nextLine();
            
            // Solicita al usuario que ingrese el precio del automóvil
            System.out.println("Ingrese el precio del automóvil:");
            precio = scanner.nextDouble();scanner.nextLine();
        
            // Corrige el salto de línea después de leer un double
            scanner.nextLine();
            
            // Solicita al usuario que ingrese la línea del automóvil
            System.out.println("Ingrese la línea del automóvil:");
            linea = scanner.nextLine();


            System.out.print("Desea ingresar otro automovil?");
            resp = scanner.nextLine();

            if(resp.equals("salir")){
                continuar=false;
            }
            
            i++;

            binaryTree.insert(i,Automovil(marca,modelo,precio,linea));

        }   


    }
}
