package module_6_collections.lesson_6_2_13;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Реализуйте метод symmetricDifference, вычисляющий симметрическую разность двух множеств.
Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример ввода: [1, 2, 3} и {0, 1, 2]
Пример вывода: [0, 3]
 */
public class Symmetric {
    public static void main(String[] args) {
        Set<Integer> out = symmetricDifference(
                new HashSet<>(List.of(new Integer[]{1, 2, 3})),
                new HashSet<>(List.of(new Integer[]{0, 1, 2})));
        System.out.println(out);

    }


public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
    Set<T> res = new HashSet<>(set1);
    for (T e : set2) {
        if (set1.contains(e)) {
            res.remove(e);
        } else {
            res.add(e);
        }
    }
    return res;
}

}
