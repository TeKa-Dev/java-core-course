package module_7_lambdas.lesson_7_2_12;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

/*
Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
и в конце выводящую 10 наиболее часто встречающихся слов.
 */
public class RifeWord {

    public static void main(String[] args) {

        Map<String, Integer> wordMap = new HashMap<>();

        new Scanner(System.in)
                .useDelimiter("[^\\p{L}\\p{Digit}]+")
                .forEachRemaining(s -> wordMap.merge(s.toLowerCase(), 1, Integer::sum));

        wordMap.entrySet()
                .stream()
                .sorted(Comparator
                        .<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }



// Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
// consectetur
// faucibus
// ipsum
// lorem
// adipiscing
// amet
// dolor
// eget
// elit
// mi
}
