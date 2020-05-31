package mk.ukim.finki.vcc.matrix;

import java.util.Objects;

public class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Pair doesn't hold null objects");
        }
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !this.getClass().equals(obj.getClass()))
            return false;
        Pair<?, ?> that = (Pair<?, ?>) obj;
        return Objects.equals(first, that.first) && Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }
}