package module_1_introduction_to_Java;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) throws IOException {

        int i = LambdaEx.FunInt.i;

        Collection<Integer> col = new ArrayDeque<>();
        col.add(1);
        col.add(2);
        col.add(3);
        col.add(4);
        col.stream().forEach(System.out::println);


    }


    public static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

//      получение стрима
    void getStream() throws IOException {
        Stream<Float> empty = Stream.empty();
        LongStream of = LongStream.of(1L, 2L, 3L);
        IntStream chars = "foo bar baz".chars();
        IntStream range = IntStream.range(0, 10);
        IntStream concat = IntStream.concat(chars, range);

        IntStream iter = IntStream.iterate(1, n -> n + 1);
        DoubleStream random = DoubleStream.generate(Math::random);

        Stream<String> array = Arrays.stream(new String[]{"foo", "bar", "baz"});

        Stream<String> collect = (new ArrayList<>(Arrays.asList("foo", "bar", "baz"))).stream();

        Stream<String> reader = (new BufferedReader(new CharArrayReader(("foo bar baz").toCharArray()))).lines();

        Stream<Path> path = Files.walk(Paths.get("/directory/"));
    }

//    промежуточные операции со стримами
    void operationStream(IntStream iStream) {
        iStream.filter(n -> n > 10)                 // фильтр по Predicate
                .mapToObj(Integer::toString)        // преобразование по IntFunction с int в Object
                .flatMapToInt(String::chars)        // преобразование по Function с Object в Integer
                .distinct()                         // удаляет дубликаты из стрима
                .sorted()                           // сортировка по возрастанию, можно передать Comparator
                .peek(System.out::println)          // применяет Consumer для каждого элемента
                .skip(5)                            // пропуск элементов
                .limit(10)                          // лимит элементов
                .peek(System.out::println);
    }

//    терминальные операции, запуск стрима на выполнение, после чего он будет не пригоден
    void terminalStream(IntStream is, Stream<String> ss) {
        is.forEach(System.out::println);                    // цикл принимает Consumer
        int res = is.reduce(1, (x, y) -> x * y);    // результат применения операции к каждому элементу стрима
                                                           // (свёртка), если стрим пуст то возвращается identity

        long count = is.count();                            // возвращает количество оставшихся элементов
        int sum = is.sum();                                 // сумма оставшихся элементов
        OptionalInt first = is.findFirst();                 // возвращает первый элемент
        Optional<String> minStr = ss.min(                   // минимальный элеиент по Comparator
                Comparator.comparing(
                        String::length, Integer::compare
                ));

        boolean all10 = ss.allMatch(s -> s.length() == 10); // true если все элементы по Predicate
        boolean any10 = ss.anyMatch(s -> s.length() == 10); // rue если хоть один элемент по Predicate


    }

}
