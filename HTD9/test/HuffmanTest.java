import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class HuffmanTest {
    @Test
    public void testDecode() {
        // Given
        String text = "exampletext";
        Huffman huffman = new Huffman(text);
        String encodedText = huffman.encode();

        // When
        String decodedText = huffman.decode(encodedText);

        // Then
        assertEquals(text, decodedText);
    }

    @Test
    public void testEncode() {
        // Given
        String text = "exampletext";
        Huffman huffman = new Huffman(text);

        // When
        String encodedText = huffman.encode();

        // Then
        // Write assertions based on the expected encoded text
        // Example assertions:
        assertEquals("100001011111110011101101000110", encodedText);
    }

    @Test
    public void testGenerateFrequencyTable() {
        // Given
        String text = "exampletext";
        Huffman huffman = new Huffman(text);

        // When
        Map<Character, Integer> frequencyTable = huffman.generateFrequencyTable(text);

        // Then
        // Write assertions based on the expected frequency table
        // Example assertions:
        assertEquals(3, (int) frequencyTable.get('e'));
        assertEquals(2, (int) frequencyTable.get('x'));
    }

    @Test
    public void testGetHuffmanCodes() {
        // Given
        String text = "exampletext";
        Huffman huffman = new Huffman(text);

        // When
        Map<Character, String> huffmanCodes = huffman.getHuffmanCodes();

        // Then
        // Write assertions based on the expected Huffman codes
        // Example assertions:
        assertEquals("10", huffmanCodes.get('e'));
        assertEquals("010", huffmanCodes.get('a'));
    }
}
