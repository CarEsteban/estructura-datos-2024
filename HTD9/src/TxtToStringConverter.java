import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The TxtToStringConverter class provides a method to read the contents of a text file and convert it to a string.
 */
public class TxtToStringConverter {
    /**
     * Reads the contents of the specified text file and converts it to a string.
     *
     * @param filePath the path of the text file to be read
     * @return the contents of the text file as a string
     * @throws IOException if an I/O error occurs while reading the file
     */
    public String readFileToString(String filePath) throws IOException {
        byte[] encodedBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(encodedBytes);
    }
}
