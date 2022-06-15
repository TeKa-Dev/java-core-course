package module_7_function.lesson_7_2_11;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

/*
Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator 'ом.
Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
minMaxConsumer.accept(min, max);
Если стрим не содержит элементов, то вызовите:
minMaxConsumer.accept(null, null);
 */
public class MinMax {

    public static void main(String[] args) {
        BiConsumer<Integer, Integer> bc = (a, b) -> System.out.println(a + " " + b);
        findMinMax(Stream.empty(), Comparator.comparingInt((Integer a) -> a), bc);
        findMinMax(Stream.of(1, 8, 3, 5, 0, 7), Comparator.comparingInt((Integer a) -> a), bc);
    }


    static Object min;
    static Object max;

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        stream.forEach((Consumer<T>) t -> {
            if (min == null || order.compare(t, (T) min) < 0) {
                min = t;
            }
            if (max == null || order.compare(t, (T) max) > 0) {
                max = t;
            }
        });
        minMaxConsumer.accept((T) min, (T) max);
    }


    public static <T> void fndMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T[] els = (T[]) stream.sorted(order).toArray();
        if (els.length == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(els[0], els[els.length - 1]);
        }
    }


    public static <T> void fMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T[] minMax = (T[]) new Object[2];
        stream.forEach((Consumer<T>) t -> {
            if (minMax[0] == null || order.compare(t, minMax[0]) < 0) {
                minMax[0] = t;
            }
            if (minMax[1] == null || order.compare(t, minMax[1]) > 0) {
                minMax[1] = t;
            }
        });
        minMaxConsumer.accept(minMax[0], minMax[1]);
    }
}
