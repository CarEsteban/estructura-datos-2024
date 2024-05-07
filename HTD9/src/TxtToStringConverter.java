import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtToStringConverter {
    public String readFileToString(String filePath) throws IOException {
        byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(encodedBytes);
    }
}
