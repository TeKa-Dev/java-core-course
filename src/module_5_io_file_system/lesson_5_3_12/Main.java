package module_5_io_file_system.lesson_5_3_12;

import java.util.Scanner;

/*
Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте
вещественных чисел с точностью до шестого знака после запятой. Числом считается последовательность символов,
отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.

Пример ввода 2: a1 b2 c3
Пример вывода 2: 0.000000

Пример ввода 3:  -1e3 18 .111 11bbb
Пример вывода 3: -981.889000
 */
public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        double res = 0d;

        while (scn.hasNext()) {
            try {
                res += scn.nextDouble();
            } catch (Exception e) {
                scn.next();
            }
        }
        System.out.printf("%.6f", res);
    }

}
