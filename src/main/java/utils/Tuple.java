package utils;

public class Tuple<A, B> {
    public A _1;
    public B _2;
    private Tuple(A a, B b) {
        this._1 = a;
        this._2 = b;
    }
    public static <A, B> Tuple<A, B> tuple(A a, B b) {
        return new Tuple<>(a, b);
    }
    @Override
    public String toString() {
        return String.format("(%s, %s)", this._1, this._2);
    }
}
