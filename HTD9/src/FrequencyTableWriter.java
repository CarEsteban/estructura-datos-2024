import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FrequencyTableWriter {
    /**
     * Escribe la tabla de frecuencias en un archivo en el formato "carácter: cantidad".
     * @param frequencies Mapa de frecuencias de los caracteres.
     * @param filePath Ruta del archivo de salida.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void writeFrequencyTable(Map<Character, Integer> frequencies, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }
}
