import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option,validation;
        boolean continuar = true;
        UsuarioFactory userFactory = new UsuarioFactory(); 
        List<IUser> allUsers = new ArrayList<>();

        allUsers = loadAllUsers();

        while (continuar) {
            option = menu(scanner);
    
            switch (option) {
                case 1:
                    validation = iniciarSesion(scanner);
                    if(validation==1){
                        System.out.println("Lo siento, este usuario no existe");
                        break;
                    }
                    System.out.println("Ingresado");

                    //logica cuando se inicia sesion




                    break;
                case 2:
                    crearCuenta(scanner, userFactory,allUsers);
                    System.out.println("Cuenta creada");


                    continuar=true;
                    break;
            
                default:
                    System.out.println("no existe esta opción");
                    continuar = false;
                    break;
            }
    
        }






    }

    //siempre se carga un csv ya que es el formato más estable
    public static List<IUser> loadAllUsers() {
        List<IUser> allUsers = new ArrayList<>();
        String basePath = "./files/";
        String fileName = "usuarios.csv"; // Nombre del archivo CSV
        File file = new File(basePath + File.separator + fileName);
    
        // Verifica si el archivo CSV existe
        if (file.exists()) {
            CSV csvDataSource = new CSV();
            List<IUser> users = csvDataSource.getUsersFromFile(file, 0);
            allUsers.addAll(users);
        } else {
            // Muestra un mensaje de error si el archivo CSV no existe
            System.out.println("Error: Es necesario tener un archivo CSV para iniciar el programa.");
            System.exit(0);
        }
        return allUsers;
    }
    

    private static int menu(Scanner scanner){
        int option;

        System.out.println("Menú:");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Crear cuenta");
        System.out.println("3. Salir");
        System.out.println("Ingrese el número de la opción que desea seleccionar:");

        option = scanner.nextInt(); scanner.nextLine();

        return option;
    }

    private static int iniciarSesion(Scanner scanner){
        String firstName;
        System.out.println("Bienvenido al inicio de sesión\nIngrese su primer nombre:");
        firstName = scanner.nextLine();
        String basePath = "./files/"; 

        // tipos de archivos que pueden llegar a existir
        String[] fileNames = {"usuarios.xml", "usuarios.json", "usuarios.csv"};
        
        // Clases correspondientes para cada tipo de archivo, implementación de factory
        IDataSource[] dataSources = {new XML(), new JSON(), new CSV()};
        
        for (int i = 0; i < fileNames.length; i++) {
            File file = new File(basePath + File.separator + fileNames[i]);
            if (file.exists()) {
                List<IUser> users = dataSources[i].getUsersFromFile(file, i); 
                for (IUser user : users) {
                    if (user.getFirstName().equalsIgnoreCase(firstName)) {
                        return 0; // Usuario encontrado
                    }
                }
            }
        }
        // Usuario no encontrado o archivos no existen
        return 1;
    }   

    private static void crearCuenta(Scanner scanner, UsuarioFactory userFactory, List<IUser> allUsers){
        System.out.println("Ingrese su nombre:");
        String firstName = scanner.nextLine();
        System.out.println("Ingrese su apellido:");
        String lastName = scanner.nextLine();
        System.out.println("Ingrese el ID de usuario:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el tipo de usuario (1-Estudiante, 2-Docente, 3-Auditor, 4-Administrativo):");
        int userType = Integer.parseInt(scanner.nextLine());
    
        IUser user = UsuarioFactory.createUser(userType, firstName, lastName, id);
        // Agrega el nuevo usuario directamente a la lista en memoria.
        allUsers.add(user);
        
        System.out.println("Seleccione el formato para guardar la información (1-XML, 2-JSON, 3-CSV):");
        int formatType = Integer.parseInt(scanner.nextLine());
    
        // Llama a saveUser para guardar todos los usuarios, incluido el nuevo, en el archivo seleccionado.
        saveUser(formatType,allUsers);
    }

    private static void saveUser(int formatType, List<IUser> allUsers) {
        String basePath = "./files/";
        String fileName = "usuarios";
        
        // Selecciona la extensión de archivo basada en el tipo de formato
        String fileExtension = formatType == 1 ? ".xml" : formatType == 2 ? ".json" : formatType == 3 ? ".csv" : "";
        File file = new File(basePath + fileName + fileExtension);
    
        // Guardar según el formato seleccionado
        switch (formatType) {
            case 1:
                // Guardar en formato XML
                new XML().saveUsers(allUsers, basePath + fileName);
                // siempre un archivo csv para poder iniciar el programa
                new CSV().saveUsers(allUsers, basePath + fileName);
                break;
            case 2:
                // Guardar en formato JSON
                new JSON().saveUsers(allUsers, basePath + fileName);
                // siempre un archivo csv para poder iniciar el programa
                new CSV().saveUsers(allUsers, basePath + fileName);
                break;
            case 3:
                // siempre un archivo csv para poder iniciar el programa
                new CSV().saveUsers(allUsers, basePath + fileName);
                break;
            default:
                System.out.println("Formato no válido. Por favor seleccione un formato entre 1 y 3.");
                break;
        }
    }
    
    


}