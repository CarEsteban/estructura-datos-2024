import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class HuffmanTest {

    @Test
    public void testEncodeAndDecode() throws IOException {
        // Leer el contenido del archivo de texto_prueba.txt
        String filePath = "./src/texto_prueba.txt";
        String text = new String(Files.readAllBytes(Paths.get(filePath)));
        
        // Crear un objeto Huffman
        Huffman huffman = new Huffman(text);
        
        // Codificar el texto
        String encodedText = huffman.encode();
        
        // Decodificar el texto codificado
        String decodedText = huffman.decode(encodedText);
        
        // Verificar que el texto decodificado sea igual al original
        assertEquals(text, decodedText);
    }
}

