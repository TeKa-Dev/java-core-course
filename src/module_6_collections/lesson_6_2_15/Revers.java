package module_6_collections.lesson_6_2_15;

/*
Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами, затем удалит из них
все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.

Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2
 */

import java.io.IOException;
import java.util.*;

public class Revers {
public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    Deque<String> buffer = new LinkedList<>();

    while (scn.hasNext()) {
        scn.next();
        if (scn.hasNext())
        buffer.addFirst(scn.next());
    }
    System.out.print(String.join(" ", buffer));
}

//    public static void main (String[]args) throws IOException {
//
//        Set<Integer> set = new LinkedHashSet<>();
//        Scanner scanner = new Scanner(System.in);
//
//        scanner.forEachRemaining(s -> set.add(new Integer(s)));
//        Iterator<Integer> iterator = set.iterator();
//        boolean evenNumber = true;
//        while (iterator.hasNext()) {
//            iterator.next();
//            if (evenNumber) {
//                iterator.remove();
//            }
//            evenNumber = !evenNumber;
//        }
//        Integer[] integers = new Integer[set.size()];
//        set.toArray(integers);
//
//        for (int i = integers.length - 1; i > -1; i--) {
//            System.out.print(integers[i]);
//            if (i > 0) {
//                System.out.print(" ");
//            }
//        }
//    }


}
