package mk.ukim.finki.vcc.matrix;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMultiplication {

    public static long[][] multiply(final long[][] firstMatrix, final long[][] secondMatrix) {
        assert firstMatrix.length > 0;
        assert firstMatrix[0].length > 0;
        assert secondMatrix.length > 0;
        assert secondMatrix[0].length > 0;
        assert firstMatrix.length == secondMatrix[0].length;
        assert firstMatrix[0].length == secondMatrix.length;

        final CountDownLatch latch = new CountDownLatch(CPUS);

        final long[][] transposedSecondMatrix = transpose(secondMatrix);
        final int rows = firstMatrix.length;
        final int cols = transposedSecondMatrix.length;
        final long[][] result = new long[rows][cols];

        final Pair<Integer, Integer> division = DivideCPUS.divideCPUS(CPUS);
        final int rowDiv = (int) (rows / ((double) division.getFirst()));
        final int rowStep = rowDiv > 0 ? rowDiv : 1;
        final int colDiv = (int) (cols / ((double) division.getSecond()));
        final int colStep = colDiv > 0 ? colDiv : 1;

        for (int i = 0; i < division.getFirst(); i++) {
            final int startRow = i * rowStep;
            final int endRow = (i + 1) * rowStep;
            for (int j = 0; j < division.getSecond(); j++) {
                final int startCol = j * colStep;
                final int endCol = (j + 1) * colStep;
                executor.submit(execute(startRow, endRow, startCol, endCol, firstMatrix, transposedSecondMatrix, result,
                        latch));
            }
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static final int CPUS = Runtime.getRuntime().availableProcessors();

    private static final ExecutorService executor = Executors.newFixedThreadPool(CPUS);

    private static Runnable execute(final int startRow, final int endRow, final int startCol, final int endCol,
            final long[][] firstMatrix, final long[][] transposedSecondMatrix, final long[][] result,
            final CountDownLatch latch) {
        return () -> {
            for (int row = startRow; row < endRow; row++) {
                if (row >= firstMatrix.length)
                    continue;
                for (int col = startCol; col < endCol; col++) {
                    if (col >= transposedSecondMatrix.length)
                        continue;
                    result[row][col] = dotProduct(firstMatrix[row], transposedSecondMatrix[col]);
                }
            }
            latch.countDown();
        };
    }

    private static long[][] transpose(final long[][] matrix) {
        assert matrix.length > 0;
        assert matrix[0].length > 0;

        final int rows = matrix.length;
        final int cols = matrix[0].length;
        final long[][] result = new long[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    private static long dotProduct(final long[] row, final long[] col) {
        assert row.length == col.length;

        long result = 0;
        for (int i = 0; i < row.length; i++) {
            result += (row[i] * col[i]);
        }

        return result;
    }
}