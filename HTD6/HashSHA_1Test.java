import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HashSHA_1Test {
    @Test
    public void testGenerateHash() {
        String value = "Hola, mundo!";
        HashSHA_1 hashSHA_1 = new HashSHA_1();

        String hash = hashSHA_1.generateHash(value);
        assertNotNull(hash);
        assertEquals("f7ff9e8b7bb2e09b70935a5d785e0cc5d9d0abf0", hash);
    }
}
