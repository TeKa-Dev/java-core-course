package module_7_function.lesson_7_1_9;

import java.util.function.Function;
import java.util.function.Predicate;

/*
Дан предикат condition и две функции ifTrue и ifFalse. Напишите метод ternaryOperator, который из них построит
новую функцию, возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.

Predicate<Object> condition = Objects::isNull;
Function<Object, Integer> ifTrue = obj -> 0;
Function<CharSequence, Integer> ifFalse = CharSequence::length;
Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
Результирующая функция будет для нулевых ссылок на String возвращать 0, а для ненулевых ссылок возвращать длину строки.
 */
public class Lambda {

    public <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

}
