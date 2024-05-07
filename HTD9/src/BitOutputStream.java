import java.io.IOException;
import java.io.OutputStream;

public class BitOutputStream implements AutoCloseable {
    private OutputStream out;
    private int buffer;
    private int bitsRestantes;

    public BitOutputStream(OutputStream out) {
        this.out = out;
        buffer = 0;
        bitsRestantes = 0;
    }

    public void escribirBit(int bit) throws IOException {
        buffer = (buffer << 1) | (bit & 1);
        bitsRestantes++;
        if (bitsRestantes == 8) {
            vaciarBuffer();
        }
    }

    private void vaciarBuffer() throws IOException {
        if (bitsRestantes == 0) return;
        out.write(buffer << (8 - bitsRestantes));
        buffer = 0;
        bitsRestantes = 0;
    }

    @Override
    public void close() throws IOException {
        vaciarBuffer();
        out.close();
    }
}
