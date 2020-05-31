package mk.ukim.finki.vcc.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatrixMultiplicationTest {

    @DisplayName("Matrix multiplication")
    @Test
    public void testMatrixMultiplication() {
        final long[][] matrix1 = new long[][] { { 1L, 2L, 3L }, { 4L, 5L, 6L } };
        final long[][] matrix2 = new long[][] { { 7L, 8L }, { 9L, 10L }, { 11L, 12L } };
        final long[][] expected = new long[][] { { 58L, 64L }, { 139L, 154L } };
        final long[][] result = MatrixMultiplication.multiply(matrix1, matrix2);
        
        assertEquals(expected.length, result.length);
        assertEquals(expected[0].length, result[0].length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                assertEquals(expected[i][j], result[i][j]);
            }
        }
    }
}
