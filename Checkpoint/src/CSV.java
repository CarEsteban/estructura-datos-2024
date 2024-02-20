import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV implements IDataSource {

    @Override
    public File saveUsers(List<IUser> users, String path) {
        File file = new File(path + ".csv");
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            // Escribe el encabezado del CSV
            pw.println("Tipo,ID,Nombre,Apellido");
    
            // Itera sobre los usuarios y escribe sus datos
            for (IUser user : users) {
                String line = getTypeFromUser(user) + "," + user.getId() + "," + user.getFirstName() + "," + user.getLastName();
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    

    @Override
    public List<IUser> getUsersFromFile(File file, int fileType) {
        List<IUser> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true; // Agrega una bandera para identificar la primera línea
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Ignora la primera línea (encabezado)
                    continue;
                }
                String[] data = line.split(",");
                // Asegúrate de que la línea tiene el número esperado de elementos
                if (data.length >= 4) {
                    IUser user = UsuarioFactory.createUser(Integer.parseInt(data[0]), data[2], data[3], Integer.parseInt(data[1]));
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    

    // Método auxiliar para obtener el tipo numérico de usuario basado en la instancia de IUser
    private int getTypeFromUser(IUser user) {
        if (user instanceof Estudiante) {
            return 1;
        } else if (user instanceof Docente) {
            return 2;
        } else if (user instanceof Auditor) {
            return 3;
        } else if (user instanceof Administrativo) {
            return 4;
        }
        return 0; // Tipo desconocido o no asignado
    }
}
