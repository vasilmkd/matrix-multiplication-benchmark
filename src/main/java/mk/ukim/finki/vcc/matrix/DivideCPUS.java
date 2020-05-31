package mk.ukim.finki.vcc.matrix;

public class DivideCPUS {
    
    public static Pair<Integer, Integer> divideCPUS(final int cpus) {
        final int low = low(cpus);
        final int high = cpus / low;
        return Pair.of(low, high);
    }

    private static int low(final int cpus) {
        final int isqrt = IntegerSquareRoot.isqrt(cpus);
        for (int low = isqrt; low >= 2; low--) {
            if (cpus % low == 0) {
                return low;
            }
        }
        return 1;
    }
}