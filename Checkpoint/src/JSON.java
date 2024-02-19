import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSON implements IDataSource {

    private Gson gson = new Gson();

    @Override
    public File saveUsers(List<IUser> users, String path) {
        File file = new File(path+".json");
        try (Writer writer = new FileWriter(file)) {
            // Convierte la lista de usuarios a JSON y la guarda en el archivo
            Type typeOfSrc = new TypeToken<List<IUser>>() {}.getType();
            gson.toJson(users, typeOfSrc, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public List<IUser> getUsersFromFile(File file, int fileType) {
        try (Reader reader = new FileReader(file)) {
            // Lee el archivo JSON y convierte el contenido a una lista de IUser
            Type typeOfT = new TypeToken<List<IUser>>() {}.getType();
            return gson.fromJson(reader, typeOfT);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
