package module_1_introduction_to_Java;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx {
    static int n = 5;

    public static void main(String[] args) {

        int[] arr = {FunInt.i};

//        AbsClass ac = i -> i;

        FunInt fi = i -> n = n + 1;
        FunInt fa = i -> arr[0] = arr[0] + 1;

        System.out.println(fi.method(8));
        System.out.println(fa.method(8));
        System.out.println(arr[0]);
        System.out.println(n);

        StreamEx se = new StreamEx() {   };
        Comparable as;
        Comparator ct;
        Function fu;

//        String str = new String(){};

//        FunInt f = o -> o.length + FunInt.i;
//        met(f);

    }

    static void met(FunInt f) {
        System.out.println(f.method(7));
    }


    static Consumer<String> print = System.out::println;
    static Supplier<Integer> number = () -> 55;
    static Function<Integer, String> intToStr = String::valueOf;
    static Predicate<Integer> isNat = n -> n > 0;

    public static void testLambda() {
        String s = "string";
        print.accept(s);
        print.accept(intToStr.apply(number.get()));
        print.accept(String.valueOf(isNat.test(12)));
    }

    public interface FunInt {
        public static int i = 10;
        abstract int method(int i);
    }
}

abstract class AbsClass {
    abstract int absMet(int i);
}
//@FunctionalInterface
//interface FunInt {
//    public static int i = 10;
//    abstract int method(int i);
//}
