package module_7_lambdas.lesson_7_2_11;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
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

    }


    public <T> void findMinMax(
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