import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;

public class LectorArchivo {
    private FactoryMaps<String, Estudiante> factoryMaps;
    /**
     * Constructor de la clase LectorArchivo
     * @param factoryMaps
     */
    public LectorArchivo(FactoryMaps<String, Estudiante> factoryMaps) {
        this.factoryMaps = factoryMaps;
    }
    /**
     * Método que lee un archivo JSON y retorna un mapa con los estudiantes
     * @param filePath
     * @param estudiantesMap
     * @param hashMethod
     * @return estudiantesMap
     */
    @SuppressWarnings("unchecked")
    public AbstractMap<String, Estudiante> leerArchivo(String filePath, AbstractMap<String, Estudiante> estudiantesMap, IHash hashMethod) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);

            JSONArray estudiantes = (JSONArray) obj;

            estudiantes.forEach(estudiante -> parseEstudianteObject((JSONObject) estudiante, estudiantesMap, hashMethod));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return estudiantesMap;
    }
    /**
     * Método que parsea un objeto JSON de estudiante y lo agrega al mapa de estudiantes
     * @param estudiante
     * @param estudiantesMap
     * @param hashMethod
     */
    private void parseEstudianteObject(JSONObject estudiante, AbstractMap<String, Estudiante> estudiantesMap, IHash hashMethod) {
        String name = (String) estudiante.get("name");
        String hashName = hashMethod.generateHash(name);
        String phone = (String) estudiante.get("phone");
        String email = (String) estudiante.get("email");
        String postalZip = (String) estudiante.get("postalZip");
        String country = (String) estudiante.get("country");
    
        estudiantesMap.put(hashName, new Estudiante(name, phone, email, postalZip, country));
    }
}
