import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        try {
            // Convertir el archivo de texto a una cadena
            TxtToStringConverter converter = new TxtToStringConverter();
            String text = converter.readFileToString("./src/texto_prueba.txt");
            
            // Codificar el texto usando Huffman
            Huffman huffman = new Huffman(text);
            String huffmanCode = huffman.encode();
            
            // Convertir el código Huffman a un array de bytes
            List<Byte> byteList = new ArrayList<>();
            
            for (int i = 0; i < huffmanCode.length(); i += 8) {
                String byteString = huffmanCode.substring(i, Math.min(i + 8, huffmanCode.length()));
                // Asegurar que tenga 8 bits agregando ceros al final si es necesario
                while (byteString.length() < 8) {
                    byteString += "0";
                }
                // Convertir el string de bits a un byte
                int byteValue = Integer.parseInt(byteString, 2);
                // Restar 128
                byteValue -= 128;
                // Agregar a la lista
                byteList.add((byte) byteValue);
            }

            // Escribir los bytes a un archivo binario .huff
            try (FileOutputStream fos = new FileOutputStream("./src/output.huff")) {
                for (byte b : byteList) {
                    fos.write(b);
                }
            }

            System.out.println("Archivo .huff creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
