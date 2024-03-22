import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HashMD5Test {
    @Test
    public void testGenerateHash() {
        String value = "Hola, mundo!";
        HashMD5 hashMD5 = new HashMD5();

        String hash = hashMD5.generateHash(value);
        assertNotNull(hash);
        assertEquals("6cd3556deb0da54bca060b4c39479839", hash);

    }
}
