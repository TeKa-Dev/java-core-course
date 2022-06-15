package module_6_collections.lesson_6_2_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
Магазину нужно сохранять информацию о продажах для каждого сотрудника.
Напишите метод Map getSalesMap(Reader reader) который принимает Reader содержащий строки вида:

Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000
Метод должен получить все строки из Reader и заполнить и вернуть карту где ключом будет имя сотрудника,
а значением сумма всех его продаж.
Пример ввода:

Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000
Пример вывода:
{Алексей=[10000], Дмитрий=[9000], Антон=[11000]}
 */
public class Market {
    public static void main(String[] args) throws IOException {
        Reader reader = new StringReader(
                "Алексей 3000\n" +
                   "Дмитрий 9000\n" +
                   "Антон 3000\n" +
                   "Алексей 7000\n" +
                   "Антон 8000");
        System.out.println(getSalesMap(reader));
    }

    public static Map<String, Long> getSalesMap(Reader reader) {

        Map<String, Long> salesMap = new LinkedHashMap<>();
        Scanner scn = new Scanner(reader);

        while (scn.hasNext()) {

            salesMap.merge(scn.next(), scn.nextLong(), Long::sum);
        }
        return salesMap;
    }
}
