package module_1_introduction_to_Java;

import java.util.Collection;

public class GenericEx<F> {
    F field;
    F[] arrFie;
    GenericEx<F> gen;
//    static F stField;
//    static GenericEx<F> stcGen;
    static GenericEx<Integer> genStr;

    GenericEx() {}
    GenericEx(F field) {
        this.field = field;
    }
    GenericEx(F field, F[] arrFie) {
        this.field = field;
        this.arrFie = arrFie;
    }
//    public GenericEx<F>() {}

    F method(Object[] arrF) {
//        F res = new F();
//        F[] arr = new F[0];
        F res = (F) arrF[0];
        return res;
    }

//  static F method() {}

//  static GenericEx<F> method() { return new GenericEx<>(); }

    static <I> GenericEx<I> method(I i) {  return new GenericEx<>(i); }

    static <I> I method(Collection<I> c) {  return (I) new GenericEx<>(c); }

    GenericEx<F> method() { return new GenericEx<>(field, arrFie); }

    <T> GenericEx<T> method(T t, T[] tar) {
        return new GenericEx<>(t, tar);
    }

    @Override
    public String toString() {
        return "GenericEx{" +
                "field = " + field +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(GenericEx.method("str"));
    }
}
