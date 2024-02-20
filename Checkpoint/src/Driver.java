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
                    crearCuenta(scanner, userFactory);
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

    private static void crearCuenta(Scanner scanner, UsuarioFactory userFactory){
        System.out.println("Ingrese su nombre:");
        String firstName = scanner.nextLine();
        System.out.println("Ingrese su apellido:");
        String lastName = scanner.nextLine();
        System.out.println("Ingrese el ID de usuario:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el tipo de usuario (1-Estudiante, 2-Docente, 3-Auditor, 4-Administrativo):");
        int userType = Integer.parseInt(scanner.nextLine());
        System.out.println("Seleccione el formato para guardar la información (1-XML, 2-JSON, 3-CSV):");
        int formatType = Integer.parseInt(scanner.nextLine());
    
        IUser user = UsuarioFactory.createUser(userType, firstName, lastName, id);
        saveUser(user,formatType);
    }

    
    private static void saveUser(IUser user, int formatType) {
        List<IUser> users = new ArrayList<>();
        users.add(user);
    
        String basePath = "./files/";
        File directory = new File(basePath);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                System.out.println("No se pudo crear el directorio de archivos.");
                return; 
            }
        }
        
        // Guardar según el formato seleccionado
        switch (formatType) {
            case 1:
                // Guardar en formato XML
                new XML().saveUsers(users, basePath + "usuarios");
                break;
            case 2:
                // Guardar en formato JSON
                new JSON().saveUsers(users, basePath + "usuarios");
                break;
            case 3:
                // Guardar en formato CSV
                new CSV().saveUsers(users, basePath + "usuarios");
                break;
            default:
                System.out.println("Formato no válido. Por favor seleccione un formato entre 1 y 3.");
                break;
        }
    }


}