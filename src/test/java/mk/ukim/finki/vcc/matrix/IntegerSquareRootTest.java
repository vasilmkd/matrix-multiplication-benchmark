package mk.ukim.finki.vcc.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSquareRootTest {
    
    @DisplayName("Integer square root")
    @Test
    public void testIsqr() {
        int result = IntegerSquareRoot.isqrt(6);
        assertEquals(2, result);
    }

    @DisplayName("Integer square root of full square")
    @Test
    public void testFullSquare() {
        int result = IntegerSquareRoot.isqrt(9);
        assertEquals(3, result);
    }
}