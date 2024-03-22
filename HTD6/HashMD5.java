import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 implements IHash{
    /**
     * Método que genera un hash MD5 de un valor
     * @param value
     * @return hash
     */
    @Override
    public String generateHash(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(value.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}