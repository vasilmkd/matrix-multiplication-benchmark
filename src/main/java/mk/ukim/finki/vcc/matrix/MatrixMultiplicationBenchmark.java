package mk.ukim.finki.vcc.matrix;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

public class MatrixMultiplicationBenchmark {

    @State(Scope.Thread)
    public static class MatrixState {
        @Param({ "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "200", "300", "400", "500", "600", "700",
                "800", "900", "1000" })
        private int size;

        private long[][] firstMatrix;
        private long[][] secondMatrix;

        @Setup(Level.Trial)
        public void setup() throws InterruptedException {
            firstMatrix = new long[size][size];
            secondMatrix = new long[size][size];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    firstMatrix[i][j] = random.nextLong();
                    secondMatrix[i][j] = random.nextLong();
                }
            }
        }

        public int getSize() {
            return size;
        }

        public long[][] getFirstMatrix() {
            return firstMatrix;
        }

        public long[][] getSecondMatrix() {
            return secondMatrix;
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MINUTES)
    public long[][] multiplication(MatrixState state) {
        return MatrixMultiplication.multiply(state.getFirstMatrix(), state.getSecondMatrix());
    }
}
