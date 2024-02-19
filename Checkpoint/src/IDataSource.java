import java.io.File;
import java.util.List;

public interface IDataSource {
    public File saveUsers(List<IUser> users, String path);

    public List<IUser> getUsersFromFile(File file, int fileType);
}
