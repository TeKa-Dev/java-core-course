package II_primitive_types;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
//        System.out.println(decimalToBinary(61));
        System.out.println(binaryToDecimal("111101"));
    }
//     Переведи число X (любое) из десятичной в двоичную, и число Y (любое) из двоичной в десятичную
//    0 = 000
//    1 = 001
//    2 = 010
//    3 = 011
//    4 = 100
//    5 = 101
//    6 = 110
//    7 = 111
//    61 = 111101

    public static String decimalToBinary(int dec) {
        StringBuilder res = new StringBuilder();
        while (dec > 0) {
            int bit = dec % 2;
            res.insert(0, bit);
            dec /= 2;
            System.out.println(dec);
        }
        return res.toString();
    }
    public static int binaryToDecimal(String bin) {
        int res = 0;
        for (int i = bin.length() - 1, squ = 1; i >= 0; i--, squ *= 2) {
            res += (bin.charAt(i) - '0') * squ;
        }
        return res;
    }

    void convTypes() {
        byte b = 1;
        b = 1 + 1;
        b += b;
        b += 1;
        b++;
        b = (byte) (b + 1);
        b = (byte) (b + b);

        short s = b;

        char c = 1;
        c = (char) b;
        c = (char) s;

        int i = s;
        long l = i;
        float f = l;
        double d = f;

        int x = Integer.MAX_VALUE;  // 2147483647
        float w = i;                // 2.14748365E9
        int y = (int) f;            // 2147483647
        long z = (long) f;          // 2147483648

    }

    // Задача 2.2.2
    // Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
    // В качестве примера написано заведомо неправильное выражение. Исправьте его.
    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    // Задача 2.2.8
    // Реализуйте метод isPowerOfTwo, проверяющий, является ли заданное число по абсолютной величине степенью двойки.
    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    // Задача 2.2.8
    // При определении "палиндромности" строки должны учитываться только буквы и цифры.
    // А пробелы, знаки препинания, а также регистр символов должны игнорироваться. "[^a-zA-Z0-9]"
    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String revers = new StringBuilder(clean).reverse().toString();
        return clean.equals(revers);
    }

    // Задача 2.4.13
    // Реализуйте метод factorial, вычисляющий факториал заданного натурального числа.
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        while (value > 1) {
            result = result.multiply(BigInteger.valueOf(value));
            value--;
        }
        return result;
    }

    // Задача 2.4.14
    // Реализуйте предыдущую задачу с использованием рекурсии.
    public static BigInteger factorial_r(int value) {
        if (value < 2) return BigInteger.ONE;
        return BigInteger.valueOf(value).multiply(factorial(--value));
    }

    //  Задача 2.4.15
    // В спортивном центре есть три возрастные группы для занятий волейболом
    // 1 - от 7 до 13 лет 2 - от 14 до 17 лет 3 - от 18 до 65 лет.
    // Напишите публичный нестатичный метод determineGroup который принимает возраст человека и возвращает целое число,
    // которое обозначает номер группы в которую его надо определить, если подходящей группы нет - верните -1.
    public static int determineGroup(int age) {
//        int first = 14;
//        int second = 18;
//        int third = 66;
//        if (age > 0 && age < third) {
//            if (age < first) {
//                return 1;
//            } else if (age < second) {
//                return 2;
//            } else {
//                return 3;
//            }
//        }
//        return -1;
        return (age > 0 && age < 66) ? ((age < 14) ? 1 : ((age < 18) ? 2 : 3)) : -1;
    }

    //  Задача 2.4.16
    // Напишите метод printOddNumbers, который принимает массив и выводит в консоль только нечетные числа из него,
    // через запятую. Конец вывода должен перевести курсор на новую строку.
    public static void printOddNumbers(int[] arr) {
        StringBuilder res = new StringBuilder();
        for (int i : arr) {
            if (i % 2 != 0) {
                res.append(',').append(i);
            }
        }
        if (!res.isEmpty()) {
            System.out.println(res.substring(1));
        }
    }

    //  Задача 2.4.17
    // Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив.
    public static int[] mergeArrays(int[] a, int[] b) {
//        int[] res = new int[a1.length + a2.length];
//        for (int i = 0, j = 0; i + j < res.length;) {
//            if (i < a1.length && j < a2.length && a1[i] < a2[j]) {
//                res[i + j] = a1[i]; i++;
//            }
//            else if (j < a2.length) {
//                res[i + j] = a2[j]; j++;
//            }
//            else  {
//                res[i + j] = a1[i]; i++;
//            }
//        }
//        return res;
        int[] res = new int[a.length + b.length];
        for (int i = 0, j = 0; i < a.length || j < b.length; ) {
            res[i + j] = (i < a.length && (j == b.length || a[i] < b[j])) ? a[i++] : b[j++];
        }
        return res;
    }

    // Задача 2.4.18
    // Вам дан список ролей и сценарий пьесы в виде массива строчек.
    // Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового текста
    public static String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder res = new StringBuilder();

        for (String role : roles) {
            res.append(role).append(":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role.concat(":"))) {
                    res.append(i + 1).append(')').append(textLines[i].substring(role.length() + 1)).append('\n');
                }
            }
            res.append('\n');
        }
        return res.toString();
    }

    public static void pieceTest() {

        String[] roles = new String[]{
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"
        };
        String[] texts = new String[]{
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
        System.out.println(printTextPerRole(roles, texts));
    }

}
