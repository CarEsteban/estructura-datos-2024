import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class LectorArchivo {
    private FactoryMaps<String, Estudiante> factoryMaps;

    public LectorArchivo(FactoryMaps<String, Estudiante> factoryMaps) {
        this.factoryMaps = factoryMaps;
    }

    public AbstractMap<String, Estudiante> leerArchivo(String filePath, AbstractMap<String, Estudiante> estudiantesMap) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);

            JSONArray estudiantes = (JSONArray) obj;

            estudiantes.forEach(estudiante -> parseEstudianteObject((JSONObject) estudiante, estudiantesMap));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return estudiantesMap;
    }

    private void parseEstudianteObject(JSONObject estudiante, AbstractMap<String, Estudiante> estudiantesMap) {
        String name = (String) estudiante.get("name");
        String phone = (String) estudiante.get("phone");
        String email = (String) estudiante.get("email");
        String postalZip = (String) estudiante.get("postalZip");
        String country = (String) estudiante.get("country");

        Estudiante newEstudiante = new Estudiante(name, phone, email, postalZip, country);
        estudiantesMap.put(name, newEstudiante);
    }
}
