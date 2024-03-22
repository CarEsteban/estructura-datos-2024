import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante estudiante ;
        List<String> studentNames = new ArrayList<>();

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


            System.out.println("Ingrese el tipo de hash que desea hacer: 1)Organica 2)MD5 3)SHA-1");
            selectionHash = Integer.parseInt(scanner.nextLine());
            if (selectionHash>3|selectionHash<1) {
                System.out.println("Error");
                keep = false;
            }
            hashMethod = factoryHash.getInstanceHash(selectionHash);
    


            mapWithStudents = lectorArchivo.leerArchivo("./estudiantes.json", map,hashMethod);
            

            estudiante = searchStudentbyKey(scanner,hashMethod,mapWithStudents);
            System.out.println(estudiante);


            //Unicamente faltaria mandar a llamar e imprimir el metodo saveByNationality
        }

        

    }
    /**
     * Metodo que recibe un scanner, un metodo de hash y un mapa y devuelve un estudiante buscado por su llave
     * @param scanner
     * @param hashMethod
     * @param map
     * @return
     */
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
    /**
     * Metodo que recibe un mapa y una lista de nombres de estudiantes y devuelve un mapa con los estudiantes agrupados por nacionalidad
     * @param map
     * @param studentNames
     * @return
     */
    public static AbstractMap<String, List<Estudiante>> saveByNationality(AbstractMap<String, Estudiante> map, List<String> studentNames){
        AbstractMap<String, List<Estudiante>> mapByNationality = new HashMap<>();

        for (String name : studentNames) {
            for (Map.Entry<String, Estudiante> entry : map.entrySet()) {
                Estudiante estudiante = entry.getValue();
                if (estudiante.getName().equals(name)) {
                    mapByNationality.computeIfAbsent(estudiante.getCountry(), k -> new ArrayList<>()).add(estudiante);
                    break;
                }
            }
        }

        return mapByNationality;
    }

}
