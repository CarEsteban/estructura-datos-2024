import java.util.AbstractMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante estudiante ;

        //factories
        FactoryMaps<String,Estudiante> factoryMaps = new FactoryMaps<>();
        FactoryHash factoryHash = new FactoryHash();

        LectorArchivo lectorArchivo = new LectorArchivo(factoryMaps);

        //instances
        AbstractMap<String,Estudiante> map,mapWithStudents;
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


            mapWithStudents = lectorArchivo.leerArchivo("./estudiantes.json", map);
            

            System.out.println("Ingrese el tipo de hash que desea hacer: 1)Organica 2)MD5 3)SHA-1");
            selectionHash = Integer.parseInt(scanner.nextLine());
            if (selectionHash>3|selectionHash<1) {
                System.out.println("Error");
                keep = false;
            }
            hashMethod = factoryHash.getInstanceHash(selectionHash);
    


            estudiante = searchStudentbyKey(scanner,hashMethod,mapWithStudents);
            System.out.println(estudiante);
    
        }

        

    }


    public static Estudiante searchStudentbyKey(Scanner scanner, IHash hashMethod, AbstractMap<String,Estudiante> map){
        String nameStudent;
        
        System.out.println("Ingrese el nombre del estudiante a buscar:");
        nameStudent = scanner.nextLine();  
        
        String hashName = hashMethod.generateHash(nameStudent);
        
        
        Estudiante searchStudent = map.get(hashName);
        if (searchStudent != null) {
            return searchStudent;
        } else {
            return null;
        }
    }

}
