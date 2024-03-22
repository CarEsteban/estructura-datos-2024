import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HashOrganicaTest {
    @Test
    public void testGenerateHash() {
        String value = "Hola, mundo!";
        HashOrganica hashOrganica = new HashOrganica();

        String hash = hashOrganica.generateHash(value);
        assertNotNull(hash);
        assertEquals("9266186613072328", hash);
    }
}
