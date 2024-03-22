import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Factories
        FactoryMaps<String, Estudiante> factoryMaps = new FactoryMaps<>();
        FactoryHash factoryHash = new FactoryHash();

        LectorArchivo lectorArchivo = new LectorArchivo(factoryMaps);

        // Instances
        AbstractMap<String, Estudiante> map, mapWithStudents;
        IHash hashMethod;

        System.out.println("Ingrese que tipo de mapa desea trabajar: 1) HashMap 2) TreeMap 3) LinkedHashMap");
        int selectionMap = Integer.parseInt(scanner.nextLine());
        if (selectionMap > 3 || selectionMap < 1) {
            System.out.println("Error en la selección del tipo de mapa.");
        
        }
        map = factoryMaps.getInstanceMap(selectionMap);

        System.out.println("Ingrese el tipo de hash que desea hacer: 1) Orgánica 2) MD5 3) SHA-1");
        int selectionHash = Integer.parseInt(scanner.nextLine());
        if (selectionHash > 3 || selectionHash < 1) {
            System.out.println("Error en la selección del tipo de hash.");
        
        }
        hashMethod = factoryHash.getInstanceHash(selectionHash);

        mapWithStudents = lectorArchivo.leerArchivo("./estudiantes.json", map, hashMethod);

        boolean keep = true;
        while (keep) {
            System.out.println("Seleccione una opción: \n1. Buscar estudiante por nombre\n2. Buscar estudiantes por nacionalidad\n3. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea nueva restante

            switch (choice) {
                case 1:
                    Estudiante estudiante = searchStudentbyKey(scanner, hashMethod, mapWithStudents);
                    if (estudiante != null) {
                        System.out.println(estudiante);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 2:
                    searchStudentbyNati(scanner, mapWithStudents);
                    break;
                case 3:
                    keep = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
    /**
     * Metodo que recibe un scanner, un metodo de hash y un mapa y devuelve un estudiante buscado por su llave
     * @param scanner
     * @param hashMethod
     * @param map
     * @return searchStudent
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
    /***
     * Metodo que recibe un scanner y un mapa y busca estudiantes por nacionalidad
     * @param scanner
     * @param map
     */
    public static void searchStudentbyNati(Scanner scanner, AbstractMap<String, Estudiante> map) {
        System.out.println("Ingrese la nacionalidad de los estudiantes a buscar:");
        String nationality = scanner.nextLine();
        List<String> studentNames = new ArrayList<>();
    
        for (Map.Entry<String, Estudiante> entry : map.entrySet()) {
            Estudiante estudiante = entry.getValue();
            if (estudiante.getCountry().equalsIgnoreCase(nationality)) {
                studentNames.add(estudiante.getName());
            }
        }

        if (studentNames.isEmpty()) {
            System.out.println("No se encontraron estudiantes de la nacionalidad " + nationality);
            return;
        }
    
        AbstractMap<String, List<Estudiante>> studentsByNationality = saveByNationality(map, studentNames);
    
        studentsByNationality.forEach((key, value) -> {
            System.out.println("Nacionalidad: " + key);
            value.forEach(student -> System.out.println("- " + student.getName()));
        });
    }
    /**
     * Metodo que recibe un mapa y una lista de nombres de estudiantes y devuelve un mapa con los estudiantes agrupados por nacionalidad
     * @param map
     * @param studentNames
     * @return mapByNationality
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

        return mapByNationality; //Retorna un mapa con los estudiantes que unicamente el usuario ingreso, agrupados en su nacionalidad.
    }

}