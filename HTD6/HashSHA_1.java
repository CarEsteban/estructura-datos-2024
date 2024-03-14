import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSHA_1 implements IHash {
    @Override
    public String generateHash(String value) {
        try {
            // Crear instancia de MessageDigest para SHA-1
            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            // Actualizar el digest utilizando el valor de entrada en bytes
            digest.update(value.getBytes());

            // Completar el cálculo del hash
            byte[] bytes = digest.digest();

            // Convertir el hash byte a byte en hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            // Devolver el hash en formato hexadecimal
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // En caso de que el algoritmo SHA-1 no esté disponible
            throw new RuntimeException(e);
        }
    }
}
