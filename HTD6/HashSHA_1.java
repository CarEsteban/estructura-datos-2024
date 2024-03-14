import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSHA_1 implements IHash {
    @Override
    public String generateHash(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            digest.update(value.getBytes());

            byte[] bytes = digest.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
