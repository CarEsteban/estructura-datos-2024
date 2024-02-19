import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV implements IDataSource {

    @Override
    public File saveUsers(List<IUser> users, String path) {
        File file = new File(path+".csv");
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (IUser user : users) {
                // Escribe el tipo de usuario (necesitarás una lógica aquí para determinar el número basado en el tipo de clase), ID, nombre y apellido en el CSV
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
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Asume que el primer elemento es el tipo, el segundo es el ID, el tercero el nombre, y el cuarto el apellido
                IUser user = UsuarioFactory.createUser(Integer.parseInt(data[0]), data[2], data[3], Integer.parseInt(data[1]));
                users.add(user);
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
