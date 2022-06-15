package module_7_lambdas.lesson_7_1_8;

/*
Создайте функциональный интерфейс NumberGenerator, параметризованный таким образом,
что принимает только наследников класса Number, имеющий метод boolean cond(T arg).
Создайте в методе public static NumberGenerator<? super Number> getGenerator()
с помощью лямбда выражения реализацию NumberGenerator, которая возвращает true, если число в int эквиваленте больше 0.

1. Должен быть метод public static NumberGenerator<? super Number> getGenerator()
2. Соблюдайте код стайл при параметризации.
3. Имя параметра должно быть "Т"
4. Метод должен возвращать корректную реализацию
 */
public class NumGenerator {
    public static void main(String[] args) {
        System.out.println(getGenerator().cond(1));
        System.out.println(getGenerator().cond(0));
        System.out.println(getGenerator().cond(-1));

        System.out.println(getGenerator().cond(-0.5d));
        System.out.println(getGenerator().cond(0.5f));
    }

@FunctionalInterface
interface NumberGenerator<N extends Number> {
    boolean cond(N arg);
}

public static NumberGenerator<? super Number> getGenerator() {
    return n -> n.intValue() > 0;
}

}
