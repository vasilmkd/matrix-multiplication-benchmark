package mk.ukim.finki.vcc.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DivideCPUSTest {
    
    @DisplayName("Divide CPUS")
    @Test
    public void testDivideCPUS() {
        Pair<Integer, Integer> division = DivideCPUS.divideCPUS(8);
        assertEquals(2, division.getFirst());
        assertEquals(4, division.getSecond());
    }

    @DisplayName("Divide CPUS full square")
    @Test
    public void testFullSquare() {
        Pair<Integer, Integer> division = DivideCPUS.divideCPUS(9);
        assertEquals(3, division.getFirst());
        assertEquals(3, division.getSecond());
    }

    @DisplayName("Divide CPUS prime number")
    @Test
    public void testPrimeNumber() {
        Pair<Integer, Integer> division = DivideCPUS.divideCPUS(17);
        assertEquals(1, division.getFirst());
        assertEquals(17, division.getSecond());
    }
}