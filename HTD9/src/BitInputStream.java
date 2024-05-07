import java.io.IOException;
import java.io.InputStream;

public class BitInputStream implements AutoCloseable {
    private InputStream in;
    private int buffer;
    private int bitsRestantes;

    public BitInputStream(InputStream in) {
        this.in = in;
        buffer = 0;
        bitsRestantes = 0;
    }

    public int leerBit() throws IOException {
        if (bitsRestantes == 0) {
            buffer = in.read();
            if (buffer == -1) return -1;
            bitsRestantes = 8;
        }
        bitsRestantes--;
        return (buffer >> bitsRestantes) & 1;
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
