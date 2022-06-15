package module_6_collection.lesson_6_2_15;

/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами, затем удалит из них
все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.

Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2
 */
import java.util.*;

public class Revers {

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    Deque<String> buffer = new ArrayDeque<>();

    while (scn.hasNext()) {
        scn.next();
        if (scn.hasNext()) {
            buffer.addFirst(scn.next() + ' ');
        }
    }
    buffer.forEach(System.out::print);
}

}
