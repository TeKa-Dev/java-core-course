package module_7_function.lesson_7_1_7;

import java.util.function.UnaryOperator;

/*
Напишите метод с названием sqrt, который возвращает реализацию функционального интерфейса UnaryOperator,
который принимает целое число(тип int) и возвращает его квадрат.
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt().apply(3));
    }

    public static UnaryOperator<Integer> sqrt() {
        return n -> n *= n;
    }
}
