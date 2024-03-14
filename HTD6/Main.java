import java.util.AbstractMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante estudiante ;

        //factories
        FactoryMaps<IHash,Estudiante> factoryMaps = new FactoryMaps<>();
        FactoryHash factoryHash = new FactoryHash();

        //instances
        AbstractMap<IHash,Estudiante> map;
        IHash hashMethod;

        int selectionMap,selectionHash;
        boolean keep = true;


        while (keep) {
            System.out.println("Ingrese que tipo de mapa desea trabajar: 1)HashMap 2)TreeMap 3)LinkedHashMap");
            selectionMap = Integer.parseInt(scanner.nextLine());
            if (selectionMap>3|selectionMap<1) {
                System.out.println("Error");
                keep = false;
            }
            map = factoryMaps.getInstanceMap(selectionMap);

            System.out.println("Ingrese el tipo de hash que desea hacer");
            selectionHash = Integer.parseInt(scanner.nextLine());
            if (selectionHash>3|selectionHash<1) {
                System.out.println("Error");
                keep = false;
            }
            hashMethod = factoryHash.getInstanceHash(selectionHash);
    


            estudiante = searchStudentbyKey(scanner,hashMethod,map);

    
        }

        

    }


    public static Estudiante searchStudentbyKey(Scanner scanner, IHash hashMethod, AbstractMap<IHash,Estudiante> map){
        String nameStudent;
        
        System.out.println("Ingrese el nombre del estudiante a buscar:");
        nameStudent = scanner.nextLine();
        Estudiante searchStudent = map.find(nameStudent);
        if (searchStudent != null) {
            System.out.println("Estudiante encontrado: " + searchStudent);
        } else {
            System.out.println("El estudiante no existe.");
        }




        return null;
    }

}
