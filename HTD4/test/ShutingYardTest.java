package HTD4.test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ShutingYardTest {
    
    private ShutingYardTest sy;

    @Before
    public void setUp() {
        // Asume que tienes una implementación de IStack<Character> que puedes utilizar aquí.
        IStack<Character> stack = new StackWithArrayList<>(); // Reemplaza esto con tu implementación concreta
        sy = new ShutingYard(stack);
    }

    @Test
    public void testOutput() {
        // Dado que output depende del estado interno cambiado por parseExpression, 
        // necesitamos llamar a parseExpression con una expresión conocida primero.
        sy.parseExpression("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3");
        String result = sy.output();
        // La salida esperada debe coincidir con la conversión correcta a postfix
        // Esta es una expresión ejemplo, ajusta la salida esperada según tu implementación y la expresión dada.
        assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / +", result);
    }

    @Test
    public void testParseExpression() {
        // Este test es similar al anterior porque parseExpression no retorna un valor directamente,
        // su correcta ejecución se verifica a través del resultado de output.
        sy.parseExpression("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3");
        String result = sy.output();
        // Verificar de nuevo la salida esperada
        assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / +", result);
    }
}
